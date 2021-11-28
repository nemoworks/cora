package cora.util;


import java.util.Arrays;
import java.util.List;

public class GQLTemplate {

    private static final List<String> filter_Definition_in_query_list = Arrays.asList("_and","_or");

    private static final List<String> filter_items_in_query_list = Arrays.asList("_eq","_neq","_gt","_lt");

    //meta filter definition for each field("_eq","_neq","_gt","_lt"...)
    private static final String FILTER_ITEM_FOR_NODE_INSTANCE = "filters";

    //input type for node instance
    private static final String INPUT_TYPE_FOR_NODE_INSTANCE_PRE = "";
    private static final String INPUT_TYPE_FOR_NODE_INSTANCE_SUFFIX = "_input";

    //query single node instance
    private static final String QUERY_SINGLE_INSTANCE_PRE = "query_";
    private static final String QUERY_SINGLE_INSTANCE_SUFFIX = "";

    //query node instance list
    private static final String QUERY_INSTANCE_LIST_PRE = "query_";
    private static final String QUERY_INSTANCE_LIST_SUFFIX = "_list";

    //create node instance
    private static final String CREATE_NODE_INSTANCE_PRE = "create_";
    private static final String CREATE_NODE_INSTANCE_SUFFIX = "";

    private static final String FILTER_NODE_INSTANCE_PRE = "filters_of_";
    private static final String FILTER_NODE_INSTANCE_SUFFIX = "";

    public static String inputTypeForNodeInstance(String graphNodeName) {
        return INPUT_TYPE_FOR_NODE_INSTANCE_PRE + StringUtil.upperCase(graphNodeName) + INPUT_TYPE_FOR_NODE_INSTANCE_SUFFIX;
    }

    public static String querySingleInstance(String graphNodeName) {
        return QUERY_SINGLE_INSTANCE_PRE + StringUtil.lowerCase(graphNodeName) + QUERY_SINGLE_INSTANCE_SUFFIX;
    }

    public static String queryInstanceList(String graphNodeName) {
        return QUERY_INSTANCE_LIST_PRE + StringUtil.lowerCase(graphNodeName) + QUERY_INSTANCE_LIST_SUFFIX;
    }

    public static String createNodeInstance(String graphNodeName) {
        return CREATE_NODE_INSTANCE_PRE + StringUtil.lowerCase(graphNodeName) + CREATE_NODE_INSTANCE_SUFFIX;
    }

    public static String filtersOfNodeInstance(String graphNodeName){
        return FILTER_NODE_INSTANCE_PRE+StringUtil.lowerCase(graphNodeName)+FILTER_NODE_INSTANCE_SUFFIX;
    }

    public static List<String> getFilter_Definition_in_query_list() {
        return filter_Definition_in_query_list;
    }

    public static List<String> getFilter_items_in_query_list() {
        return filter_items_in_query_list;
    }

    public static String getFilterItemForNodeInstance() {
        return FILTER_ITEM_FOR_NODE_INSTANCE;
    }
}
