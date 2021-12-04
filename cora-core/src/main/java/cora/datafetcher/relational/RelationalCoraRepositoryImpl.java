package cora.datafetcher.relational;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.CoraRepository;
import cora.parser.JsonAST;
import cora.parser.sql.RelationalQueryFilterParser;
import cora.util.VelocityTemplate;
import org.postgresql.util.PGobject;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class RelationalCoraRepositoryImpl implements CoraRepository<JSONObject> {

    private Connection connection;
    private final String collectionName;
    private final String QUERY_TEMPLATE = "SELECT * FROM ${collectionName} WHERE ${searchVar} = ?";
    private final String INSERT_TEMPLATE = "INSERT INTO ${collectionName}(_id, nodetype, data) VALUES(?, ?, ?)";

    public RelationalCoraRepositoryImpl(String collectionName) {
        this.collectionName = collectionName;

        Properties props = readProperties("cora-core/src/main/resources/database.properties");
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.passwd");
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JSONObject createNodeInstance(String nodeType, JSONObject data) {
        Map<String, String> map = new HashMap<>();
        map.put("collectionName", collectionName);
        String query = VelocityTemplate.build(INSERT_TEMPLATE, map);

        UUID uuid=UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", "");

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            PGobject uuidObject = new PGobject();
            uuidObject.setType("uuid");
            uuidObject.setValue(uuidString);

            PGobject dataObject = new PGobject();
            dataObject.setType("json");
            dataObject.setValue(data.toString());

            pst.setObject(1, uuidObject);
            pst.setString(2, nodeType);
            pst.setObject(3, dataObject);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        data.put("_id", uuidString);
        data.put("nodeType", nodeType);
        return data;
    }

    @Override
    public JSONObject deleteNodeInstanceById(String id) {
        return null;
    }

    @Override
    public JSONObject queryNodeInstanceById(String id, String nodeType) {
        Map<String,String> map = new HashMap<>();
        map.put("collectionName",collectionName);
        map.put("searchVar","_id");
        String query = VelocityTemplate.build(QUERY_TEMPLATE, map);

        JSONObject jsonObject = new JSONObject();
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            PGobject idPGobject = new PGobject();
            idPGobject.setType("uuid");
            idPGobject.setValue(id);
            pst.setObject(1, idPGobject);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                jsonObject.put("_id", rs.getString("_id"));
                jsonObject.put("nodeType", rs.getString("nodetype"));
                jsonObject.putAll((JSONObject) JSON.parse(rs.getString("data")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        return jsonObject;
    }

    @Override
    public List<JSONObject> queryNodeInstanceList(String nodeType) {
        Map<String,String> map = new HashMap<>();
        map.put("collectionName",collectionName);
        map.put("searchVar","nodetype");
        String query = VelocityTemplate.build(QUERY_TEMPLATE, map);

        List<JSONObject> jsonObjectList = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, nodeType);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("_id", rs.getString("_id"));
                jsonObject.put("nodeType", rs.getString("nodetype"));
                jsonObject.putAll((JSONObject) JSON.parse(rs.getString("data")));
                jsonObjectList.add(jsonObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonObjectList;
    }

    @Override
    public List<JSONObject> queryNodeInstanceList(List<String> instanceIds) {
        Map<String,String> map = new HashMap<>();
        map.put("collectionName",collectionName);
        map.put("searchVar","_id");
        String query = VelocityTemplate.build(QUERY_TEMPLATE, map);

        List<JSONObject> jsonObjectList = new ArrayList<>();
        instanceIds.forEach(instanceId -> {
            JSONObject jsonObject = new JSONObject();
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                PGobject idPGobject = new PGobject();
                idPGobject.setType("uuid");
                idPGobject.setValue(instanceId);
                pst.setObject(1, idPGobject);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    jsonObject.put("_id", rs.getString("_id"));
                    jsonObject.put("nodeType", rs.getString("nodetype"));
                    jsonObject.putAll((JSONObject) JSON.parse(rs.getString("data")));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            jsonObjectList.add(jsonObject);
        });
        return jsonObjectList;
    }

    @Override
    public List<JSONObject> queryNodeInstanceList(String nodeType, JSONObject filters) {
        JsonAST jsonAST = JsonAST.parseJSON(filters.toJSONString());
        RelationalQueryFilterParser relationalQueryFilterParser =
                new RelationalQueryFilterParser(new RelationalQueryFilterMapper());
        String filters_sql = relationalQueryFilterParser.parse(jsonAST);

        Map<String,String> map = new HashMap<>();
        map.put("collectionName",collectionName);
        map.put("searchVar","nodetype");
        String query = VelocityTemplate.build(QUERY_TEMPLATE, map) + filters_sql;

        List<JSONObject> jsonObjectList = new ArrayList<>();
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, nodeType);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("_id", rs.getString("_id"));
                jsonObject.put("nodeType", rs.getString("nodetype"));
                jsonObject.putAll((JSONObject) JSON.parse(rs.getString("data")));
                jsonObjectList.add(jsonObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonObjectList;
    }

    @Override
    public JSONObject updateNodeInstance(String nodeType, String id, JSONObject data) {
        return null;
    }

    public static Properties readProperties(String path) {
        Properties props = new Properties();
        Path myPath = Paths.get(path);
        try {
            BufferedReader bf = Files.newBufferedReader(myPath, StandardCharsets.UTF_8);
            props.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static void main(String args[]) {
        String jsonString = "{\"group\":\"adbc23\",\"month\":34}";
        List<String> instaceIds = Arrays.asList("96de44f5-e4b2-48ee-99aa-4fc9f86d2bd4",
                "5902f23f-4184-426c-91d5-991a697b6b05", "96de44f5-e4b2-48ee-99aa-4fc9f86d2bd4");
        JSONObject data = (JSONObject) JSON.parse(jsonString);

        RelationalCoraRepositoryImpl relationalCoraRepository = new RelationalCoraRepositoryImpl("jieshixin");
        relationalCoraRepository.createNodeInstance("Saler", data);
//        relationalCoraRepository.queryNodeInstanceById("a2d44113-6bef-448c-9f0d-8d6d8ef8efe5", "Bill");
//        relationalCoraRepository.queryNodeInstanceList("Bill");
//        relationalCoraRepository.queryNodeInstanceList(instaceIds);

    }
}
