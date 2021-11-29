package cora.schema;

import cora.util.GQLTemplate;
import graphql.language.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilterDefinitionBuilder {
    public static InputObjectTypeDefinition build(String name, Map<String, Type> typeMap){
        List<InputValueDefinition> inputValueDefinitions = new ArrayList<>();
        //input type map
        typeMap.keySet().forEach(key->{
            InputValueDefinition inputValueDefinition =
                    new InputValueDefinition(key, new TypeName(GQLTemplate.getFilterItemForNodeInstance()));
            inputValueDefinitions.add(inputValueDefinition);
        });
        //_and,_or ...
        GQLTemplate.getFilter_Definition_in_query_list().forEach(definition->{
            InputValueDefinition inputValueDefinition = new InputValueDefinition(definition
                    , new ListType(new TypeName(GQLTemplate.filtersOfNodeInstance(name))));
            inputValueDefinitions.add(inputValueDefinition);
        });
       InputObjectTypeDefinition inputObjectTypeDefinition = InputObjectTypeDefinition.newInputObjectDefinition()
                .name(GQLTemplate.filtersOfNodeInstance(name))
                .inputValueDefinitions(inputValueDefinitions).build();
        return inputObjectTypeDefinition;
    }
}
