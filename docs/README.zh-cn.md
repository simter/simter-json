# [simter-json](https://github.com/simter/simter-json) [[English]]

[JSR-353] \(Java API for JSON Processing\) 的扩展工具包。

[JSR-353] 中的 JsonObject 和 JsonArray 被设计为不可变对象，即实例创建后是不能进行任何修改的。
但有时我们需要修改或者扩展一个已经实例化的 JsonObject 或 JsonArray 对象，这个扩展工具就是干这个事的。

## 安装

```xml
<dependency>
  <groupId>tech.simter</groupId>
  <artifactId>simter-json</artifactId>
  <version>1.0.0</version>
</dependency>
```

## 要求

- Java 8+
- 至少一个 [JSR-353] 实现，如 [Genson], [Jackson], [Glassfish]

## 使用：JSR-353 基础代码

### 创建一个标准的 JsonObject 实例

```java
JsonObject jsonObject = Json.createObjectBuilder()
  .add("str", "a")
  .add("num", 1)
  .add("bool", false)
  .addNull("k")
  .build();
```
### 创建一个标准的 JsonArray 实例

```java
JsonArray jsonArray = Json.createArrayBuilder()
  .add(10)
  .add(1.1)
  .add(true)
  .addNull()
  .build();
```

## 使用：本扩展工具的代码

### 扩展一个 JsonObject 实例

```java
JsonObject extended = JsonUtils.toBuilder(jsonObject)
  .add("newKey", "newValue")
  .build();
```

### 扩展一个 JsonArray 实例

```java
JsonArray extended = JsonUtils.toBuilder(jsonArray)
  .add("newItem")
  .build();
```

### 合并多个 JsonObject 或 JsonObjectBuilder 实例

```java
JsonObject merged = JsonUtils.merge(jsonObject1, jsonObject2, ...).build();
// or
JsonObjectBuilder merged = JsonUtils.merge(jsonObjectBuilder1, jsonObjectBuilder2, ...);
```

### 合并多个 JsonArray 或 JsonArrayBuilder 实例

```java
JsonArray merged = JsonUtils.merge(jsonArray1, jsonArray2, ...).build();
// or
JsonArrayBuilder merged = JsonUtils.merge(jsonArrayBuilder1, jsonArrayBuilder2, ...);
```

## 构建

```bash
mvn clean package
```

## 发布

请先查看 [simter-parent] 的发布配置说明。

### 发布到局域网 Nexus 仓库

```bash
mvn clean deploy -P lan
```

### 发布到 Sonatype 仓库

```bash
mvn clean deploy -P sonatype
```

发布成功后登陆到 <https://oss.sonatype.org>，在 `Staging Repositories` 找到这个包，然后将其 close 和 release。
过几个小时后，就会自动同步到 [Maven 中心仓库](http://repo1.maven.org/maven2/tech/simter/simter-json) 了。

### 发布到 Bintray 仓库

```bash
mvn clean deploy -P bintray
```

发布之前要先在 Bintray 创建 package `https://bintray.com/simter/maven/tech.simter:simter-json`。
发布到的地址为 `https://api.bintray.com/maven/simter/maven/tech.simter:simter-json/;publish=1`。
发布成功后可以到 <https://jcenter.bintray.com/tech/simter/simter-json> 检查一下结果。


[JSR-353]: https://jcp.org/en/jsr/detail?id=353
[Genson]: http://owlike.github.io/genson
[Jackson]: https://github.com/FasterXML/jackson-datatype-jsr353
[Glassfish]: https://jsonp.java.net/download.html
[oss.sonatype.org]: https://oss.sonatype.org
[simter-parent]: https://github.com/simter/simter-parent/blob/master/docs/README.zh-cn.md
[English]: https://github.com/simter/simter-json/blob/master/README.md