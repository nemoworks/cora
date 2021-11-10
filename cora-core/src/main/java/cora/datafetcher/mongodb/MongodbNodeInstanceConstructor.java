package cora.datafetcher.mongodb;

import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.NodeInstanceConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongodbNodeInstanceConstructor implements NodeInstanceConstructor {

    private final MongoTemplate mongoTemplate;
    private static final String collectionName = "jieshixing";

    public MongodbNodeInstanceConstructor(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public JSONObject createNodeInstance(String nodeType, JSONObject data) {
        data.put("nodeType",nodeType);
        return mongoTemplate.insert(data, collectionName);
    }

}
