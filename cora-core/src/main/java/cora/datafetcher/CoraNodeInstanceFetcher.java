package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLObjectType;

import java.util.ArrayList;

public class CoraNodeInstanceFetcher implements DataFetcher<JSONObject> {
    private final NodeInstanceFetcher nodeInstanceFetcher;

    public CoraNodeInstanceFetcher(NodeInstanceFetcher nodeInstanceFetcher) {
        this.nodeInstanceFetcher = nodeInstanceFetcher;
    }

    @Override
    public JSONObject get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        if(dataFetchingEnvironment.getSource()!=null){
            String name = dataFetchingEnvironment.getFieldDefinition().getName();
            JSONObject source = dataFetchingEnvironment.getSource();
            ArrayList<String> ids = source.getObject(name, ArrayList.class);
            return nodeInstanceFetcher.queryNodeInstanceById(ids.get(0),null);
        }
        String id = dataFetchingEnvironment.getArgument("_id");
        String fieldType = ((GraphQLObjectType) dataFetchingEnvironment.getFieldType()).getName();
        return nodeInstanceFetcher.queryNodeInstanceById(id,fieldType);
    }
}
