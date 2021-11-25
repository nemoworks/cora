package cora;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.custom.CustomCoraRepository;
import cora.datafetcher.custom.CustomDataFetcher;
import cora.graph.CoraGraph;
import cora.graph.CoraNode;
import cora.graph.CustomIngress;
import cora.groovy.GroovyScriptService;
import cora.parser.CoraParser;
import cora.parser.SDLParser;
import cora.schema.CoraRuntimeWiring;
import cora.schema.CoraTypeRegistry;
import cora.util.StringUtil;
import graphql.GraphQL;
import graphql.language.Definition;
import graphql.language.ObjectTypeDefinition;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    // load json objects in /resources/demo/jieshixing.json to initial cora
    public void graphNodeInitialization() {
        final String path = "classpath*:demo/jieshixing.json";
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
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
                            JSONObject parseObject = JSON.parseObject(template.toString());
                            parseObject.getInnerMap().keySet().forEach(key -> {
                                JSONObject jsonObject = (JSONObject) parseObject.getInnerMap().get(key);
                                jsonObject.put("nodeType", StringUtil.upperCase(key));
                                List<Definition> parse = coraParser.parseSchema(jsonObject.toString());
                                String nodeName = CoraGraph.merge(parse);
                                this.addNewTypeAndDataFetcherInGraphQL(CoraGraph.getCoraNode(nodeName));
                            });
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

//        List<JSONObject> coraNodes = mongoTemplate.findAll(JSONObject.class, collectionName);
//        coraNodes.forEach(coraNode -> {
//            String schema = coraNode.getString("schemaDefinition");
//            List<Definition> parse = coraParser.parseSchema(schema);
//            String nodeName = CoraGraph.merge(parse);
//            this.addNewTypeAndDataFetcherInGraphQL(CoraGraph.getCoraNode(nodeName));
//        });
        this.graphNodeInitialization();
        coraTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(coraTypeRegistry.getTypeDefinitionRegistry()
                , coraRuntimeWiring.getRuntimeWiring());
        return newGraphQL(graphQLSchema).build();
    }

    //add new coraNode in runtime context
    private void addNewTypeAndDataFetcherInGraphQL(CoraNode coraNode) {
        coraTypeRegistry.addGraphNode(coraNode);
        coraRuntimeWiring.addNewSchemaDataFetcher(coraNode);
    }


    public GraphQL addTypeInGraphQL(String schema) {
        List<Definition> parse = coraParser.parseSchema(schema);
        //GraphInstance.merge(parse);
        this.addTypeInDB(schema);
        CoraNode node = new CoraNode.Builder((ObjectTypeDefinition) parse.get(0)).build();
        this.addNewTypeAndDataFetcherInGraphQL(node);
        coraTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(coraTypeRegistry.getTypeDefinitionRegistry()
                , coraRuntimeWiring.getRuntimeWiring());
        return newGraphQL(graphQLSchema).build();
    }

    private void addTypeInDB(String schema) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("schemaDefinition", schema);
        mongoTemplate.insert(jsonObject, "graphNode");
    }

    public JSONObject getSchemas(){
        JSONObject graphNode = mongoTemplate.findById("619daa213a54f960ad96a712", JSONObject.class, "graphNode");
        return graphNode.getJSONObject("data");
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
        return newGraphQL(graphQLSchema).build();
    }
}
