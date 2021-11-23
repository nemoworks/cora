package cora.datafetcher.custom;

import com.alibaba.fastjson.JSONObject;

public class DemoCustomCoraRepositoryImpl implements CustomCoraRepository{
    @Override
    public JSONObject resolve(JSONObject fields, StorageHelper storageHelper, String coreNodeType) {
        System.out.println("nodeType:" + coreNodeType);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data","tc");
        return jsonObject;
    }
}
