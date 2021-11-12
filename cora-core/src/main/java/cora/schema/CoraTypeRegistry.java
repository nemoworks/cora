package cora.schema;

import cora.graph.CoraNode;
import cora.util.GQLTemplate;
import graphql.language.*;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoraTypeRegistry {

    private final TypeDefinitionRegistry typeDefinitionRegistry;

    public static Map<String, Map<String, Type>> typeDefinitionsMap = new HashMap<>();

    private final List<FieldDefinition> fieldDefinitionListInQuery = new ArrayList<>();

    public CoraTypeRegistry() {
        this.typeDefinitionRegistry = new TypeDefinitionRegistry();
    }

    public TypeDefinitionRegistry getTypeDefinitionRegistry() {
        return typeDefinitionRegistry;
    }

    public void initSchemaDefinition() {
        SchemaDefinition.Builder builder = SchemaDefinition.newSchemaDefinition();
        OperationTypeDefinition operationTypeDefinition = new OperationTypeDefinition("query", new TypeName("Query"));
        SchemaDefinition schemaDefinition = builder.operationTypeDefinition(operationTypeDefinition).build();
        typeDefinitionRegistry.add(schemaDefinition);
    }

    public void buildTypeRegistry(){
        typeDefinitionRegistry.getType("Query").ifPresent(typeDefinition -> {
            if(typeDefinition instanceof ObjectTypeDefinition)
                typeDefinitionRegistry.remove(typeDefinition);
        });
        ObjectTypeDefinition query = ObjectTypeDefinition.newObjectTypeDefinition().name("Query").fieldDefinitions(fieldDefinitionListInQuery).build();
        typeDefinitionRegistry.add(query);
    }

    public void addGraphNode(CoraNode coraNode){
        if (!typeDefinitionsMap.keySet().contains(coraNode.getName())) {

            typeDefinitionsMap.put(coraNode.getName(),coraNode.getTypeMap());

            this.addTypeDefinition(coraNode.getName(), coraNode.getTypeMap());

            this.addDocumentTypeInQuery(coraNode.getName());

            this.addDocumentListTypeInQuery(coraNode.getName());

            this.addCreateNodeInstanceInQuery(coraNode.getName(),coraNode.getInputTypeMap());

        }
    }

    //在GraphQL的Schema中的Query类中增加一个访问定义的对象的字段
    private void addDocumentTypeInQuery(String name){
        List<InputValueDefinition> inputValueDefinitions = new ArrayList<>();
        inputValueDefinitions.add(new InputValueDefinition("id",new TypeName("String")));
        //orderDocument(id:String):OrderDocument
        this.addFieldDefinitionsInQueryType(GQLTemplate.querySingleInstance(name)
                ,new TypeName(name)
                ,inputValueDefinitions);
    }

    private void addDocumentListTypeInQuery(String name){
        this.addFieldDefinitionsInQueryType(GQLTemplate.queryInstanceList(name),new ListType(new TypeName(name)),
                new ArrayList<>());
    }

    private void addCreateNodeInstanceInQuery(String name,Map<String,Type> typeMap){
        List<InputValueDefinition> inputValueDefinitions = new ArrayList<>();
        typeMap.forEach((key, value) -> inputValueDefinitions.add(new InputValueDefinition(key, value)));
        InputObjectTypeDefinition inputObjectTypeDefinition = InputObjectTypeDefinition.newInputObjectDefinition()
                .name(GQLTemplate.inputTypeForNodeInstance(name))
                .inputValueDefinitions(inputValueDefinitions).build();
        typeDefinitionRegistry.add(inputObjectTypeDefinition);

        List<InputValueDefinition> inputValueDefinition = new ArrayList<>();
        inputValueDefinition.add(new InputValueDefinition("data",new TypeName(GQLTemplate.inputTypeForNodeInstance(name))));

        this.addFieldDefinitionsInQueryType(GQLTemplate.createNodeInstance(name)
                ,new TypeName(name)
                ,inputValueDefinition);
    }


    void addInputObjectTypeDefinition(String name, Map<String, Type> typeMap) {

        List<InputValueDefinition> inputValueDefinitions = new ArrayList<>();
        typeMap.forEach((key, value) -> inputValueDefinitions.add(new InputValueDefinition(key, value)));
        InputObjectTypeDefinition inputObjectTypeDefinition = InputObjectTypeDefinition.newInputObjectDefinition().name(name)
                .inputValueDefinitions(inputValueDefinitions).build();
        typeDefinitionRegistry.add(inputObjectTypeDefinition);
    }

    void addFieldDefinitionsInQueryType(String name, Type type, List<InputValueDefinition> inputValueDefinitions) {
        FieldDefinition definition = FieldDefinition.newFieldDefinition().inputValueDefinitions(inputValueDefinitions)
                .name(name).type(type).build();
        fieldDefinitionListInQuery.add(definition);
    }


    void addTypeDefinition(String name, Map<String, Type> typeMap) {
        typeDefinitionRegistry.add(newObjectTypeDefinition(name, newFieldDefinitions(typeMap)));
    }

    private List<FieldDefinition> newFieldDefinitions(Map<String, Type> typeMap) {
        List<FieldDefinition> fieldDefinitions = new ArrayList<>();
        typeMap.forEach((name, Type) -> fieldDefinitions.add(new FieldDefinition(name, Type)));
        return fieldDefinitions;
    }

    private ObjectTypeDefinition newObjectTypeDefinition(String name, List<FieldDefinition> fieldDefinitions) {
        ObjectTypeDefinition.Builder builder = ObjectTypeDefinition.newObjectTypeDefinition();
        return builder.name(name).fieldDefinitions(fieldDefinitions).build();
    }

}
