package cora.util;

public class GQLTemplate {
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

    public static String inputTypeForNodeInstance(String graphNodeName){
        return INPUT_TYPE_FOR_NODE_INSTANCE_PRE + StringUtil.upperCase(graphNodeName) + INPUT_TYPE_FOR_NODE_INSTANCE_SUFFIX;
    }

    public static String querySingleInstance(String graphNodeName){
        return QUERY_SINGLE_INSTANCE_PRE + StringUtil.lowerCase(graphNodeName) + QUERY_SINGLE_INSTANCE_SUFFIX;
    }

    public static String queryInstanceList(String graphNodeName){
        return QUERY_INSTANCE_LIST_PRE + StringUtil.lowerCase(graphNodeName) + QUERY_INSTANCE_LIST_SUFFIX;
    }

    public static String createNodeInstance(String graphNodeName){
        return CREATE_NODE_INSTANCE_PRE + StringUtil.lowerCase(graphNodeName) + CREATE_NODE_INSTANCE_SUFFIX;
    }
}
