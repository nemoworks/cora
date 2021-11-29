package cora.parser.sql;

import cora.datafetcher.QueryFilterMapper;
import cora.parser.JsonAST;
import cora.parser.JsonArray;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MongodbQueryFilterParser {
    private QueryFilterMapper<Criteria> queryFilterMapper;

    public MongodbQueryFilterParser(QueryFilterMapper queryFilterMapper) {
        this.queryFilterMapper = queryFilterMapper;
    }

    public Query parse(JsonAST filterContents){
        Query query = new Query();
        filterContents.getMap().keySet().forEach(key->{
            switch (key) {
                case "_and": {
                    JsonArray jsonArray = filterContents.getJsonArray(key);
                    List<Criteria> criteriaList = new ArrayList<>();
                    for(int i = 0;i< jsonArray.getSize();i++){
                        JsonAST jsonAST = jsonArray.getJsonAST(i);
                        jsonAST.getMap().keySet().forEach(key1->{
                            JsonAST jsonast = jsonAST.getJSONAST(key1);
                            String eq = jsonast.getString("_eq");
                            Criteria criteria = queryFilterMapper.equalOperation(key1, eq);
                            criteriaList.add(criteria);
                        });
                    }
                    Criteria[] criterias = new Criteria[criteriaList.size()];
                    Criteria criteria = queryFilterMapper.andOperation(criteriaList.toArray(criterias));
                    query.addCriteria(criteria);
                    break;
                }
                case "_or":{
                    JsonArray jsonArray = filterContents.getJsonArray(key);
                    List<Criteria> criteriaList = new ArrayList<>();
                    for(int i = 0;i< jsonArray.getSize();i++){
                        JsonAST jsonAST = jsonArray.getJsonAST(i);
                        jsonAST.getMap().keySet().forEach(key1->{
                            JsonAST jsonast = jsonAST.getJSONAST(key1);
                            String eq = jsonast.getString("_eq");
                            Criteria criteria = queryFilterMapper.equalOperation(key1, eq);
                            criteriaList.add(criteria);
                        });
                    }
                    Criteria[] criterias = new Criteria[criteriaList.size()];
                    Criteria criteria = queryFilterMapper.orOperation(criteriaList.toArray(criterias));
                    query.addCriteria(criteria);
                    break;
                }
                default:{
                    JsonAST jsonast = filterContents.getJSONAST(key);
                    String eq = jsonast.getString("_eq");
                    Criteria criteria = queryFilterMapper.equalOperation(key, eq);
                    query.addCriteria(criteria);
                    break;
                }
            }
        });
        return query;
    }
}
