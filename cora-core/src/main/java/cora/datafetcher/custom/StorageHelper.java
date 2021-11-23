package cora.datafetcher.custom;

import org.springframework.data.mongodb.core.MongoTemplate;

import java.sql.Connection;

public class StorageHelper {
    private MongoTemplate mongoTemplate;

    private Connection connection;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
