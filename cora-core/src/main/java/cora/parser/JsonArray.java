package cora.parser;

import cora.antlr.json.JSONLexer;
import cora.antlr.json.JSONParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonArray {

    private final List<JsonAST> list;

    public JsonArray() {
        this.list = new ArrayList<>();
    }
    public JsonArray(List<JsonAST> list) {
        this.list = new ArrayList<>(list.size());
        this.list.addAll(list);
    }

    protected JsonArray(JSONParser.ArrContext arrayCtx) {
        this.list = arrayCtx.value()
                .stream()
                .map(valueContext -> new JsonAST(valueContext.obj()))
                .collect(Collectors.toList());
    }

    public static JsonArray parseArray(String text) {
        JSONLexer lexer = new JSONLexer(CharStreams.fromString(text));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JSONParser parser = new JSONParser(tokens);
        JSONParser.ArrContext arrayCtx = parser.arr();
        return new JsonArray(arrayCtx);
    }

    public JsonAST getJsonAST(int index) {
        return list.get(index);
    }

    public void add(JsonAST JsonAST) {
        list.add(JsonAST);
    }

    @Override
    public String toString() {
        return toJSONString();
    }

    public List<JsonAST> getList() {
        return list;
    }

    public Integer getSize(){
        return list.size();
    }

    public String toJSONString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        List<String> strList = list.stream().map(JsonAST::toString).collect(Collectors.toList());
        sb.append(String.join(",", strList));
        sb.append("]");
        return sb.toString();
    }
}
