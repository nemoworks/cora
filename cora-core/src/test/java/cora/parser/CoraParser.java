package cora.parser;

import java.util.List;

import graphql.language.Definition;

public interface CoraParser {

    List<Definition> parseSchema(String schema);

    boolean isValid(String schema);
}
