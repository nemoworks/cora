package cora.parser.sql;

import cora.datafetcher.QueryFilterMapper;
import cora.graph.CoraGraph;
import cora.parser.JsonAST;
import cora.parser.JsonArray;
import graphql.language.ListType;
import graphql.language.Type;
import graphql.language.TypeName;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;

public class RelationalQueryFilterParser {
    private QueryFilterMapper<String> queryFilterMapper;

    public RelationalQueryFilterParser(QueryFilterMapper queryFilterMapper){
        this.queryFilterMapper = queryFilterMapper;
    }

    public String parse(String nodeType,JsonAST filterContents){
        StringBuilder query = new StringBuilder();
        filterContents.getMap().keySet().forEach(key->{
            switch (key) {
                case "_and": {
                    JsonArray jsonArray = filterContents.getJsonArray(key);
                    List<String> criteriaList = this.parseCriteriaInAndOr(nodeType,jsonArray);
                    String[] criterias = new String[criteriaList.size()];
                    String criteria = queryFilterMapper.andOperation(criteriaList.toArray(criterias));
                    query.append(" AND ").append(criteria);
                    break;
                }
                case "_or":{
                    JsonArray jsonArray = filterContents.getJsonArray(key);
                    List<String> criteriaList = this.parseCriteriaInAndOr(nodeType,jsonArray);
                    String[] criterias = new String[criteriaList.size()];
                    String criteria = queryFilterMapper.orOperation(criteriaList.toArray(criterias));
                    query.append(" AND ").append(criteria);
                    break;
                }
                default:{
                    JsonAST jsonast = filterContents.getJSONAST(key);
                    Type type = CoraGraph.getCoraNode(nodeType).getTypeMap().get(key);
                    if(type instanceof ListType)
                        return;
                    String typeName = ((TypeName)type).getName();
                    String criteria = this.parseCriteria(typeName,key,jsonast);
                    query.append(" AND ").append(criteria);
                    break;
                }
            }
        });
        return query.toString();
    }

    private List<String> parseCriteriaInAndOr(String nodeType, JsonArray jsonArray){
        List<String> criteriaList = new ArrayList<>();
        for(int i = 0;i< jsonArray.getSize();i++){
            JsonAST jsonAST = jsonArray.getJsonAST(i);
            jsonAST.getMap().keySet().forEach(key1->{
                JsonAST jsonast = jsonAST.getJSONAST(key1);
                Type type = CoraGraph.getCoraNode(nodeType).getTypeMap().get(key1);
                if(type instanceof ListType)
                    return;
                String typeName = ((TypeName)type).getName();
                String criteria = this.parseCriteria(typeName, key1, jsonast);
                criteriaList.add(criteria);
            });
        }
        return criteriaList;
    }

    private String parseCriteria(String typeName,String key,JsonAST jsonast){
        String criteria = null;
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
