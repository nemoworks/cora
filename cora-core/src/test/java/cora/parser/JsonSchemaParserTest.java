package cora.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import graphql.language.Definition;
import graphql.language.ObjectTypeDefinition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import javax.json.JsonObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonSchemaParserTest {

    JsonSchemaParser jsonSchemaParser;
    List<String> schemas = new ArrayList<>();

    @BeforeEach
    void setUp() {
        jsonSchemaParser = new JsonSchemaParser();

        final String path = "classpath:test/schemafortest.json";
        File file = null;
        StringBuilder sb = new StringBuilder();
        try {
            file = ResourceUtils.getFile(path);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
                String readLine = null;
                while ((readLine = br.readLine()) != null) {
                    sb.append(readLine);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = (JSONArray) JSON.parse(sb.toString());
        for (Object jsonObject:jsonArray){
            schemas.add(jsonObject.toString());
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isNormalScemaValid(){
        assertTrue(jsonSchemaParser.isValid(schemas.get(0)));
    }

    @Test
    void isScemaWithoutNodetypeValid(){
        assertTrue(jsonSchemaParser.isValid(schemas.get(1)));
    }

    @Test
    void isSchemaWithoutTypeValid(){
        assertTrue(jsonSchemaParser.isValid(schemas.get(2)));
    }

    @Test
    void isSchemaWithoutPropertyValid(){
        assertTrue(jsonSchemaParser.isValid(schemas.get(3)));
    }

    @Test
    void isSchemaWithSyntaxErrorValid(){
        jsonSchemaParser.isValid(schemas.get(4).substring(0, 49));
    }

    @Test
    void parseNormalSchema(){
        List<Definition> definitions = jsonSchemaParser.parseSchema(schemas.get(0));
        ObjectTypeDefinition definition = (ObjectTypeDefinition) definitions.get(0);
        List children = definition.getChildren();
        List<String> childrenNames = new ArrayList<>();
        definition.getFieldDefinitions().forEach(fieldDefinition -> {
            childrenNames.add(fieldDefinition.getName());
        });
        assertArrayEquals(childrenNames.toArray(new String[0]), new String[]{"saler", "invoiceCompany"});

    }

    @Test
    void parseSchemaWithoutNodetype() {
        List<Definition> definitions = jsonSchemaParser.parseSchema(schemas.get(1));
        ObjectTypeDefinition definition = (ObjectTypeDefinition) definitions.get(0);
        String name = definition.getName();
        assertEquals(null, name);
    }

    @Test
    void parseSchemaWithouType(){
        List<Definition> definitions = jsonSchemaParser.parseSchema(schemas.get(2));
        ObjectTypeDefinition definition = (ObjectTypeDefinition) definitions.get(0);
        String name  = definition.getName();
        assertEquals("Bill", name);
    }

    @Test
    void parseSchemaWithoutProperty() {
        List<Definition> definitions = jsonSchemaParser.parseSchema(schemas.get(3));
        ObjectTypeDefinition definition = (ObjectTypeDefinition) definitions.get(0);
        List children = definition.getChildren();
        assertEquals(0, children.size());
    }
}