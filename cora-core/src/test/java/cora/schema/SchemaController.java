package cora.schema;

import static graphql.GraphQL.newGraphQL;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import cora.graph.GraphInstance;
import cora.graph.GraphNode;
import cora.parser.DSLParser;
import graphql.GraphQL;
import graphql.language.Definition;
import graphql.language.ObjectTypeDefinition;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaGenerator;

@Component
public class SchemaController {

    final GraphRuntimeWiring graphRuntimeWiring;

    final GraphTypeRegistry graphTypeRegistry;

    private GraphQLSchema graphQLSchema;

    private final SchemaGenerator schemaGenerator;


    public SchemaController(GraphRuntimeWiring graphRuntimeWiring, GraphTypeRegistry graphTypeRegistry) {
        this.graphRuntimeWiring = graphRuntimeWiring;
        this.graphTypeRegistry = graphTypeRegistry;
        this.schemaGenerator = new SchemaGenerator();
    }


    @PostConstruct
    public GraphQL createGraphQL(){
        graphTypeRegistry.initSchemaDefinition();
        graphRuntimeWiring.initRuntimeWiring();
//        String s =
//                "type Article {\n" +
//                "   id: String\n" +
//                "   title: String\n" +
//                "   minutesRead: Int\n" +
//                "}";
        String s = "{\n" +
                "  \"type\":\"object\",\n" +
                "  \"title\": \"Company\",\n" +
                "  \"properties\": {\n" +
                "    \"id\": {\n" +
                "      \"type\": \"integer\"\n" +
                "    },\n" +
                "    \"name\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"age\": {\n" +
                "      \"type\": \"integer\"\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"salary\": {\n" +
                "      \"type\": \"integer\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        List<Definition> parse = DSLParser.parseSchema(s);
        GraphNode node = new GraphNode.Builder((ObjectTypeDefinition) parse.get(0)).build();
        GraphInstance.merge(node);
        this.addNewTypeAndDataFetcherInGraphQL(node);
        graphTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(graphTypeRegistry.getTypeDefinitionRegistry()
                , graphRuntimeWiring.getRuntimeWiring());
        return  newGraphQL(graphQLSchema).build();
    }

    public GraphQL addTypeInGraphQL(String schema){
        List<Definition> parse = DSLParser.parseSchema(schema);
        //GraphInstance.merge(parse);
        GraphNode node = new GraphNode.Builder((ObjectTypeDefinition) parse.get(0)).build();
        this.addNewTypeAndDataFetcherInGraphQL(node);
        graphTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(graphTypeRegistry.getTypeDefinitionRegistry()
                , graphRuntimeWiring.getRuntimeWiring());
        return  newGraphQL(graphQLSchema).build();
    }


    private void addNewTypeAndDataFetcherInGraphQL(GraphNode graphNode){
        graphTypeRegistry.addGraphNode(graphNode);
        graphRuntimeWiring.addNewSchemaDataFetcher(graphNode);
    }
}
