package cora.app;

import com.alibaba.fastjson.JSONObject;
import cora.graph.CoraGraph;
import cora.graph.CoraNode;
import cora.parser.CoraParser;
import cora.schema.CoraRuntimeWiring;
import cora.schema.CoraTypeRegistry;
import graphql.GraphQL;
import graphql.language.Definition;
import graphql.language.ObjectTypeDefinition;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import static graphql.GraphQL.newGraphQL;

@Component
public class CoraBuilder {
    @Autowired
    CoraRuntimeWiring coraRuntimeWiring;

    @Autowired
    CoraTypeRegistry coraTypeRegistry;

    @Autowired
    CoraParser coraParser;

    @Autowired
    MongoTemplate mongoTemplate;

    @Value("${cora.node.typeCollection}")
    String collectionName;


    private GraphQLSchema graphQLSchema;

    private final SchemaGenerator schemaGenerator = new SchemaGenerator();


    public GraphQL createGraphQL() {
        coraTypeRegistry.initSchemaDefinition();
        coraRuntimeWiring.initCoraRuntimeWiring();
        List<JSONObject> coraNodes = mongoTemplate.findAll(JSONObject.class, collectionName);
        coraNodes.forEach(coraNode -> {
            String schema = coraNode.getString("schemaDefinition");
            List<Definition> parse = coraParser.parseSchema(schema);
            CoraNode node = new CoraNode.Builder((ObjectTypeDefinition) parse.get(0)).build();
            CoraGraph.mergeCoraNode(node);
            this.addNewTypeAndDataFetcherInGraphQL(node);
        });
        coraTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(coraTypeRegistry.getTypeDefinitionRegistry()
                , coraRuntimeWiring.getRuntimeWiring());
        return newGraphQL(graphQLSchema).build();
    }

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
}
