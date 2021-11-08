package cora.parser;


import graphql.language.Definition;
import graphql.parser.Parser;

import java.util.List;

public class SDLParser extends Parser implements CoraParser {

    @Override
    public List<Definition> parseSchema(String schema) {
        return super.parse(schema).getDefinitions();
    }

    @Override
    public boolean isValid(String schema) {
        // TODO Auto-generated method stub
        return false;
    }

}