package cora.parser.sql;

import cora.datafetcher.QueryFilterMapper;
import cora.parser.JsonAST;
import cora.parser.JsonArray;

import java.util.ArrayList;
import java.util.List;

public class RelationalQueryFilterParser {
    private QueryFilterMapper<String> queryFilterMapper;

    public RelationalQueryFilterParser(QueryFilterMapper queryFilterMapper){
        this.queryFilterMapper = queryFilterMapper;
    }

    public String parse(JsonAST filterContents){
        StringBuilder query = new StringBuilder();
        filterContents.getMap().keySet().forEach(key->{
            switch (key) {
                case "_and": {
                    JsonArray jsonArray = filterContents.getJsonArray(key);
                    List<String> criteriaList = new ArrayList<>();
                    for(int i = 0;i< jsonArray.getSize();i++){
                        JsonAST jsonAST = jsonArray.getJsonAST(i);
                        jsonAST.getMap().keySet().forEach(key1->{
                            JsonAST jsonast = jsonAST.getJSONAST(key1);
                            String eq = jsonast.getString("_eq");
                            String criteria = queryFilterMapper.equalOperation(key1, eq);
                            criteriaList.add(criteria);
                        });
                    }
                    String[] criterias = new String[criteriaList.size()];
                    String criteria = queryFilterMapper.andOperation(criteriaList.toArray(criterias));
                    query.append(" AND ").append(criteria);
                    break;
                }
                case "_or":{
                    JsonArray jsonArray = filterContents.getJsonArray(key);
                    List<String> criteriaList = new ArrayList<>();
                    for(int i = 0;i< jsonArray.getSize();i++){
                        JsonAST jsonAST = jsonArray.getJsonAST(i);
                        jsonAST.getMap().keySet().forEach(key1->{
                            JsonAST jsonast = jsonAST.getJSONAST(key1);
                            String eq = jsonast.getString("_eq");
                            String criteria = queryFilterMapper.equalOperation(key1, eq);
                            criteriaList.add(criteria);
                        });
                    }
                    String[] criterias = new String[criteriaList.size()];
                    String criteria = queryFilterMapper.orOperation(criteriaList.toArray(criterias));
                    query.append(" AND ").append(criteria);
                    break;
                }
                default:{
                    JsonAST jsonast = filterContents.getJSONAST(key);
                    String eq = jsonast.getString("_eq");
                    String criteria = queryFilterMapper.equalOperation(key, eq);
                    query.append(" AND ").append(criteria);
                    break;
                }
            }
        });
        return query.toString();
    }
}
