package cora.schema;

import com.nemoworks.graphcache.dataFetchers.RelationalDataFetcher;
import com.nemoworks.graphcache.graph.GraphNode;
import graphql.schema.DataFetcher;
import graphql.schema.idl.RuntimeWiring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class GraphRuntimeWiring {
    private RuntimeWiring runtimeWiring;

    @Autowired
    Connection connection;

    @Autowired
    public GraphRuntimeWiring(){
        runtimeWiring = RuntimeWiring.newRuntimeWiring().build();
    }

    RuntimeWiring getRuntimeWiring() {
        return runtimeWiring;
    }

    void initRuntimeWiring(){
        Map<String, DataFetcher> map = new LinkedHashMap<>();
        runtimeWiring.getDataFetchers().put("Query",map);
    }
    public void addNewSchemaDataFetcher(GraphNode graphNode) {

        //queryDocument ==>  documentDataFetcher
        RelationalDataFetcher relationalDataFetcher = new RelationalDataFetcher(connection);
        this.addNewEntryInQueryDataFetcher(graphNode.getName(), relationalDataFetcher);
    }

    void addNewEntryInQueryDataFetcher(String name, DataFetcher dataFetcher){
        runtimeWiring.getDataFetchers().get("Query").put(lowerCase(name),dataFetcher);
    }
    private String lowerCase(String str){
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }

}
