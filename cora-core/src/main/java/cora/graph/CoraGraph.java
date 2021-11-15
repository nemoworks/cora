package cora.graph;

import graphql.language.Definition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoraGraph {
    public static final Map<String, CoraNode> nodeMap = new HashMap<>();

    public CoraGraph() {
    }

    public static CoraGraph fromDefinitions(List<Definition> definitions) {
        //todo
        return null;
    }

    public static void mergeCoraNode(CoraNode coraNode) {
        nodeMap.put(coraNode.getName(), coraNode);
    }

    public Map<String, CoraNode> getGraphNodeMap() {
        return nodeMap;
    }
}
