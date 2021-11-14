package cora.app;

import cora.util.CoraNodeAPITemplate;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.language.Document;
import graphql.language.OperationDefinition;
import graphql.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class APIController {

    private GraphQL graphQL;

    private final CoraBuilder coraBuilder;

    @Autowired
    public APIController(CoraBuilder coraBuilder) {
        this.coraBuilder = coraBuilder;
        this.graphQL = coraBuilder.createGraphQL();
    }

    @PostMapping(value = "/graphql")
    public ResponseEntity query(@RequestBody String schema){
//        JSONObject jsonObject = JSON.parseObject(query,JSONObject.class);
//        String schema = jsonObject.getString("query");
        if(schema.startsWith("type")){
            this.graphQL = coraBuilder.addTypeInGraphQL(schema);
            return ResponseEntity.ok(CoraNodeAPITemplate.build(schema));
        } else if (schema.startsWith("create")) {
            return ResponseEntity.ok("waiting...");
        } else {
            Parser parser = new Parser();
            Document document = parser.parseDocument(schema);
            if (document.getDefinitions().get(0) instanceof OperationDefinition) {
                ((OperationDefinition) document.getDefinitions().get(0)).getOperation().name();
            }
            ExecutionResult result = graphQL.execute(schema);
            if (result.getErrors().isEmpty())
                return ResponseEntity.ok(result.getData());
            return ResponseEntity.badRequest().body(result.getErrors());
        }
    }

}