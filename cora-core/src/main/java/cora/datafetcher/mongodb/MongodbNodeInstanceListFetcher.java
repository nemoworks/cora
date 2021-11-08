package cora.datafetcher.mongodb;

import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.NodeInstanceListFetcher;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MongodbNodeInstanceListFetcher implements DataFetcher<List<JSONObject>>, NodeInstanceListFetcher {
    private final MongoTemplate mongoTemplate;

    private static final String collectionName = "jieshixing";

    public MongodbNodeInstanceListFetcher(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<JSONObject> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {

        String fieldType = ((GraphQLObjectType)((GraphQLList) dataFetchingEnvironment.getFieldType()).getWrappedType()).getName();
        if(dataFetchingEnvironment.getSource()!=null){
            String name = dataFetchingEnvironment.getFieldDefinition().getName();
            JSONObject source = dataFetchingEnvironment.getSource();
            ArrayList<String> ids = source.getObject(name, ArrayList.class);
            return queryNodeInstanceList(ids);
        }
        return queryNodeInstanceList(fieldType);
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
