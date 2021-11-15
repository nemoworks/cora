package cora.graph;

import graphql.language.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoraNode {
    private String id;
    private String name;
    private Definition definition;
    private Map<String, Type> typeMap;
    private Map<String, Type> inputTypeMap;
    private Map<String, Type> linkedTypeMap;

    private List<String> children;

    public CoraNode(String name, Definition definition, Map<String, Type> typeMap, Map<String, Type> inputTypeMap, Map<String, Type> linkedTypeMap, List<String> children) {
        this.name = name;
        this.definition = definition;
        this.typeMap = typeMap;
        this.inputTypeMap = inputTypeMap;
        this.linkedTypeMap = linkedTypeMap;
        this.children = children;
    }

    public Map<String, Type> getLinkedTypeMap() {
        return linkedTypeMap;
    }

    public void setLinkedTypeMap(Map<String, Type> linkedTypeMap) {
        this.linkedTypeMap = linkedTypeMap;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public Map<String, Type> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, Type> typeMap) {
        this.typeMap = typeMap;
    }


    public Map<String, Type> getInputTypeMap() {
        return inputTypeMap;
    }

    public void setInputTypeMap(Map<String, Type> inputTypeMap) {
        this.inputTypeMap = inputTypeMap;
    }


    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public static final class Builder {
        private String name;
        private Definition definition;
        private Map<String, Type> typeMap = new HashMap<>();

        private Map<String, Type> inputTypeMap = new HashMap<>();

        private Map<String, Type> linkedTypeMap = new HashMap<>();

        private List<String> children = new ArrayList<>();

        public Builder(ObjectTypeDefinition definition) {
            this.name = definition.getName();
            this.definition = definition;
            typeMap.put("_id", new TypeName("String"));
            definition.getFieldDefinitions().forEach(fieldDefinition -> {
                typeMap.put(fieldDefinition.getName(), fieldDefinition.getType());
                if (fieldDefinition.getType() instanceof ListType) {
                    if (!CoraScalar.getScalars().contains(((TypeName) ((ListType) fieldDefinition.getType()).getType()).getName())) {
                        String typeName = ((TypeName) ((ListType) fieldDefinition.getType()).getType()).getName();
                        children.add(typeName);
                        //inputTypeMap.put(fieldDefinition.getName(),new ListType(new TypeName(GQLTemplate.inputTypeForNodeInstance(typeName))));
                        inputTypeMap.put(fieldDefinition.getName(), new ListType(new TypeName("String")));
                        linkedTypeMap.put(fieldDefinition.getName(), fieldDefinition.getType());
                    } else {
                        inputTypeMap.put(fieldDefinition.getName(), fieldDefinition.getType());
                        //inputTypeMap.put(fieldDefinition.getName(),new TypeName("String"));
                    }
                } else {
                    if (!CoraScalar.getScalars().contains(((TypeName) fieldDefinition.getType()).getName())) {
                        children.add(((TypeName) fieldDefinition.getType()).getName());
                        //inputTypeMap.put(fieldDefinition.getName(),new TypeName(GQLTemplate.inputTypeForNodeInstance(((TypeName) fieldDefinition.getType()).getName())));
                        inputTypeMap.put(fieldDefinition.getName(), new ListType(new TypeName("String")));
                        linkedTypeMap.put(fieldDefinition.getName(), fieldDefinition.getType());
                    } else {
                        inputTypeMap.put(fieldDefinition.getName(), fieldDefinition.getType());
                        //inputTypeMap.put(fieldDefinition.getName(),new TypeName("String"));
                    }
                }

            });
        }

        public CoraNode build() {
            return new CoraNode(name, definition, typeMap, inputTypeMap, linkedTypeMap, children);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Definition getDefinition() {
            return definition;
        }

        public void setDefinition(Definition definition) {
            this.definition = definition;
        }

        public Map<String, Type> getTypeMap() {
            return typeMap;
        }

        public void setTypeMap(Map<String, Type> typeMap) {
            this.typeMap = typeMap;
        }
    }
}
