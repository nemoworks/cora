package cora.app.web;

import cora.app.CoraBuilder;
import cora.graph.CoraGraph;
import cora.graph.IngressType;
import cora.util.VelocityTemplate;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RestApiServlet extends HttpServlet {

//    private final GraphQL graphQL;
//
//    public RestApiServlet(CoraBuilder coraBuilder) {
//        this.graphQL = coraBuilder.createGraphQL();
//    }

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
        String build = VelocityTemplate.build(a, map);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("{ \"status\": \"ok\"}");
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
