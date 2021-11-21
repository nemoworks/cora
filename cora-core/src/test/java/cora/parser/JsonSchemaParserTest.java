package cora.parser;

import graphql.language.Definition;
import graphql.language.ObjectTypeDefinition;
import graphql.language.Type;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonSchemaParserTest {

    JSONSchemaParser jsonSchemaParser;

    // a normal schema with $ref
    private final String schema1 = "{\n" +
            "    \"type\": \"OBJECT\",\n" +
            "    \"nodeType\": \"Bill\",\n" +
            "    \"properties\": {\n" +
            "      \"invoiceCompany\": {\n" +
            "        \"type\": \"STRING\",\n" +
            "        \"title\": \"公司名\"\n" +
            "      },\n" +
            "      \"saler\": {\n" +
            "        \"$ref\": \"#/$defs/Saler\"\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    // a schema without "nodeType"
    private final String schema2 = "{\n" +
            "    \"type\": \"OBJECT\",\n" +
            "    \"properties\": {\n" +
            "      \"invoiceCompany\": {\n" +
            "        \"type\": \"STRING\",\n" +
            "        \"title\": \"公司名\"\n" +
            "      },\n" +
            "      \"saler\": {\n" +
            "        \"$ref\": \"#/$defs/Saler\"\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    // a schema without "type"
    String schema3 = "{\n" +
            "    \"nodeType\": \"Bill\",\n" +
            "    \"properties\": {\n" +
            "      \"invoiceCompany\": {\n" +
            "        \"type\": \"STRING\",\n" +
            "        \"title\": \"公司名\"\n" +
            "      },\n" +
            "      \"saler\": {\n" +
            "        \"$ref\": \"#/$defs/Saler\"\n" +
            "      }\n" +
            "    }\n" +
            "  }";

    // a schema without "properties"
    private final String schema4 = "{\n" +
            "    \"type\": \"OBJECT\",\n" +
            "    \"nodeType\": \"Bill\"\n" +
            "  }";

    // a schema with syntax error
    private final String schema5 = "{\n" +
            "    \"type\": \"OBJECT\",\n" +
            "    \"nodeType\": \"Bill\",\n" +
            "    \"properties\": {\n";

    @BeforeEach
    void setUp() {
        jsonSchemaParser = new JSONSchemaParser();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isValid() {
        assertTrue(jsonSchemaParser.isValid(schema1));
        assertTrue(jsonSchemaParser.isValid(schema2));
        assertTrue(jsonSchemaParser.isValid(schema3));
        assertTrue(jsonSchemaParser.isValid(schema4));
        assertFalse(jsonSchemaParser.isValid(schema5));
    }

    @Test
    void parseSchema() {
        List<Definition> definitions1 = jsonSchemaParser.parseSchema(schema1);
        assertEquals(1, definitions1.size());
        ObjectTypeDefinition definition1 = (ObjectTypeDefinition) definitions1.get(0);
        String name1  = definition1.getName();
        assertEquals("Bill", name1);
        List children1 = definition1.getChildren();
        assertEquals(2, children1.size());
        List<String> childrenNames = new ArrayList<>();
        definition1.getFieldDefinitions().forEach(fieldDefinition -> {
            childrenNames.add(fieldDefinition.getName());
        });
        assertArrayEquals(childrenNames.toArray(new String[0]), new String[]{"saler", "invoiceCompany"});

        List<Definition> definitions2 = jsonSchemaParser.parseSchema(schema2);
        assertEquals(1, definitions2.size());
        ObjectTypeDefinition definition2 = (ObjectTypeDefinition) definitions2.get(0);
        String name2  = definition2.getName();
        assertEquals(null, name2);
        List children2 = definition2.getChildren();
        assertEquals(2, children2.size());
    }
}