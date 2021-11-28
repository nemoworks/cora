package cora.datafetcher.relational;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cora.datafetcher.CoraRepository;
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
    private final String QUERY_TEMPLATE = "SELECT * FROM ${collectionName} WHERE ${searchVar} = ?;";
    private final String INSERT_TEMPLATE = "INSERT INTO ${collectionName}(nodetype, data) VALUES(?, ?)";

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

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            PGobject pGobject = new PGobject();
            pGobject.setType("json");
            pGobject.setValue(data.toString());
            pst.setString(1, nodeType);
            pst.setObject(2, pGobject);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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
                jsonObject.put("id", rs.getString("_id"));
                jsonObject.put("nodeType", rs.getString("nodetype"));
                jsonObject.putAll((JSONObject) JSON.parse(rs.getString("data")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                jsonObject.put("id", rs.getString("_id"));
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
                    jsonObject.put("id", rs.getString("_id"));
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
        return null;
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
        String jsonString = "{\"invoiceDate\":\"abc1\",\"invoiceCompany\":\"中创\"}";
        List<String> instaceIds = Arrays.asList("96de44f5-e4b2-48ee-99aa-4fc9f86d2bd4",
                "5902f23f-4184-426c-91d5-991a697b6b05", "96de44f5-e4b2-48ee-99aa-4fc9f86d2bd4");
        JSONObject data = (JSONObject) JSON.parse(jsonString);

        RelationalCoraRepositoryImpl relationalCoraRepository = new RelationalCoraRepositoryImpl("jieshixing");
        relationalCoraRepository.createNodeInstance("Bill", data);
//        relationalCoraRepository.queryNodeInstanceById("96de44f5-e4b2-48ee-99aa-4fc9f86d2bd4", "Bill");
//        relationalCoraRepository.queryNodeInstanceList("Bill");
//        relationalCoraRepository.queryNodeInstanceList(instaceIds);

    }
}
