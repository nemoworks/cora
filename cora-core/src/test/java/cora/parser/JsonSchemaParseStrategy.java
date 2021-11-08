package cora.parser;

import static com.google.gson.stream.JsonToken.END_DOCUMENT;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;

import graphql.language.Definition;
import graphql.language.FieldDefinition;
import graphql.language.ObjectTypeDefinition;
import graphql.language.TypeName;

public class JsonSchemaParseStrategy implements ParseStrategy {

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

    public List<Definition> parse(String schema) {
        JsonObject json = parser.fromJson(schema, JsonObject.class);
        return parse(json);
    }

    public List<Definition> parse(JsonObject schema) {
        List<Definition> definitions = new ArrayList<>();
        JsonObject properties = schema.getAsJsonObject("properties");
        String name = schema.get("title").getAsString();
        ObjectTypeDefinition.Builder builder = ObjectTypeDefinition.newObjectTypeDefinition();
        List<FieldDefinition> fieldDefinitions = new ArrayList<>();
        if (properties != null) {
            HashMap<String, LinkedTreeMap> fieldMap = new Gson().fromJson(properties.toString(), HashMap.class);
            fieldMap.forEach((s, linkedTreeMap) -> {
                JsonSchemaType type = JsonSchemaType.valueOf(linkedTreeMap.get("type").toString());
                switch (type) {
                case STRING:
                    fieldDefinitions.add(new FieldDefinition(s, new TypeName("String")));
                    break;
                case INTEGER:
                    fieldDefinitions.add(new FieldDefinition(s, new TypeName("Int")));
                    break;
                case LINK:
                    fieldDefinitions.add(new FieldDefinition(s, new TypeName(linkedTreeMap.get("linkTo").toString())));
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

}
