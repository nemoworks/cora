package cora.parser;

import graphql.language.Definition;

import java.util.List;

public interface ParseStrategy {
    List<Definition> parse(String schema);

    boolean isValid(String schema);
}
