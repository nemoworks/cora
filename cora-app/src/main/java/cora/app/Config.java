package cora.app;

import com.alibaba.fastjson.JSONObject;
import cora.CoraBuilder;
import cora.groovy.GroovyScriptService;
import cora.groovy.GroovyScriptTemplate;
import cora.groovy.impl.CustomCoraRepoFactory;
import cora.web.CoraQLServlet;
import cora.web.K8sServlet;
import cora.web.RestApiServlet;
import cora.datafetcher.CoraRepository;
import cora.datafetcher.CoraStorage;
import cora.datafetcher.CoraStorageImp;
import cora.datafetcher.mongodb.MongodbCoraRepositoryImpl;
import cora.parser.dsl.CoraParser;
import cora.parser.dsl.JsonSchemaParser;
import cora.schema.CoraRuntimeWiring;
import cora.schema.CoraTypeRegistry;
import graphql.schema.DataFetcher;
import groovy.lang.GroovyClassLoader;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
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
        return new MongodbCoraRepositoryImpl(mongoTemplate, collectionName);
//        return new RelationalCoraRepositoryImpl(collectionName);
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
    public GroovyScriptService groovyScriptService(){
        GroovyScriptTemplate groovyScriptTemplate = new GroovyScriptTemplate();
        return new CustomCoraRepoFactory(groovyScriptTemplate,new GroovyClassLoader());
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
        return new CoraBuilder(coraRuntimeWiring(),coraTypeRegistry(),coraParser(),mongoTemplate, groovyScriptService());
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
    public Servlet k8sServlet(){
        return new K8sServlet();
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

        ServletHolder servletHolder2 = new ServletHolder();
        servletHolder2.setServlet(k8sServlet());

        servletHandler.addServletWithMapping(servletHolder,"/api/v1/*");
        servletHandler.addServletWithMapping(servletHolder1,"/graphql");
        servletHandler.addServletWithMapping(servletHolder2,"/api/healthz");

        ResourceHandler resource_handler = new ResourceHandler();
// Configure the ResourceHandler. Setting the resource base indicates where the files should be served out of.
// In this example it is the current directory but it can be configured to anything that the jvm has access to.
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{"index.html" });
        resource_handler.setResourceBase("./target/classes/webapp");

        HandlerList handlers = new HandlerList();
        handlers.addHandler(resource_handler);
        handlers.addHandler(servletHandler);

        server.setHandler(handlers);
        server.start();
        return server;
    }
}
