package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;

public interface NodeInstanceConstructor {
    JSONObject createNodeInstance(String nodeType, JSONObject data);
}
