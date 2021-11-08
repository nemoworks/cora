package cora.datafetcher.mongodb;

import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.NodeInstanceFetcher;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLObjectType;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;

public class MongodbNodeInstanceFetcher implements DataFetcher<JSONObject>, NodeInstanceFetcher {
    private final MongoTemplate mongoTemplate;

    private static final String collectionName = "jieshixing";

    public MongodbNodeInstanceFetcher(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public JSONObject get(DataFetchingEnvironment dataFetchingEnvironment){
        if(dataFetchingEnvironment.getSource()!=null){
            String name = dataFetchingEnvironment.getFieldDefinition().getName();
            JSONObject source = dataFetchingEnvironment.getSource();
            ArrayList<String> ids = source.getObject(name, ArrayList.class);
            return queryNodeInstanceById(ids.get(0),null);
        }
        String id = dataFetchingEnvironment.getArgument("id");
        String fieldType = ((GraphQLObjectType) dataFetchingEnvironment.getFieldType()).getName();
        return queryNodeInstanceById(id,fieldType);
    }

    @Override
    public JSONObject queryNodeInstanceById(String id, String nodeType) {
        JSONObject result = mongoTemplate.findById(id, JSONObject.class, collectionName);
        return result;
    }
}
