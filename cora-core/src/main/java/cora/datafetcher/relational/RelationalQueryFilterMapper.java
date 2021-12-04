package cora.datafetcher.relational;

import cora.datafetcher.QueryFilterMapper;

public class RelationalQueryFilterMapper implements QueryFilterMapper<String> {
    @Override
    public String equalOperation(String key, Object value) {
        String query = "data->>'" + key + "'= " + "'" + value + "'";
        return query;
    }

    @Override
    public String andOperation(String[] fields) {
        StringBuilder query = new StringBuilder();
        for(int i = 0; i < fields.length - 1; i++) {
            query.append(fields[i]).append(" AND ");
        }
        query.append(fields[fields.length-1]);
        return query.toString();
    }

    @Override
    public String orOperation(String[] fields) {
        StringBuilder query = new StringBuilder();
        for(int i = 0; i < fields.length-1; i++) {
            query.append(fields[i]).append(" OR ");
        }
        query.append(fields[fields.length-1]);
        return query.toString();
    }

    @Override
    public String gtOperation(String key, Object value) {
        String query = null;
        String type = value.getClass().getSimpleName();
        if (type.equals("Integer")){
            query = "(data->>'" + key + "')::int> " + value;
        }
        return query;
    }

    @Override
    public String ltOperation(String key, Object value) {
        String query = null;
        String type = value.getClass().getSimpleName();
        if (type.equals("Integer")){
            query = "(data->>'" + key + "')::int< " + value;
        }
        return query;
    }

    @Override
    public String neqOperation(String key, Object value) {
        String query = "data->>'" + key + "'!= " + "'" + value + "'";
        return query;
    }
}
