package cora.datafetcher.custom;

import com.alibaba.fastjson.JSONObject;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLObjectType;

public class CustomDataFetcher implements DataFetcher<JSONObject> {
    private final CustomCoraRepository customCoraRepository;

    public CustomDataFetcher(CustomCoraRepository customCoraRepository) {
        this.customCoraRepository = customCoraRepository;
    }

    @Override
    public JSONObject get(DataFetchingEnvironment environment) throws Exception {
      //  JSONObject content = new JSONObject(environment.getArgument("fields"));
      //  String fieldType = ((GraphQLObjectType) environment.getFieldType()).getName();
        return customCoraRepository.resolve(null, new StorageHelper(),null);
    }
}

