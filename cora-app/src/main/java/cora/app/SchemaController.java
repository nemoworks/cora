package cora.app;

import static graphql.GraphQL.newGraphQL;

import java.util.List;

import graphql.GraphQL;
import graphql.language.Definition;
import graphql.language.ObjectTypeDefinition;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.SchemaGenerator;


public class SchemaController {

    final CoraRuntimeWiring graphRuntimeWiring;

    final CoraTypeRegistry graphTypeRegistry;

    private GraphQLSchema graphQLSchema;

    private final SchemaGenerator schemaGenerator;


    public SchemaController(CoraRuntimeWiring graphRuntimeWiring, CoraTypeRegistry graphTypeRegistry) {
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
        CoraNode node = new CoraNode.Builder((ObjectTypeDefinition) parse.get(0)).build();
        CoraGraph.merge(node);
        this.addNewTypeAndDataFetcherInGraphQL(node);
        graphTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(graphTypeRegistry.getTypeDefinitionRegistry()
                , graphRuntimeWiring.getRuntimeWiring());
        return  newGraphQL(graphQLSchema).build();
    }

    public GraphQL addTypeInGraphQL(String schema){
        List<Definition> parse = DSLParser.parseSchema(schema);
        //GraphInstance.merge(parse);
        CoraNode node = new CoraNode.Builder((ObjectTypeDefinition) parse.get(0)).build();
        this.addNewTypeAndDataFetcherInGraphQL(node);
        graphTypeRegistry.buildTypeRegistry();
        this.graphQLSchema = schemaGenerator.makeExecutableSchema(graphTypeRegistry.getTypeDefinitionRegistry()
                , graphRuntimeWiring.getRuntimeWiring());
        return  newGraphQL(graphQLSchema).build();
    }


    private void addNewTypeAndDataFetcherInGraphQL(CoraNode graphNode){
        graphTypeRegistry.addGraphNode(graphNode);
        graphRuntimeWiring.addNewSchemaDataFetcher(graphNode);
    }
}
