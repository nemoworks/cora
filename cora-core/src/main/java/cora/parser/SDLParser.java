package cora.parser;


import cora.graph.CustomIngress;
import cora.util.StringUtil;
import graphql.language.*;
import graphql.parser.Parser;
import org.apache.commons.lang.StringUtils;

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

    public CustomIngress parseCustomIngressSchema(String schema){
        Document document = super.parseDocument(schema);
        OperationDefinition operationDefinition = (OperationDefinition) document.getDefinitions().get(0);
        Field field = (Field) operationDefinition.getSelectionSet().getSelections().get(0);
        CustomIngress customIngress = new CustomIngress();
        field.getArguments().forEach(argument -> {
            if(StringUtils.equals(argument.getName(),"nodeType")){
                customIngress.setNodeType(((StringValue)argument.getValue()).getValue());
            }else if(StringUtils.equals(argument.getName(),"apiName")){
                customIngress.setApiName(((StringValue)argument.getValue()).getValue());
            }else if(StringUtils.equals(argument.getName(),"code")){
                customIngress.setCodeImpl(((StringValue)argument.getValue()).getValue());
            }
        });
        return customIngress;
    }

}