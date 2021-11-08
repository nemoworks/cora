package cora.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.Scalars;
import graphql.language.Definition;
import graphql.language.ListType;
import graphql.language.ObjectTypeDefinition;
import graphql.language.Type;
import graphql.language.TypeName;

public class GraphNode {

    private String id;

    private String name;

    private Definition definition;

    private Map<String, Type> typeMap;

    private List<String> children;

    public GraphNode(String name, Definition definition, Map<String, Type> typeMap, List<String> children) {
        this.name = name;
        this.definition = definition;
        this.typeMap = typeMap;
        this.children = children;
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
        private List<String> children = new ArrayList<>();

        public Builder(ObjectTypeDefinition definition) {
            this.name = definition.getName();
            this.definition = definition;
            definition.getFieldDefinitions().forEach(fieldDefinition -> {
                typeMap.put(fieldDefinition.getName(), fieldDefinition.getType());
                if (!Scalar.getScalars().contains(((TypeName) fieldDefinition.getType()).getName())) {
                    if (fieldDefinition.getType() instanceof ListType) {
                        if (!Scalar.getScalars()
                                .contains(((ListType) fieldDefinition.getType()).getType().toString())) {
                            children.add(((TypeName) ((ListType) fieldDefinition.getType()).getType()).getName());
                        }
                    } else
                        children.add(((TypeName) fieldDefinition.getType()).getName());
                }
            });
        }

        public GraphNode build() {
            return new GraphNode(name, definition, typeMap, children);
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
