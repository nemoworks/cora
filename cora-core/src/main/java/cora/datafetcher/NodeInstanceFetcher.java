package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;

public interface NodeInstanceFetcher {
    JSONObject queryNodeInstanceById(String id, String nodeType);
}
