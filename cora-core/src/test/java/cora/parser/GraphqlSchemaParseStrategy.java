package cora.parser;

import graphql.language.Definition;
import graphql.language.Document;
import graphql.parser.Parser;

import java.util.List;

public class GraphqlSchemaParseStrategy implements ParseStrategy {
    private static final Parser parser = new Parser();

    public List<Definition> parse(String schema){
        Document document = parser.parseDocument(schema);
        return document.getDefinitions();
    }

    @Override
    public boolean isValid(String schema) {
        return false;
    }


}
