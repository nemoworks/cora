package cora.parser;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import cora.antlr.json.JSONLexer;
import cora.antlr.json.JSONParser;
import graphql.language.Definition;
import graphql.language.FieldDefinition;
import graphql.language.ObjectTypeDefinition;
import graphql.language.TypeName;
import graphql.parser.MultiSourceReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.google.gson.stream.JsonToken.END_DOCUMENT;

public class JsonSchemaParser implements CoraParser{
    private static final Gson parser = new Gson();

    @Override
    public boolean isValid(String schema) {
        try {
            return isJsonValid(new StringReader(schema));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isJsonValid(final Reader reader) throws IOException {
        return isJsonValid(new JsonReader(reader));
    }

    private static boolean isJsonValid(final JsonReader jsonReader) throws IOException {
        try {
            JsonToken token;
            loop: while ((token = jsonReader.peek()) != END_DOCUMENT && token != null) {
                switch (token) {
                    case BEGIN_ARRAY:
                        jsonReader.beginArray();
                        break;
                    case END_ARRAY:
                        jsonReader.endArray();
                        break;
                    case BEGIN_OBJECT:
                        jsonReader.beginObject();
                        break;
                    case END_OBJECT:
                        jsonReader.endObject();
                        break;
                    case NAME:
                        jsonReader.nextName();
                        break;
                    case STRING:
                    case NUMBER:
                    case BOOLEAN:
                    case NULL:
                        jsonReader.skipValue();
                        break;
                    case END_DOCUMENT:
                        break loop;
                    default:
                        throw new AssertionError(token);
                }
            }
            return true;
        } catch (final MalformedJsonException ignored) {
            return false;
        }
    }

    public List<Definition> parseSchema(String schema) {
        //JsonObject json = parser.fromJson(schema, JsonObject.class);
        JSONAST parsedAST = this.parse(schema);
        return parse(parsedAST);
    }

    public JSONAST parse(String schema){
        return JSONAST.parseJSON(schema);
    }

    public List<Definition> parse(JSONAST jsonast){
        List<Definition> definitions = new ArrayList<>();
        JSONAST properties = jsonast.getJSONAST("properties");
        String name = jsonast.getString("title");
        ObjectTypeDefinition.Builder builder = ObjectTypeDefinition.newObjectTypeDefinition();
        List<FieldDefinition> fieldDefinitions = new ArrayList<>();
        if(properties != null){
            properties.getMap().keySet().forEach(key->{
                JSONAST propertiesJSONAST = properties.getJSONAST(key);
                JsonSchemaType type = JsonSchemaType.valueOf(propertiesJSONAST.getString("type"));
                switch (type) {
                    case string:
                        fieldDefinitions.add(new FieldDefinition(key, new TypeName("String")));
                        break;
                    case number:
                        fieldDefinitions.add(new FieldDefinition(key, new TypeName("Int")));
                        break;
                    case link:
                        fieldDefinitions.add(new FieldDefinition(key, new TypeName(propertiesJSONAST.getString("linkTo"))));
                        break;
                    default:
                        break;
                }
            });
        }
        ObjectTypeDefinition objectTypeDefinition = builder.name(name).fieldDefinitions(fieldDefinitions).build();
        definitions.add(objectTypeDefinition);
        return definitions;
    }

//    public List<Definition> parse(JsonObject schema) {
//        List<Definition> definitions = new ArrayList<>();
//        JsonObject properties = schema.getAsJsonObject("properties");
//        String name = schema.get("title").getAsString();
//        ObjectTypeDefinition.Builder builder = ObjectTypeDefinition.newObjectTypeDefinition();
//        List<FieldDefinition> fieldDefinitions = new ArrayList<>();
//        if (properties != null) {
//            HashMap<String, LinkedTreeMap> fieldMap = new Gson().fromJson(properties.toString(), HashMap.class);
//            fieldMap.forEach((s, linkedTreeMap) -> {
//                JsonSchemaType type = JsonSchemaType.valueOf(linkedTreeMap.get("type").toString());
//                switch (type) {
//                    case string:
//                        fieldDefinitions.add(new FieldDefinition(s, new TypeName("String")));
//                        break;
//                    case number:
//                        fieldDefinitions.add(new FieldDefinition(s, new TypeName("Int")));
//                        break;
//                    case link:
//                        fieldDefinitions.add(new FieldDefinition(s, new TypeName(linkedTreeMap.get("linkTo").toString())));
//                        break;
//                    default:
//                        break;
//                }
//            });
//        }
//        ObjectTypeDefinition objectTypeDefinition = builder.name(name).fieldDefinitions(fieldDefinitions).build();
//        definitions.add(objectTypeDefinition);
//        return definitions;
//    }

    public static void main(String[] args) {
        String s = "{\n" +
                "  \"type\": \"object\",\n" +
                "  \"title\": \"未确认款项\",\n" +
                "  \"properties\": {\n" +
                "    \"amount\": {\n" +
                "      \"type\": \"number\",\n" +
                "      \"title\": \"到账金额(元)\"\n" +
                "    },\n" +
                "    \"company\": {\n" +
                "      \"enum\": [\n" +
                "        \"杰世欣\",\n" +
                "        \"骏岭\",\n" +
                "        \"其他\"\n" +
                "      ],\n" +
                "      \"type\": \"string\",\n" +
                "      \"title\": \"公司名称\"\n" +
                "    },\n" +
                "    \"appendix\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"title\": \"备注\"\n" +
                "    },\n" +
                "    \"customer\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"title\": \"客户单位\"\n" +
                "    },\n" +
                "    \"tradeDate\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"title\": \"交易时间\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        JsonSchemaParser jsonSchemaParser = new JsonSchemaParser();
        List<Definition> definitions = jsonSchemaParser.parseSchema(s);
        System.out.println("definitions");
    }
}
