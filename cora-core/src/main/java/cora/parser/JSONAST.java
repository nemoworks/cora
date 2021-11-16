package cora.parser;

import cora.antlr.json.JSONLexer;
import cora.antlr.json.JSONParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.HashMap;
import java.util.Map;

public class JSONAST {

    private Map<String, Object> map;

    protected JSONAST(JSONParser.ObjContext objCtx) {
        this.map = new HashMap<>();
        for (JSONParser.PairContext pairCtx : objCtx.pair()) {
            String key = pairCtx.STRING().getText();
            map.put(key.substring(1, key.length() - 1), pairCtx.value());
        }
    }

    public JSONAST getJSONAST(String key) {
        JSONParser.ValueContext value = (JSONParser.ValueContext) map.get(key);
        if (value == null) {
            return null;
        }
        return new JSONAST(value.obj());
    }

    public String getString(String key) {
        Object value = map.get(key);
        if (value == null) {
            return null;
        }
        if (JSONParser.ValueContext.class.isInstance(value)) {
            JSONParser.ValueContext ctx = (JSONParser.ValueContext) value;
            String newValue = ctx.STRING().getText();
            map.put(key, newValue.substring(1, newValue.length() - 1));
        }
        return (String) map.get(key);
    }

    public int getInt(String key) {
        String value = getString(key);
        if (value == null || "".equals(value)) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    public long getLong(String key) {
        String value = getString(key);
        if (value == null || "".equals(value)) {
            return 0L;
        }
        return Long.parseLong(value);
    }

    public double getDouble(String key) {
        String value = getString(key);
        if (value == null || "".equals(value)) {
            return 0.0;
        }
        return Double.parseDouble(value);
    }

    public void put(String key, Object object) {
        map.put(key, object);
    }

    public static JSONAST parseJSON(String text) {
        JSONLexer lexer = new JSONLexer(CharStreams.fromString(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        JSONParser.ObjContext objCtx = parser.obj();
        return new JSONAST(objCtx);
    }


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

}