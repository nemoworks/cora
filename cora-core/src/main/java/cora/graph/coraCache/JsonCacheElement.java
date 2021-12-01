package cora.graph.coraCache;

import com.alibaba.fastjson.JSONObject;

public class JsonCacheElement implements CacheElement<JsonCacheElement> {
    private JSONObject element;

    public JsonCacheElement(JSONObject element) {
        this.element = element;
    }

    public JSONObject getElement() {
        return element;
    }

    public void setElement(JSONObject element) {
        this.element = element;
    }
}
