package cora.parser.sql;

import cora.datafetcher.QueryFilterMapper;
import cora.graph.CoraGraph;
import cora.parser.JsonAST;
import cora.parser.JsonArray;
import graphql.language.ListType;
import graphql.language.Type;
import graphql.language.TypeName;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MongodbQueryFilterParser {
    private QueryFilterMapper<Criteria> queryFilterMapper;

    public MongodbQueryFilterParser(QueryFilterMapper queryFilterMapper) {
        this.queryFilterMapper = queryFilterMapper;
    }

    public Query parse(String nodeType,JsonAST filterContents){
        Query query = new Query();
        filterContents.getMap().keySet().forEach(key->{
            switch (key) {
                case "_and": {
                    JsonArray jsonArray = filterContents.getJsonArray(key);
                    List<Criteria> criteriaList = this.parseCriteriaInAndOr(nodeType,jsonArray);
                    Criteria[] criterias = new Criteria[criteriaList.size()];
                    Criteria criteria = queryFilterMapper.andOperation(criteriaList.toArray(criterias));
                    query.addCriteria(criteria);
                    break;
                }
                case "_or":{
                    JsonArray jsonArray = filterContents.getJsonArray(key);
                    List<Criteria> criteriaList = this.parseCriteriaInAndOr(nodeType,jsonArray);
                    Criteria[] criterias = new Criteria[criteriaList.size()];
                    Criteria criteria = queryFilterMapper.orOperation(criteriaList.toArray(criterias));
                    query.addCriteria(criteria);
                    break;
                }
                default:{
                    JsonAST jsonast = filterContents.getJSONAST(key);
                    Type type = CoraGraph.getCoraNode(nodeType).getTypeMap().get(key);
                    if(type instanceof ListType)
                        return;
                    String typeName = ((TypeName)type).getName();
                    Criteria criteria = this.parseCriteria(typeName,key,jsonast);
                    query.addCriteria(criteria);
                    break;
                }
            }
        });
        return query;
    }

    private List<Criteria> parseCriteriaInAndOr(String nodeType,JsonArray jsonArray){
        List<Criteria> criteriaList = new ArrayList<>();
        for(int i = 0;i< jsonArray.getSize();i++){
            JsonAST jsonAST = jsonArray.getJsonAST(i);
            jsonAST.getMap().keySet().forEach(key1->{
                JsonAST jsonast = jsonAST.getJSONAST(key1);
                Type type = CoraGraph.getCoraNode(nodeType).getTypeMap().get(key1);
                if(type instanceof ListType)
                    return;
                String typeName = ((TypeName)type).getName();
                Criteria criteria = this.parseCriteria(typeName, key1, jsonast);
                criteriaList.add(criteria);
            });
        }
        return criteriaList;
    }

    private Criteria parseCriteria(String typeName,String key,JsonAST jsonast){
        Criteria criteria = new Criteria();
        if(typeName.equals("String")){
            if(jsonast.getString("_eq")!=null){
                criteria = queryFilterMapper.equalOperation(key,jsonast.getString("_eq") );
            }else if(jsonast.getString("_neq")!=null){
                criteria = queryFilterMapper.neqOperation(key,jsonast.getString("_neq") );
            }
        }else if(typeName.equals("Int")){
            if(jsonast.getMap().containsKey("_eq")){
                criteria = queryFilterMapper.equalOperation(key,jsonast.getInt("_eq") );
            }else if(jsonast.getMap().containsKey("_neq")){
                criteria = queryFilterMapper.neqOperation(key,jsonast.getInt("_neq") );
            }else if(jsonast.getMap().containsKey("_lt")){
                criteria = queryFilterMapper.ltOperation(key,jsonast.getInt("_lt") );
            }else if(jsonast.getMap().containsKey("_gt")){
                criteria = queryFilterMapper.gtOperation(key, jsonast.getInt("_gt"));
            }
        }
        return criteria;
    }
}
