package tech.simter.json;

import javax.json.*;

/**
 * Json extension tools for JSR-353
 *
 * @author RJ 2016-12-22
 */
public class JsonUtils {
  /**
   * Convert JsonObject to JsonObjectBuilder
   *
   * @param jsonObject The source jsonObject to be converted
   * @return JsonObjectBuilder Return a empty builder never null even if argument is null or empty
   */
  public static JsonObjectBuilder toBuilder(JsonObject jsonObject) {
    JsonObjectBuilder builder = Json.createObjectBuilder();
    if (jsonObject == null) return builder;
    jsonObject.forEach(builder::add);
    return builder;
  }

  /**
   * Convert JsonArray to JsonArrayBuilder
   *
   * @param jsonArray The source JsonArray to be converted
   * @return JsonArrayBuilder Return a empty builder never null even if argument is null or empty
   */
  public static JsonArrayBuilder toBuilder(JsonArray jsonArray) {
    JsonArrayBuilder builder = Json.createArrayBuilder();
    if (jsonArray == null) return builder;
    jsonArray.forEach(builder::add);
    return builder;
  }

  /**
   * Merge multiple JsonObject to one JsonObjectBuilder
   * <p>If the next item has the same key with before item, it will be override by de next item.</p>
   *
   * @param jsonObjects The JsonObject array to be merged
   * @return JsonObjectBuilder Return a empty builder never null even if arguments is null or empty
   */
  public static JsonObjectBuilder merge(JsonObject... jsonObjects) {
    JsonObjectBuilder builder = Json.createObjectBuilder();
    for (JsonObject jsonObject : jsonObjects) if (jsonObject != null) jsonObject.forEach(builder::add);
    return builder;
  }

  /**
   * Merge multiple JsonObjectBuilder to one JsonObjectBuilder
   * <p>If the next item has the same key with before item, it will be override by de next item.</p>
   *
   * @param jsonObjectBuilders The JsonObjectBuilder array to be merged
   * @return JsonObjectBuilder Return a empty builder never null even if arguments is null or empty
   */
  public static JsonObjectBuilder merge(JsonObjectBuilder... jsonObjectBuilders) {
    JsonObjectBuilder builder = Json.createObjectBuilder();
    for (JsonObjectBuilder b : jsonObjectBuilders) if (b != null) b.build().forEach(builder::add);
    return builder;
  }

  /**
   * Merge multiple JsonArray to one JsonArrayBuilder
   *
   * @param jsonArrays The JsonArray array to be merged
   * @return JsonArrayBuilder Return a empty builder never null even if arguments is null or empty
   */
  public static JsonArrayBuilder merge(JsonArray... jsonArrays) {
    JsonArrayBuilder builder = Json.createArrayBuilder();
    for (JsonArray jsonArray : jsonArrays) if (jsonArray != null) jsonArray.forEach(builder::add);
    return builder;
  }

  /**
   * Merge multiple JsonArrayBuilder to one JsonArrayBuilder
   *
   * @param jsonArrayBuilders The JsonArrayBuilder array to be merged
   * @return JsonArrayBuilder Return a empty builder never null even if arguments is null or empty
   */
  public static JsonArrayBuilder merge(JsonArrayBuilder... jsonArrayBuilders) {
    JsonArrayBuilder builder = Json.createArrayBuilder();
    for (JsonArrayBuilder b : jsonArrayBuilders) if (b != null) b.build().forEach(builder::add);
    return builder;
  }
}
