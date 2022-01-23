package cora;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import cora.datafetcher.custom.CustomCoraRepository;
import cora.datafetcher.custom.CustomDataFetcher;
import cora.graph.CoraGraph;
import cora.graph.CoraNode;
import cora.graph.CustomIngress;
import cora.groovy.GroovyScriptService;
import cora.parser.dsl.CoraParser;
import cora.parser.dsl.SDLParser;
import cora.schema.CoraRuntimeWiring;
import cora.schema.CoraTypeRegistry;
import cora.util.StringUtil;
import graphql.GraphQL;
import graphql.com.google.common.base.Function;
import graphql.execution.preparsed.PreparsedDocumentEntry;
import graphql.execution.preparsed.PreparsedDocumentProvider;
import graphql.language.Definition;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static graphql.GraphQL.newGraphQL;

public class CoraBuilder {
    final
    CoraRuntimeWiring coraRuntimeWiring;

    final
    CoraTypeRegistry coraTypeRegistry;

    final
    CoraParser coraParser;

    final MongoTemplate mongoTemplate;

    final GroovyScriptService groovyScriptService;

    @Value("${cora.node.typeCollection}")
    String collectionName;

    private GraphQLSchema graphQLSchema;

    private final SchemaGenerator schemaGenerator = new SchemaGenerator();

    public CoraBuilder(CoraRuntimeWiring coraRuntimeWiring, CoraTypeRegistry coraTypeRegistry, CoraParser coraParser, MongoTemplate mongoTemplate, GroovyScriptService groovyScriptService) {
        this.coraRuntimeWiring = coraRuntimeWiring;
        this.coraTypeRegistry = coraTypeRegistry;
        this.coraParser = coraParser;
        this.mongoTemplate = mongoTemplate;
        this.groovyScriptService = groovyScriptService;
    }

    //query string cache
    public Cache<String, PreparsedDocumentEntry> cache = Caffeine.newBuilder().maximumSize(100).build();

    PreparsedDocumentProvider preparsedCache = (executionInput, parseAndValidateFunction) -> {
        Function<String, PreparsedDocumentEntry> mapCompute = key -> parseAndValidateFunction.apply(executionInput);
        return cache.get(executionInput.getQuery(), mapCompute);
    };

    // load json objects in /resources/demo/jieshixing.json to initial cora
    public void graphNodeInitialization() throws FileNotFoundException, UnsupportedEncodingException {
        final String path = "classpath*:demo/prestores.json";
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/Users/tangcong/Desktop/cora/cora-app/src/main/resources/demo/exampleWrite.json"),"UTF-8");
        try {
            Arrays.stream(resolver.getResources(path))
                    .parallel()
                    .forEach(resource -> {
                        try {
                            InputStream input = resource.getInputStream();
                            InputStreamReader reader = new InputStreamReader(input);
                            BufferedReader br = new BufferedReader(reader);
                            StringBuilder template = new StringBuilder();
                            for (String line; (line = br.readLine()) != null; ) {
                                template.append(line).append("\n");
                            }
                            JSONArray jsonArray = JSON.parseArray(template.toString());

                            JSONObject parseObject = JSON.parseObject(jsonArray.get(0).toString());

                                parseObject.put("nodeType", "Prestore");
                                osw.write(parseObject.toJSONString());
                                System.out.println("a");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //initial
    public GraphQL createGraphQL() {
        coraTypeRegistry.initSchemaDefinition();
        coraRuntimeWiring.initCoraRuntimeWiring();

        List<JSONObject> coraNodes = mongoTemplate.findAll(JSONObject.class, collectionName);
        coraNodes.forEach(coraNode -> {
            String schema = coraNode.getJSONObject("schemaDefinition").getString("fieldschema");
            List<Definition> parse = coraParser.parseSchema(schema);
            String nodeName = CoraGraph.merge(parse);
            this.addNewTypeAndDataFetcherInGraphQL(CoraGraph.getCoraNode(nodeName));
        });
        coraTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(coraTypeRegistry.getTypeDefinitionRegistry()
                , coraRuntimeWiring.getRuntimeWiring());
        return newGraphQL(graphQLSchema).preparsedDocumentProvider(preparsedCache).build();
    }

    //add new coraNode in runtime context
    private void addNewTypeAndDataFetcherInGraphQL(CoraNode coraNode) {
        coraTypeRegistry.addGraphNode(coraNode);
        coraRuntimeWiring.addNewSchemaDataFetcher(coraNode);
    }


    public GraphQL addTypeInGraphQL(String schema) {
        List<Definition> parse = coraParser.parseSchema(schema);
        String nodeName = CoraGraph.merge(parse);
        this.addNewTypeAndDataFetcherInGraphQL(CoraGraph.getCoraNode(nodeName));
        coraTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(coraTypeRegistry.getTypeDefinitionRegistry()
                , coraRuntimeWiring.getRuntimeWiring());
        return newGraphQL(graphQLSchema).preparsedDocumentProvider(preparsedCache).build();
    }

    public JSONObject addTypeInDB(String schema) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("schemaDefinition", schema);
        JSONObject coraNode = mongoTemplate.insert(jsonObject, "graphNode");
        return coraNode;
    }

    public JSONObject addFlowDefinitionInDB(String schema){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flowDefinition", schema);
        JSONObject flowDefinition = mongoTemplate.insert(jsonObject, "flowDefinition");
        return flowDefinition;
    }

    public JSONObject getFlows(){
        List<JSONObject> graphNodeList = mongoTemplate.findAll(JSONObject.class, "flowDefinition");
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        graphNodeList.forEach(graphNode->{
            jsonArray.add(graphNode.getJSONObject("flowDefinition"));
        });
        jsonObject.put("flowDefinitions",jsonArray);
        return jsonObject;
    }

    public JSONObject getSchemas(){
        List<JSONObject> graphNodeList = mongoTemplate.findAll(JSONObject.class, "graphNode");
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        graphNodeList.forEach(graphNode->{
            jsonArray.add(graphNode.getJSONObject("schemaDefinition"));
        });
        jsonObject.put("schemaDefinitions",jsonArray);
        return jsonObject;
    }

    public GraphQL addCustomIngress(String schema){
        SDLParser sdlParser = new SDLParser();
        CustomIngress customIngress = sdlParser.parseCustomIngressSchema(schema);
        groovyScriptService.parseAndCache(customIngress.getNodeType(),customIngress.getApiName()
                ,customIngress.getCodeImpl());
        CustomCoraRepository instance = groovyScriptService.getInstance(customIngress.getNodeType(), customIngress.getApiName());
        CustomDataFetcher customDataFetcher = new CustomDataFetcher(instance);

        coraRuntimeWiring.addCoraDataFetcherInCoraIngress(customIngress.getApiName(),customDataFetcher);
        coraTypeRegistry.addCustomAPIInQuery(customIngress.getNodeType(),customIngress.getApiName());
        coraTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(coraTypeRegistry.getTypeDefinitionRegistry()
                , coraRuntimeWiring.getRuntimeWiring());
        return newGraphQL(graphQLSchema).preparsedDocumentProvider(preparsedCache).build();
    }

}
