package cora.app.web;

import com.alibaba.fastjson.JSON;
import cora.app.CoraBuilder;
import cora.graph.CoraGraph;
import cora.graph.IngressType;
import cora.util.VelocityTemplate;
import graphql.ExecutionResult;
import graphql.GraphQL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RestApiServlet extends HttpServlet {

    private final GraphQL graphQL;

    public RestApiServlet(CoraBuilder coraBuilder) {
        this.graphQL = coraBuilder.createGraphQL();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        String id = request.getParameter("id");

        String a = CoraGraph.CoraIngressMap.get(type).getIngressData(IngressType.QUERY);
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("resp","_id");
        String schema = VelocityTemplate.build(a, map);
        ExecutionResult result = graphQL.execute(schema);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(result.getData()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("{ \"status\": \"ok\"}");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}