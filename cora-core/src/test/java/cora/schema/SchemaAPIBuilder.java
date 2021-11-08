package cora.schema;

import java.io.StringWriter;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class SchemaAPIBuilder {

    private static final Properties props = new Properties();
    static {
        props.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        props.setProperty(Velocity.RESOURCE_LOADER, "class");
        props.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    }

    private static final VelocityEngine velocityEngine = new VelocityEngine(props);

    private static final Gson gson = new Gson();

    public static final JsonObject build(String schema) {
        int loc = schema.indexOf('{');
        String schemaType = schema.substring(5, loc - 1);
        String template = "{\n" + "  \"schemaInfo\": {\n" + "    \"name\": \"${name}\",\n"
                + "    \"version\":\"${version}\",\n" + "    \"creator\": \"${creator}\"\n" + "  },\n"
                + "  \"apis\": {\n" + "    \"query\": \"${schema}:(id:String){...}\",\n"
                + "    \"create\": \"${createSchema}:(data){...}\",\n"
                + "    \"update\": \"${updateSchema}:(data){...}\",\n"
                + "    \"delete\": \"${deleteSchema}:(id:String){...}\"\n" + "  }\n" + "}";
        VelocityContext context = new VelocityContext();
        context.put("schema", schemaType.toLowerCase());
        context.put("createSchema", "create" + schemaType);
        context.put("name", schemaType);
        StringWriter writer = new StringWriter();
        velocityEngine.evaluate(context, writer, "", template);
        return gson.fromJson(writer.toString(), JsonObject.class);
    }

    //
    // public static void main(String[] args) {
    // SchemaAPIBuilder.build("type User {\n" +
    // " id: String\n" +
    // " name: String\n" +
    // " age: Int\n" +
    // " nationality: String\n" +
    // " createdAt: String\n" +
    // " friends: [User]\n" +
    // " articles: [Article]\n" +
    // "}");
    // SchemaAPIBuilder.build("\n" +
    // "type Article {\n" +
    // " id: String\n" +
    // " title: String\n" +
    // " minutesRead: Int\n" +
    // "}");
    // }
}
