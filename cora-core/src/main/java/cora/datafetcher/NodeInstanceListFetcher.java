package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface NodeInstanceListFetcher {
    List<JSONObject> queryNodeInstanceList(String nodeType);

    List<JSONObject> queryNodeInstanceList(List<String> instanceIds);
}
