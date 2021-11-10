package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

import java.util.ArrayList;
import java.util.List;

public class CoraNodeInstanceListFetcher implements DataFetcher<List<JSONObject>> {
    private final NodeInstanceListFetcher nodeInstanceListFetcher;

    public CoraNodeInstanceListFetcher(NodeInstanceListFetcher nodeInstanceListFetcher) {
        this.nodeInstanceListFetcher = nodeInstanceListFetcher;
    }

    @Override
    public List<JSONObject> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        String fieldType = ((GraphQLObjectType)((GraphQLList) dataFetchingEnvironment.getFieldType()).getWrappedType()).getName();
        if(dataFetchingEnvironment.getSource()!=null){
            String name = dataFetchingEnvironment.getFieldDefinition().getName();
            JSONObject source = dataFetchingEnvironment.getSource();
            ArrayList<String> ids = source.getObject(name, ArrayList.class);
            return nodeInstanceListFetcher.queryNodeInstanceList(ids);
        }
        return nodeInstanceListFetcher.queryNodeInstanceList(fieldType);
    }
}
