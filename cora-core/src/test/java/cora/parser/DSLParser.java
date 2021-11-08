package cora.parser;

import graphql.language.Definition;

import java.util.List;
import java.util.Map;

public class DSLParser {
    private static final Map<String, ParseStrategy> parseStrategyMap = Map.of("json", new JsonSchemaParseStrategy(),
            "graphql", new GraphqlSchemaParseStrategy());

    public static List<Definition> parseSchema(String schema) {
        if (parseStrategyMap.get("json").isValid(schema)) {
            return parseStrategyMap.get("json").parse(schema);
        } else
            return parseStrategyMap.get("graphql").parse(schema);
    }
}
