package cora.datafetcher;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface CoraRepository<T> {
    T createNodeInstance(String nodeType, JSONObject data);

    T deleteNodeInstanceById(String id);

    T queryNodeInstanceById(String id, String nodeType);

    List<T> queryNodeInstanceList(String nodeType);

    List<T> queryNodeInstanceList(List<String> instanceIds);

    List<T> queryNodeInstanceList(String nodeType, JSONObject filters);

    T updateNodeInstance(String nodeType, String id, JSONObject data);
}
