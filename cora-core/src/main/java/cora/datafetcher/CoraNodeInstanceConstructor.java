package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLObjectType;


public class CoraNodeInstanceConstructor implements DataFetcher<JSONObject> {
    private final NodeInstanceConstructor nodeInstanceConstructor;

    public CoraNodeInstanceConstructor(NodeInstanceConstructor nodeInstanceConstructor) {
        this.nodeInstanceConstructor = nodeInstanceConstructor;
    }

    @Override
    public JSONObject get(DataFetchingEnvironment environment) throws Exception {
        JSONObject content = new JSONObject(environment.getArgument("data"));
        String fieldType = ((GraphQLObjectType) environment.getFieldType()).getName();
        return nodeInstanceConstructor.createNodeInstance(fieldType,content);
    }
}
