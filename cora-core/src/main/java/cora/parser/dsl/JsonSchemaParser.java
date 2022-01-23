package cora.parser.dsl;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import cora.parser.JsonAST;
import cora.util.StringUtil;
import graphql.language.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static com.google.gson.stream.JsonToken.END_DOCUMENT;

public class JsonSchemaParser implements CoraParser {

    public enum JSONSchemaType {
        string, date, number, object, array,bool
    }

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
            loop:
            while ((token = jsonReader.peek()) != END_DOCUMENT && token != null) {
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
        JsonAST parsedAST = this.parse(schema);
        return parseAST(parsedAST);
    }

    private JsonAST parse(String schema) {
        return JsonAST.parseJSON(schema);
    }

    private List<Definition> parseAST(JsonAST jsonast) {
        List<Definition> definitions = new ArrayList<>();
        JsonAST properties = jsonast.getJSONAST("properties");
        String name = jsonast.getString("nodeType");
        ObjectTypeDefinition.Builder builder = ObjectTypeDefinition.newObjectTypeDefinition();

        //properties
        List<FieldDefinition> fieldDefinitions = new ArrayList<>();
        if (properties != null) {
            properties.getMap().keySet().forEach(key -> {
                JsonAST propertiesJsonAST = properties.getJSONAST(key);
                if (propertiesJsonAST.getString("type") == null) {
                    String s = propertiesJsonAST.getString("$ref");
                    String substring = s.substring(s.lastIndexOf('/') + 1);
                    fieldDefinitions.add(new FieldDefinition(key, new TypeName(StringUtil.upperCase(substring))));
                } else if (propertiesJsonAST.getString("type").equals("array")) {
                    String s = propertiesJsonAST.getJSONAST("items").getString("$ref");
                    if (s != null) {
                        String substring = s.substring(s.lastIndexOf('/') + 1);
                        fieldDefinitions.add(new FieldDefinition(key, new ListType(new TypeName(StringUtil.upperCase(substring)))));
                    } else {
                        fieldDefinitions.add(new FieldDefinition(key, new ListType(new TypeName("String"))));
                    }
                } else {
                    JSONSchemaType type = JSONSchemaType.valueOf(propertiesJsonAST.getString("type"));
                    switch (type) {
                        case string:
                            fieldDefinitions.add(new FieldDefinition(key, new TypeName("String")));
                            break;
                        case number:
                            fieldDefinitions.add(new FieldDefinition(key, new TypeName("Int")));
                            break;
                        case date:
                            fieldDefinitions.add(new FieldDefinition(key, new TypeName("Date")));
                            break;
                        case bool:
                            fieldDefinitions.add(new FieldDefinition(key, new TypeName("Boolean")));
                            break;
                        default:
                            break;
                    }
                }
            });
        }
        ObjectTypeDefinition objectTypeDefinition = builder.name(name).fieldDefinitions(fieldDefinitions).build();
        definitions.add(objectTypeDefinition);
        return definitions;
    }

    public static void main(String[] args) {
        String s = "{\n" +
                "    \"type\": \"OBJECT\",\n" +
                "    \"nodeType\": \"GrossProfit\",\n" +
                "    \"properties\": {\n" +
                "      \"date\": {\n" +
                "        \"title\": \"日期\",\n" +
                "        \"type\": \"STRING\"\n" +
                "      },\n" +
                "      \"amount\": {\n" +
                "        \"title\": \"金额\",\n" +
                "        \"type\": \"STRING\"\n" +
                "      },\n" +
                "      \"salerExpenditures\":{\n" +
                "        \"title\":\"销售支出集合\",\n" +
                "        \"type\":\"ARRAY\",\n" +
                "        \"items\":{\n" +
                "          \"$ref\":\"#/$defs/SalerExpenditure\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"saler\":{\n" +
                "        \"$ref\":\"#/$defs/Saler\"\n" +
                "      }\n" +
                "    }\n" +
                "  }";
        JsonSchemaParser jsonSchemaParser = new JsonSchemaParser();
        List<Definition> definitions = jsonSchemaParser.parseSchema(s);
        System.out.println("definitions");
    }
}
