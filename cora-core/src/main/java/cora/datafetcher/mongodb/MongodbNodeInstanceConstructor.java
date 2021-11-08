package cora.datafetcher.mongodb;

import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.NodeInstanceConstructor;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLObjectType;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongodbNodeInstanceConstructor implements DataFetcher<JSONObject>, NodeInstanceConstructor {

    private final MongoTemplate mongoTemplate;
    private static final String collectionName = "jieshixing";

    public MongodbNodeInstanceConstructor(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public JSONObject get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {

        JSONObject content = new JSONObject(dataFetchingEnvironment.getArgument("data"));
        String fieldType = ((GraphQLObjectType) dataFetchingEnvironment.getFieldType()).getName();

        return this.createNodeInstance(fieldType,content);
    }

    @Override
    public JSONObject createNodeInstance(String nodeType, JSONObject data) {
        data.put("nodeType",nodeType);
        return mongoTemplate.insert(data, collectionName);
    }

}
