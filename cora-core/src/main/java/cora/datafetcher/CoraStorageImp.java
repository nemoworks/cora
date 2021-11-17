package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.CoraRepository;
import cora.datafetcher.CoraStorage;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

import java.util.ArrayList;
import java.util.List;

public class CoraStorageImp implements CoraStorage<JSONObject> {

    private final CoraRepository<JSONObject> coraRepository;

    public CoraStorageImp(CoraRepository coraRepository) {
        this.coraRepository = coraRepository;
    }

    @Override
    public DataFetcher<JSONObject> getFetcher() {
        return dataFetcherEnvironment -> {
            String id = dataFetcherEnvironment.getArgument("_id");
            return coraRepository.queryNodeInstanceById(id, null);
        };
    }

    @Override
    public DataFetcher<List<JSONObject>> getListFetcher() {
        return dataFetcherEnvironment -> {
            String fieldType = ((GraphQLObjectType) ((GraphQLList) dataFetcherEnvironment.getFieldType()).getWrappedType()).getName();
            if (dataFetcherEnvironment.getSource() != null) {
                String name = dataFetcherEnvironment.getFieldDefinition().getName();
                JSONObject source = dataFetcherEnvironment.getSource();
                ArrayList<String> ids = source.getObject(name, ArrayList.class);
                return coraRepository.queryNodeInstanceList(ids);
            }
            return coraRepository.queryNodeInstanceList(fieldType);
        };
    }

    @Override
    public DataFetcher<JSONObject> getCreator() {
        return dataFetcherEnvironment -> {
            JSONObject content = new JSONObject(dataFetcherEnvironment.getArgument("data"));
            String fieldType = ((GraphQLObjectType) dataFetcherEnvironment.getFieldType()).getName();
            return coraRepository.createNodeInstance(fieldType, content);
        };
    }

    @Override
    public DataFetcher<JSONObject> getRemover() {
        return null;
    }
}
