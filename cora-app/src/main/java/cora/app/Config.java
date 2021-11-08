package cora.app;

import cora.datafetcher.mongodb.MongodbNodeInstanceConstructor;
import cora.datafetcher.mongodb.MongodbNodeInstanceFetcher;
import cora.datafetcher.mongodb.MongodbNodeInstanceListFetcher;
import cora.parser.CoraParser;
import cora.parser.SDLParser;
import cora.schema.CoraRuntimeWiring;
import cora.schema.CoraTypeRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class Config {

    @Autowired
    MongoTemplate mongoTemplate;

    @Bean
    public MongodbNodeInstanceConstructor mongodbNodeInstanceConstructor(){
        return new MongodbNodeInstanceConstructor(mongoTemplate);
    }

    @Bean
    public MongodbNodeInstanceFetcher mongodbNodeInstanceFetcher(){
        return new MongodbNodeInstanceFetcher(mongoTemplate);
    }

    @Bean
    public MongodbNodeInstanceListFetcher mongodbNodeInstanceListFetcher(){
        return new MongodbNodeInstanceListFetcher(mongoTemplate);
    }

    @Bean
    public CoraRuntimeWiring coraRuntimeWiring(){
        return new CoraRuntimeWiring(mongodbNodeInstanceFetcher()
                ,mongodbNodeInstanceListFetcher()
                ,mongodbNodeInstanceConstructor());
    }

    @Bean
    public CoraTypeRegistry coraTypeRegistry(){
        return new CoraTypeRegistry();
    }

    @Bean
    public CoraParser coraParser(){
        return new SDLParser();
    }
}
