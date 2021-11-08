package cora.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.language.Definition;

public class CoraGraph {

    // public static List<Definition> definitions = new ArrayList<>();

    public static final Map<String,CoraNode> graphNodeMap = new HashMap<>();

    public CoraGraph() {
    }

    public static CoraGraph fromDefinitions(List<Definition> definitions){
        //todo
        return null;
    }

    public static void merge(CoraNode graphNode){
            graphNodeMap.put(graphNode.getName(),graphNode);
    }

    // public List<Definition> getDefinitions() {
    //     return definitions;
    // }

    // public void setDefinitions(List<Definition> definitions) {
    //     CoraGraph.definitions = definitions;
    // }

    public Map<String, CoraNode> getGraphNodeMap() {
        return graphNodeMap;
    }
}
