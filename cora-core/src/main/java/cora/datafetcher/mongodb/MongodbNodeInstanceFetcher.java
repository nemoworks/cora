package cora.datafetcher.mongodb;

import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.NodeInstanceFetcher;
import org.springframework.data.mongodb.core.MongoTemplate;


public class MongodbNodeInstanceFetcher implements NodeInstanceFetcher {
    private final MongoTemplate mongoTemplate;

    private static final String collectionName = "jieshixing";

    public MongodbNodeInstanceFetcher(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public JSONObject queryNodeInstanceById(String id, String nodeType) {
        JSONObject result = mongoTemplate.findById(id, JSONObject.class, collectionName);
        return result;
    }
}
