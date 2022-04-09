# JackSon Library
## 什么是 JackSon?
JackSon是一个 Java JSON库 或者可以称为一个 JSON解析器。  
Jackson 所依赖的 jar 包较少 ，简单易用。  
与Jackson 类似的解析器还有 FastJson 和 GSon.  

Jackson 1.x版本名为 org.codehaus.jackson
Jackson 2.x版本更名为 com.fasterxml.jackson 并且不向下兼容。可独立使用。  

Jackson的核心模块(com.fasterxml.jackson.core)由三部分组成：  
    1. jackson-core
    2. jackson-annotations
    3. jackson-databind 依赖 1和2

`jackson-core`:提供基于"流模式"解析的相关 API，它包括 JsonPaser 和 JsonGenerator。 Jackson 内部实现正是经过高性能的流模式 API 的 
JsonGenerator 和 JsonParser 来生成和解析 json。  

`jackson-annotations`: 注解包，提供标准注解功能；  

`jackson-databind`:数据绑定包， 提供基于"对象绑定" 解析的相关 API （ ObjectMapper ） 和"树模型" 解析的相关 API （JsonNode）；  

## Maven依赖
```xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.9.6</version>
</dependency>
```
由于jackson-databind 依赖jackson-core 和 jackson-annotations，因此只导入jackson-databind就行了.  


## 常用API  
jackson中常用的API是 jackson-databind 中的 ObjectMapper
- ObjectMapper能够从字符串，流，文件 中解析JSON，并建立表示已解析的JSON的Java对象。将JSON 解析为 Java中的Bean 也称为从JSON反序列化为
java对象。  
- ObjectMapper也能够从Java对象建立JSON，从Java对象生成JSON 也称为从 Java对象序列化为JSON。  
- ObjectMapper能够将JSON解析为自定义的类的对象，也能够解析到JSON树模型对象。