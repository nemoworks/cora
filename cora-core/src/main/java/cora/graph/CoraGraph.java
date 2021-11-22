package cora.graph;

import graphql.language.Definition;
import graphql.language.ObjectTypeDefinition;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CoraGraph {

    public static final Map<String,CoraNode> CoraNodeMap = new ConcurrentHashMap<>(100);

    public static final Map<String,CoraIngress> CoraIngressMap = new ConcurrentHashMap<>(100);

    public CoraGraph() {
    }

    public synchronized static String merge(List<Definition> definitions){
        CoraNode node = new CoraNode.Builder((ObjectTypeDefinition) definitions.get(0)).build();
        CoraNodeMap.put(node.getName(),node);
        CoraIngress ingress = new CoraIngress.Builder(node.getName()).build();
        CoraIngressMap.put(node.getName(),ingress);
        return node.getName();
    }

    public static CoraNode getCoraNode(String nodeType){
        return CoraNodeMap.get(nodeType);
    }

    public static CoraIngress getCoraIngress(String nodeType){
        return CoraIngressMap.get(nodeType);
    }

    public static void merge(String nodeType,String ingressName,IngressType ingressType){
        CoraIngress ingress = CoraIngressMap.get(nodeType);
        ingress.addIngress(ingressType,ingressName);
    }

    public static void merge(CoraNode CoraNode){
        CoraNodeMap.put(CoraNode.getName(),CoraNode);
    }

}
