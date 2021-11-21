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
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.servlet.Servlet;
import java.util.List;

@Configuration
public class Config {

    @Autowired
    MongoTemplate mongoTemplate;


    @Value("${cora.node.dataCollection}")
    String collectionName;

    /**
     * mongodb storage repository impl
     * @return
     */
    @Bean
    public CoraRepository<JSONObject> mongodbCoraRepository() {
        return new MongodbCoraRepositoryImpl(mongoTemplate, collectionName) {
        };
    }

    /**
     * storage object
     * @return
     */
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

    @Bean
    public Servlet restServlet() {
        return new RestApiServlet(coraBuilder());
    }

    @Bean
    public Servlet graphqlServlet() {
        return new CoraQLServlet(coraBuilder());
    }

    @Bean
    public Server getServer() throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[] {connector});
        ServletHandler servletHandler = new ServletHandler();
        ServletHolder servletHolder = new ServletHolder();
        servletHolder.setServlet(restServlet());
        ServletHolder servletHolder1 = new ServletHolder();
        servletHolder1.setServlet(graphqlServlet());

        servletHandler.addServletWithMapping(servletHolder,"/api/*");
        //servletHandler.addServletWithMapping(RestApiServlet.class,"/api/*");
        servletHandler.addServletWithMapping(servletHolder1,"/graphql");
        server.setHandler(servletHandler);
        server.start();
        return server;
    }
}
