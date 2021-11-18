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

    public void addIngress(IngressType IngressType,String ingressName){
        this.ingress.add(new ImmutablePair<>(IngressType,ingressName));
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

    public static final class Builder{
        String name;
        List<ImmutablePair<IngressType,String>> ingress;
        protected Builder(String nodeName){
            this.name = nodeName;
            ingress = new ArrayList<ImmutablePair<IngressType,String>>();
            ingress.add(new ImmutablePair<IngressType,String>(IngressType.QUERY,IngressTemplate.getQueryTemplate(nodeName)));
            // ingress.add(new ImmutablePair<String, IngressType>(GQLTemplate.queryInstanceList(nodeName), IngressType.QUERY));
            // ingress.add(new ImmutablePair<String, IngressType>(GQLTemplate.createNodeInstance(nodeName), IngressType.MUTATION));
        }

        public CoraIngress build(){
            return new CoraIngress(name,ingress);
        }
    }
}
