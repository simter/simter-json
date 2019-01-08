# [simter-json](https://github.com/simter/simter-json) [[中文]]

Json extension tools for [JSR-353] \(Java API for JSON Processing\).

JsonObject and JsonArray are design to be a immutable object. Once created, it can not be changed. 
But sometimes we need to modify or extend it. This is the target of this extension tools.

## Installation

```xml
<dependency>
  <groupId>tech.simter</groupId>
  <artifactId>simter-json</artifactId>
  <version>1.0.0</version>
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
mvn clean deploy -P lan
```

### Deploy to Sonatype Repository

```bash
mvn clean deploy -P sonatype
```

After deployed, login into <https://oss.sonatype.org>. Through `Staging Repositories`, search this package, 
then close and release it. After couple hours, it will be synced 
to [Maven Central Repository](http://repo1.maven.org/maven2/tech/simter/simter-json).

### Deploy to Bintray Repository

```bash
mvn clean deploy -P bintray
```

Will deploy to `https://api.bintray.com/maven/simter/maven/tech.simter:simter-json/;publish=1`.
So first create a package `https://bintray.com/simter/maven/tech.simter:simter-json` on Bintray.
After deployed, check it from <https://jcenter.bintray.com/tech/simter/simter-json>.

[Java API for JSON Processing]: https://jcp.org/en/jsr/detail?id=353
[JSR-353]: https://jcp.org/en/jsr/detail?id=353
[Genson]: http://owlike.github.io/genson
[Jackson]: https://github.com/FasterXML/jackson-datatype-jsr353
[Glassfish]: https://jsonp.java.net/download.html
[oss.sonatype.org]: https://oss.sonatype.org
[simter-parent]: https://github.com/simter/simter-parent
[中文]: https://github.com/simter/simter-json/blob/master/docs/README.zh-cn.md