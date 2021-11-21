package cora.util;

import cora.graph.CoraGraph;

import java.util.HashMap;
import java.util.Map;

public class IngressTemplate {
    private static final String queryTemplate = "{query_${nodeType}(_id:\"${id}\"){${resp}}}";

    private static final String queryListTemplate = "{query_${nodeType}_list{${resp}}}";

    private static final String createTemplate = "{create_${nodeType}(data:{${data}}){${resp}}}";

    public static String getQueryTemplate(String nodeType){
        Map<String,String> map = new HashMap<>();
        map.put("nodeType",StringUtil.lowerCase(nodeType));
        StringBuilder sb = new StringBuilder();
        CoraGraph.CoraNodeMap.get(nodeType).getTypeMap().keySet().forEach(key->{
            sb.append(key).append("\n");
        });
        map.put("resp",sb.toString());
        return VelocityTemplate.build(queryTemplate, map);
    }

    public static String getQueryListTemplate(String nodeType){
        Map<String,String> map = new HashMap<>();
        map.put("nodeType",StringUtil.lowerCase(nodeType));
        StringBuilder sb = new StringBuilder();
        CoraGraph.CoraNodeMap.get(nodeType).getTypeMap().keySet().forEach(key->{
            sb.append(key).append("\n");
        });
        map.put("resp",sb.toString());
        return VelocityTemplate.build(queryListTemplate, map);
    }

    public static String getCreateTemplate(String nodeType){
        Map<String,String> map = new HashMap<>();
        map.put("nodeType",StringUtil.lowerCase(nodeType));
        StringBuilder sb = new StringBuilder();
        CoraGraph.CoraNodeMap.get(nodeType).getTypeMap().keySet().forEach(key->{
            sb.append(key).append("\n");
        });
        map.put("resp",sb.toString());
        return VelocityTemplate.build(createTemplate, map);
    }
}
