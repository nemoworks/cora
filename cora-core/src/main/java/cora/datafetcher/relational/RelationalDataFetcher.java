package cora.datafetcher.relational;

import com.alibaba.fastjson.JSONObject;
import cora.graph.CoraGraph;
import cora.util.VelocityTemplate;
import graphql.language.Type;
import graphql.language.TypeName;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLObjectType;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class RelationalDataFetcher implements DataFetcher<JSONObject> {

    private Statement statement;

    public RelationalDataFetcher(Connection connection){
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private static String QUERY_TEMPLATE = "SELECT * FROM ${graphNode} WHERE id = ${id};";

    @Override
    public JSONObject get(DataFetchingEnvironment dataFetchingEnvironment) {
        String fieldType = ((GraphQLObjectType) dataFetchingEnvironment.getFieldType()).getName();

        String id = dataFetchingEnvironment.getArgument("id");

        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("graphNode",fieldType.toUpperCase());

        String s = VelocityTemplate.build(QUERY_TEMPLATE, map);

        ResultSet rs = null;
        Map<String, Type> typeMap = CoraGraph.nodeMap.get(fieldType).getTypeMap();
        JSONObject jsonObject = new JSONObject();
        try {
            rs = statement.executeQuery(s);
            while ( rs.next() ) {
                for(String key:typeMap.keySet()){
                    if(((TypeName)typeMap.get(key)).getName().equals("Int")){
                        int anInt = rs.getInt(key);
                        jsonObject.put(key,anInt);
                    }else if(((TypeName)typeMap.get(key)).getName().equals("String")){
                        jsonObject.put(key,rs.getString(key));
                    }
                }
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return jsonObject;
       // return this.getDocumentByAggregation(String.valueOf(id));
    }

    private JSONObject getDocumentByAggregation(String id){
        return null;
    }


    public static void main(String args[]) {
        Connection c = null;
        try {
             c= DriverManager
                    .getConnection("jdbc:postgresql://127.0.0.1:5432/postgres",
                            "postgres", "123456");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RelationalDataFetcher relationalDataFetcher = new RelationalDataFetcher(c);
        relationalDataFetcher.get(null);
    }
//        Connection c = null;
//        Statement stmt = null;
//        try {
//             c= DriverManager
//                    .getConnection("jdbc:postgresql://127.0.0.1:5432/postgres",
//                            "postgres", "123456");
//            System.out.println("Opened database successfully");
//            stmt = c.createStatement();
//            String sql = "CREATE TABLE COMPANY " +
//                    "(ID INT PRIMARY KEY     NOT NULL," +
//                    " NAME           TEXT    NOT NULL, " +
//                    " AGE            INT     NOT NULL, " +
//                    " ADDRESS        CHAR(50), " +
//                    " SALARY         REAL)";
//            stmt.executeUpdate(sql);
//            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
//                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
//            stmt.executeUpdate(sql);
//            ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY WHERE id = 4;" );
//            while ( rs.next() ) {
//                int id = rs.getInt("id");
//                String  name = rs.getString("name");
//                int age  = rs.getInt("age");
//                String  address = rs.getString("address");
//                float salary = rs.getFloat("salary");
//                System.out.println( "ID = " + id );
//                System.out.println( "NAME = " + name );
//                System.out.println( "AGE = " + age );
//                System.out.println( "ADDRESS = " + address );
//                System.out.println( "SALARY = " + salary );
//                System.out.println();
//            }
//            stmt.close();
//            c.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.err.println(e.getClass().getName()+": "+e.getMessage());
//            System.exit(0);
//        }
//        System.out.println("Table created successfully");

    }
