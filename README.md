# [simter-json](https://github.com/simter/simter-json) [[中文]]

Json extension tools for [JSR-353] (Java API for JSON Processing).

JsonObject and JsonArray are design to be a immutable object. Once created, it can not be changed. 
But sometimes we need to modify or extend it. This is the target of this extension tools.

## Installation

```xml
<dependency>
  <groupId>tech.simter</groupId>
  <artifactId>simter-json</artifactId>
  <version>0.1.0</version>
</dependency>
```

## Requirement

- Java 8+
- At lease one [JSR-353] provider (Java API for JSON Processing)  
  e.g. [Genson], [Jackson], [Glassfish]

## Usage: JSR-353 base code

### Create a standard JsonObject

```java
JsonObject jsonObject = Json.createObjectBuilder()
  .add("str", "a")
  .add("num", 1)
  .add("bool", false)
  .addNull("k")
  .build();
```
### Create a standard JsonArray

```java
JsonArray jsonArray = Json.createArrayBuilder()
  .add(10)
  .add(1.1)
  .add(true)
  .addNull()
  .build();
```

## Usage: This extensions code

### Extend a JsonObject

```java
JsonObject extended = JsonUtils.toBuilder(jsonObject)
  .add("newKey", "newValue")
  .build();
```

### Extend a JsonArray

```java
JsonArray extended = JsonUtils.toBuilder(jsonArray)
  .add("newItem")
  .build();
```

### Merge multiple JsonObject or JsonObjectBuilder

```java
JsonObject merged = JsonUtils.merge(jsonObject1, jsonObject2, ...).build();
// or
JsonObjectBuilder merged = JsonUtils.merge(jsonObjectBuilder1, jsonObjectBuilder2, ...);
```

### Merge multiple JsonArray or JsonArrayBuilder

```java
JsonArray merged = JsonUtils.merge(jsonArray1, jsonArray2, ...).build();
// or
JsonArrayBuilder merged = JsonUtils.merge(jsonArrayBuilder1, jsonArrayBuilder2, ...);
```

## Build

```bash
mvn clean package
```

## Deploy

First take a look at [simter-parent] deploy config.

### Deploy to LAN Nexus Repository

```bash
mvn clean deploy -Plan
```

### Deploy to Maven Central Repository through [oss.sonatype.org]

```bash
mvn clean deploy -Poss
```


[Java API for JSON Processing]: https://jcp.org/en/jsr/detail?id=353
[JSR-353]: https://jcp.org/en/jsr/detail?id=353
[Genson]: http://owlike.github.io/genson
[Jackson]: https://github.com/FasterXML/jackson-datatype-jsr353
[Glassfish]: https://jsonp.java.net/download.html
[oss.sonatype.org]: https://oss.sonatype.org
[中文]: https://github.com/simter/simter-json/blob/master/docs/README.zh-cn.md