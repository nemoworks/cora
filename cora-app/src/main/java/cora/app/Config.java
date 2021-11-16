package cora.app;

import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.CoraRepository;
import cora.datafetcher.CoraStorage;
import cora.datafetcher.mongodb.CoraMongodb;
import cora.datafetcher.mongodb.MongodbCoraRepositoryImpl;
import cora.parser.CoraParser;
import cora.parser.JSONSchemaParser;
import cora.schema.CoraRuntimeWiring;
import cora.schema.CoraTypeRegistry;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@Configuration
public class Config {

    @Autowired
    MongoTemplate mongoTemplate;

    @Bean
    public CoraRepository<JSONObject> mongodbCoraRepository() {
        return new MongodbCoraRepositoryImpl(mongoTemplate) {
        };
    }

    @Bean
    public CoraStorage<JSONObject> coraMongodb() {
        return new CoraMongodb(mongodbCoraRepository());
    }

    @Bean
    public DataFetcher<List<JSONObject>> coraNodeInstanceListFetcher() {
        return coraMongodb().getListFetcher();
    }

    @Bean
    public DataFetcher<JSONObject> coraNodeInstanceConstructor() {
        return coraMongodb().getCreator();
    }

    @Bean
    public DataFetcher<JSONObject> coraNodeInstanceFetcher() {
        return coraMongodb().getFetcher();
    }

    @Bean
    public CoraRuntimeWiring coraRuntimeWiring() {
        return new CoraRuntimeWiring(coraNodeInstanceFetcher()
                , coraNodeInstanceListFetcher()
                , coraNodeInstanceConstructor());
    }

    @Bean
    public CoraTypeRegistry coraTypeRegistry() {
        return new CoraTypeRegistry();
    }

    @Bean
    public CoraParser coraParser() {
        return new JSONSchemaParser();
    }
}
