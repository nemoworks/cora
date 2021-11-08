package cora.schema;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

import cora.datafetcher.SQLDataFetcher;
import cora.graph.CoraNode;
import graphql.schema.DataFetcher;
import graphql.schema.idl.RuntimeWiring;

public class CoraRuntimeWiring {
    private RuntimeWiring runtimeWiring;

    Connection connection;

    public CoraRuntimeWiring(){
        runtimeWiring = RuntimeWiring.newRuntimeWiring().build();
    }

    RuntimeWiring getRuntimeWiring() {
        return runtimeWiring;
    }

    void initRuntimeWiring(){
        Map<String, DataFetcher> map = new LinkedHashMap<>();
        runtimeWiring.getDataFetchers().put("Query",map);
    }
    public void addNewSchemaDataFetcher(CoraNode graphNode) {

        //queryDocument ==>  documentDataFetcher
        SQLDataFetcher relationalDataFetcher = new SQLDataFetcher(connection);
        this.addNewEntryInQueryDataFetcher(graphNode.getName(), relationalDataFetcher);
    }

    void addNewEntryInQueryDataFetcher(String name, DataFetcher dataFetcher){
        runtimeWiring.getDataFetchers().get("Query").put(lowerCase(name),dataFetcher);
    }
    private String lowerCase(String str){
        return str.substring(0,1).toLowerCase() + str.substring(1);
    }

}
