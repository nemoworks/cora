package cora.datafetcher.mongodb;

import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.CoraRepository;
import cora.parser.JsonAST;
import cora.parser.sql.MongodbQueryFilterParser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MongodbCoraRepositoryImpl implements CoraRepository<JSONObject> {

    private final MongoTemplate mongoTemplate;
    private final String collectionName;

    public MongodbCoraRepositoryImpl(MongoTemplate mongoTemplate, String mongoCollection) {
        this.mongoTemplate = mongoTemplate;
        this.collectionName = mongoCollection;
    }

    @Override
    public JSONObject createNodeInstance(String nodeType, JSONObject data) {
        data.put("nodeType", nodeType);
        return mongoTemplate.insert(data, collectionName);
    }

    @Override
    public JSONObject deleteNodeInstanceById(String id) {
        return null;
    }

    @Override
    public JSONObject queryNodeInstanceById(String id, String nodeType) {
        JSONObject result = mongoTemplate.findById(id, JSONObject.class, collectionName);
        return result;
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
        instanceIds.forEach(instanceId -> {
            JSONObject temp = mongoTemplate.findById(instanceId, JSONObject.class, collectionName);
            results.add(temp);
        });
        return results;
    }

    @Override
    public List<JSONObject> queryNodeInstanceList(String nodeType, JSONObject filters) {
        JsonAST jsonAST = JsonAST.parseJSON(filters.toJSONString());
        MongodbQueryFilterParser mongodbQueryFilterParser =
                new MongodbQueryFilterParser(new MongodbQueryFilterMapper());
        Query query = mongodbQueryFilterParser.parse(nodeType,jsonAST);
        query.addCriteria(Criteria.where("nodeType").is(nodeType));
        List<JSONObject> jsonObjects = mongoTemplate.find(query, JSONObject.class, collectionName);
        return jsonObjects;
    }

    @Override
    public JSONObject updateNodeInstance(String nodeType, String id, JSONObject data) {
        return null;
    }
}
