package cora.util;

import java.util.HashMap;
import java.util.Map;

public class IngressTemplate {
    private static final String queryTemplate = "query_${nodeType}(_id:${id}){${resp}}";

    public static String getQueryTemplate(String nodeType){
        Map<String,String> map = new HashMap<>();
        map.put("nodeType",nodeType);
        return VelocityTemplate.build(queryTemplate, map);
    }
}
