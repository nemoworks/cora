package cora.graph;

import graphql.language.Definition;
import graphql.language.ObjectTypeDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphInstance {

    public static List<Definition> definitions = new ArrayList<>();

    public static final Map<String,GraphNode> graphNodeMap = new HashMap<>();

    public GraphInstance() {
    }

    public static void merge(GraphNode graphNode){
            graphNodeMap.put(graphNode.getName(),graphNode);
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        GraphInstance.definitions = definitions;
    }

    public Map<String, GraphNode> getGraphNodeMap() {
        return graphNodeMap;
    }
}
