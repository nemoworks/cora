package cora.graph;

import cora.util.IngressTemplate;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.List;

public class CoraIngress {
    private String id;
    private String name;
    private List<ImmutablePair<IngressType,String>> ingress;

    public CoraIngress(String name, List<ImmutablePair<IngressType, String>> ingress) {
        this.name = name;
        this.ingress = ingress;
    }

    public void addIngress(IngressType IngressType,String ingress){
        this.ingress.add(new ImmutablePair<>(IngressType,ingress));
    }

    public boolean removeIngress(String ingressName){
        for(ImmutablePair pair :ingress){
            if(pair.left.equals(ingressName)){
                ingress.remove(pair);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImmutablePair<IngressType, String>> getIngress() {
        return ingress;
    }

    public void setIngress(List<ImmutablePair<IngressType, String>> ingress) {
        this.ingress = ingress;
    }

    public String getIngressData(IngressType ingressType){
        for (ImmutablePair<IngressType, String> ingressTypeStringImmutablePair : ingress) {
            if (ingressTypeStringImmutablePair.left.equals(ingressType)) {
                return ingressTypeStringImmutablePair.right;
            }
        }
        return null;
    }

    public static final class Builder{
        String name;
        List<ImmutablePair<IngressType,String>> ingress;
        protected Builder(String nodeName){
            this.name = nodeName;
            ingress = new ArrayList<>();
            ingress.add(new ImmutablePair<>(IngressType.QUERY, IngressTemplate.getQueryTemplate(nodeName)));
            ingress.add(new ImmutablePair<>(IngressType.QUERY_LIST,IngressTemplate.getQueryListTemplate(nodeName)));
            ingress.add(new ImmutablePair<>(IngressType.MUTATION, IngressTemplate.getCreateTemplate(nodeName)));
        }

        public CoraIngress build(){
            return new CoraIngress(name,ingress);
        }
    }
}
