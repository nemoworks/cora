package cora.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.Properties;


public class CoraNodeAPITemplate {

    private static final Properties props = new Properties();

    static {
        props.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        props.setProperty(Velocity.RESOURCE_LOADER, "class");
        props.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    }

    private static final VelocityEngine velocityEngine = new VelocityEngine(props);

    public static JSONObject build(String schema) {
        int loc = schema.indexOf('{');
        String schemaType = schema.substring(5, loc);
        String template = "{\n" +
                "  \"schemaInfo\": {\n" +
                "    \"name\": \"${name}\",\n" +
                "    \"version\":\"${version}\",\n" +
                "    \"creator\": \"${creator}\"\n" +
                "  },\n" +
                "  \"apis\": {\n" +
                "    \"query\": \"${schema}:(id:String){...}\",\n" +
                "    \"create\": \"${createSchema}:(data){...}\",\n" +
                "    \"update\": \"${updateSchema}:(data){...}\",\n" +
                "    \"delete\": \"${deleteSchema}:(id:String){...}\"\n" +
                "  }\n" +
                "}";
        VelocityContext context = new VelocityContext();
        context.put("schema", schemaType.toLowerCase());
        context.put("createSchema", "create" + schemaType);
        context.put("name", schemaType);
        StringWriter writer = new StringWriter();
        velocityEngine.evaluate(context, writer, "", template);
        return JSON.parseObject(writer.toString(), JSONObject.class);
    }
}
