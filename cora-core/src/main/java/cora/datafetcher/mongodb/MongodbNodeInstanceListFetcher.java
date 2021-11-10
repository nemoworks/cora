package cora.datafetcher.mongodb;

import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.NodeInstanceListFetcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MongodbNodeInstanceListFetcher implements NodeInstanceListFetcher {
    private final MongoTemplate mongoTemplate;

    private static final String collectionName = "jieshixing";

    public MongodbNodeInstanceListFetcher(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<JSONObject> queryNodeInstanceList(String nodeType) {
        Query query = new Query();
        query.addCriteria(Criteria.where("nodeType").is(nodeType));
        List<JSONObject> jsonObjects = mongoTemplate.find(query, JSONObject.class, collectionName);
        return jsonObjects;
    }

    @Override
    public List<JSONObject> queryNodeInstanceList(List<String> instanceIds) {
        List<JSONObject> results = new ArrayList<>();
        instanceIds.forEach(instanceId->{
            JSONObject temp = mongoTemplate.findById(instanceId, JSONObject.class, collectionName);
            results.add(temp);
        });
        return results;
    }

}
