package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;

public interface NodeInstanceUpdater {
    JSONObject updateNodeInstance(String nodeType, String id, JSONObject data);
}
