package cora.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cora.CoraBuilder;
import cora.util.ServletUtil;
import graphql.ExecutionResult;
import graphql.GraphQL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//graphql api impl
public class CoraQLServlet extends HttpServlet {

    private GraphQL graphQL;

    private final CoraBuilder coraBuilder;

    public CoraQLServlet(CoraBuilder coraBuilder) {
        this.coraBuilder = coraBuilder;
        this.graphQL = coraBuilder.createGraphQL();
    }
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        String schema = ServletUtil.getRequestBody(req);
        if(schema.contains("query_schemas")){
            JSONObject schemas = coraBuilder.getSchemas();
            response.getWriter().write(schemas.toJSONString());
        }else if(schema.contains("create_api")){
            this.graphQL = coraBuilder.addCustomIngress(schema);
            response.getWriter().write("add new ingress.");
        }else{
            ExecutionResult result = graphQL.execute(schema);
            if (result.getErrors().isEmpty())
                response.getWriter().write(JSON.toJSONString(result.getData()));
            else response.getWriter().write(JSON.toJSONString(result.getErrors()));
        }


    }
}