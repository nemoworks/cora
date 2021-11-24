package cora.datafetcher.custom;

import com.alibaba.fastjson.JSONObject;

public interface CustomCoraRepository {
    JSONObject resolve(JSONObject fields, StorageHelper storageHelper,String coreNodeType);
}
