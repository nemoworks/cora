package cora.app;

import com.alibaba.fastjson.JSONObject;
import cora.app.web.CoraQLServlet;
import cora.app.web.RestApiServlet;
import cora.datafetcher.CoraRepository;
import cora.datafetcher.CoraStorage;
import cora.datafetcher.CoraStorageImp;
import cora.datafetcher.mongodb.MongodbCoraRepositoryImpl;
import cora.parser.CoraParser;
import cora.parser.JsonSchemaParser;
import cora.schema.CoraRuntimeWiring;
import cora.schema.CoraTypeRegistry;
import graphql.schema.DataFetcher;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@Configuration
public class Config {

    @Autowired
    MongoTemplate mongoTemplate;


    @Value("${cora.node.dataCollection}")
    String collectionName;

    @Bean
    public CoraRepository<JSONObject> mongodbCoraRepository() {
        return new MongodbCoraRepositoryImpl(mongoTemplate, collectionName) {
        };
    }

    @Bean
    public CoraStorage<JSONObject> coraMongodb() {
        return new CoraStorageImp(mongodbCoraRepository());
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
        return new JsonSchemaParser();
    }

    @Bean
    public CoraBuilder coraBuilder(){
        return new CoraBuilder(coraRuntimeWiring(),coraTypeRegistry(),coraParser(),mongoTemplate);
    }

//    @Bean
//    public ServletRegistrationBean exampleServletBean() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(
//                new RestApiServlet(coraBuilder()), "/api/*");
//        bean.setLoadOnStartup(1);
//        return bean;
//    }

    @Bean
    public Server getServer() throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[] {connector});
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(RestApiServlet.class,"/api/*");
        servletHandler.addServletWithMapping(CoraQLServlet.class,"/coraql");
        server.setHandler(servletHandler);
        server.start();
        return server;
    }
}
