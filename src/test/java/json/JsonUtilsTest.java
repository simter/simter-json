package json;

import org.junit.Test;
import tech.simter.json.JsonUtils;

import javax.json.*;

import static org.junit.Assert.assertEquals;

/**
 * @author RJ 2016-12-22
 */
public class JsonUtilsTest {
  @Test
  public void toJsonObjectBuilder() {
    // empty
    assertEquals("{}", JsonUtils.toBuilder((JsonObject) null).build().toString());

    // convert
    JsonObject json = Json.createObjectBuilder()
      .add("str", "a")
      .add("num", 1)
      .add("bool", false)
      .addNull("k")
      .build();
    JsonObjectBuilder copy = JsonUtils.toBuilder(json);
    assertEquals(json.toString(), copy.build().toString());
  }

  @Test
  public void toJsonArrayBuilder() {
    // empty
    assertEquals("[]", JsonUtils.toBuilder((JsonArray) null).build().toString());

    // convert
    JsonArray json = Json.createArrayBuilder()
      .add(Json.createObjectBuilder().add("k", "v"))
      .add(JsonValue.TRUE)
      .build();
    JsonArrayBuilder copy = JsonUtils.toBuilder(json);
    assertEquals(json, copy.build());
    assertEquals(json.toString(), copy.build().toString());
  }

  @Test
  public void mergeJsonObjects() {
    // empty
    assertEquals("{}", JsonUtils.merge((JsonObject) null).build().toString());

    // merge
    JsonObject json = Json.createObjectBuilder().add("k1", "v1").add("k2", "v2").build();
    JsonObject json1 = Json.createObjectBuilder().add("k1", "v1").build();
    JsonObject json2 = Json.createObjectBuilder().add("k2", "v2").build();
    JsonObjectBuilder merge = JsonUtils.merge(json1, json2);
    assertEquals(json.toString(), merge.build().toString());

    // merge with override
    json = Json.createObjectBuilder().add("k1", "v3").add("k2", "v2").build();
    json1 = Json.createObjectBuilder().add("k1", "v1").build();
    json2 = Json.createObjectBuilder().add("k2", "v2").add("k1", "v3").build();
    merge = JsonUtils.merge(json1, json2);
    assertEquals(json.toString(), merge.build().toString());

    // merge with null argument
    json = Json.createObjectBuilder().add("k1", "v1").add("k2", "v2").build();
    json1 = Json.createObjectBuilder().add("k1", "v1").build();
    json2 = Json.createObjectBuilder().add("k2", "v2").build();
    merge = JsonUtils.merge(json1, null, json2);
    assertEquals(json.toString(), merge.build().toString());
  }

  @Test
  public void mergeJsonObjectBuilders() {
    // empty
    assertEquals("{}", JsonUtils.merge((JsonObjectBuilder) null).build().toString());

    // merge
    JsonObjectBuilder builder = Json.createObjectBuilder().add("k1", "v1").add("k2", "v2");
    JsonObjectBuilder builder1 = Json.createObjectBuilder().add("k1", "v1");
    JsonObjectBuilder builder2 = Json.createObjectBuilder().add("k2", "v2");
    JsonObjectBuilder merge = JsonUtils.merge(builder1, builder2);
    assertEquals(builder.build().toString(), merge.build().toString());

    // merge with override
    builder = Json.createObjectBuilder().add("k1", "v3").add("k2", "v2");
    builder1 = Json.createObjectBuilder().add("k1", "v1");
    builder2 = Json.createObjectBuilder().add("k2", "v2").add("k1", "v3");
    merge = JsonUtils.merge(builder1, builder2);
    assertEquals(builder.build().toString(), merge.build().toString());

    // merge with null argument
    builder = Json.createObjectBuilder().add("k1", "v1").add("k2", "v2");
    builder1 = Json.createObjectBuilder().add("k1", "v1");
    builder2 = Json.createObjectBuilder().add("k2", "v2");
    merge = JsonUtils.merge(builder1, null, builder2);
    assertEquals(builder.build().toString(), merge.build().toString());
  }

  @Test
  public void mergeJsonArrays() {
    // empty
    assertEquals("[]", JsonUtils.merge((JsonArray) null).build().toString());

    // merge
    JsonArray json = Json.createArrayBuilder().add(JsonValue.FALSE).add(JsonValue.TRUE).build();
    JsonArray json1 = Json.createArrayBuilder().add(JsonValue.FALSE).build();
    JsonArray json2 = Json.createArrayBuilder().add(JsonValue.TRUE).build();
    JsonArrayBuilder merge = JsonUtils.merge(json1, json2);
    assertEquals(json.toString(), merge.build().toString());

    // merge with null argument
    json = Json.createArrayBuilder().add(JsonValue.FALSE).add(JsonValue.TRUE).build();
    json1 = Json.createArrayBuilder().add(JsonValue.FALSE).build();
    json2 = Json.createArrayBuilder().add(JsonValue.TRUE).build();
    merge = JsonUtils.merge(json1, null, json2);
    assertEquals(json.toString(), merge.build().toString());
  }

  @Test
  public void mergeJsonArrayBuilders() {
    // empty
    assertEquals("[]", JsonUtils.merge((JsonArrayBuilder) null).build().toString());

    // merge
    JsonArrayBuilder builder = Json.createArrayBuilder().add(JsonValue.FALSE).add(JsonValue.TRUE);
    JsonArrayBuilder builder1 = Json.createArrayBuilder().add(JsonValue.FALSE);
    JsonArrayBuilder json2 = Json.createArrayBuilder().add(JsonValue.TRUE);
    JsonArrayBuilder merge = JsonUtils.merge(builder1, json2);
    assertEquals(builder.build().toString(), merge.build().toString());

    // merge with null argument
    builder = Json.createArrayBuilder().add(JsonValue.FALSE).add(JsonValue.TRUE);
    builder1 = Json.createArrayBuilder().add(JsonValue.FALSE);
    json2 = Json.createArrayBuilder().add(JsonValue.TRUE);
    merge = JsonUtils.merge(builder1, null, json2);
    assertEquals(builder.build().toString(), merge.build().toString());
  }
}
