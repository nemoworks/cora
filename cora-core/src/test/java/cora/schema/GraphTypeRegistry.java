package cora.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.language.FieldDefinition;
import graphql.language.InputValueDefinition;
import graphql.language.ObjectTypeDefinition;
import graphql.language.OperationTypeDefinition;
import graphql.language.SchemaDefinition;
import graphql.language.Type;
import graphql.language.TypeName;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphTypeRegistry {
    private final TypeDefinitionRegistry typeDefinitionRegistry;

    public static Map<String, Map<String, Type>> typeDefinitionsMap = new HashMap<>();

    private final List<FieldDefinition> fieldDefinitionListInQuery = new ArrayList<>();

    @Autowired
    private GraphTypeRegistry() {
        this.typeDefinitionRegistry = new TypeDefinitionRegistry();
    }

    TypeDefinitionRegistry getTypeDefinitionRegistry() {
        return typeDefinitionRegistry;
    }


    void initSchemaDefinition() {
        SchemaDefinition.Builder builder = SchemaDefinition.newSchemaDefinition();
        OperationTypeDefinition operationTypeDefinition = new OperationTypeDefinition("query", new TypeName("Query"));
        SchemaDefinition schemaDefinition = builder.operationTypeDefinition(operationTypeDefinition).build();
        typeDefinitionRegistry.add(schemaDefinition);
    }

    void buildTypeRegistry(){
        typeDefinitionRegistry.getType("Query").ifPresent(typeDefinition -> {
            if(typeDefinition instanceof ObjectTypeDefinition)
                typeDefinitionRegistry.remove(typeDefinition);
        });
        ObjectTypeDefinition query = ObjectTypeDefinition.newObjectTypeDefinition().name("Query").fieldDefinitions(fieldDefinitionListInQuery).build();
        typeDefinitionRegistry.add(query);
    }

    public void addGraphNode(GraphNode graphNode){
        if (!typeDefinitionsMap.keySet().contains(graphNode.getName())) {

            typeDefinitionsMap.put(graphNode.getName(),graphNode.getTypeMap());

            this.addTypeDefinition(graphNode.getName(), graphNode.getTypeMap());

            this.addDocumentTypeInQuery(graphNode.getName());
        }
    }

    //在GraphQL的Schema中的Query类中增加一个访问定义的对象的字段
    private void addDocumentTypeInQuery(String name){
        List<InputValueDefinition> inputValueDefinitions = new ArrayList<>();
        inputValueDefinitions.add(new InputValueDefinition("id",new TypeName("String")));
        //orderDocument(id:String):OrderDocument
        this.addFieldDefinitionsInQueryType(lowerCase(name)
                ,new TypeName(upperCase(name))
                ,inputValueDefinitions);
    }
    private String upperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private String lowerCase(String str){
        return str.substring(0,1).toLowerCase() + str.substring(1);
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
