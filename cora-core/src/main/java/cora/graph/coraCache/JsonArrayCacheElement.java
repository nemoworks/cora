package cora.graph.coraCache;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonArrayCacheElement implements CacheElement<JsonArrayCacheElement> {
    private List<JSONObject> element;

    public JsonArrayCacheElement(List<JSONObject> element) {
        this.element = element;
    }

    public List<JSONObject> getElement() {
        return element;
    }

    public void setElement(List<JSONObject> element) {
        this.element = element;
    }

}
