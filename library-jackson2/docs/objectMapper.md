#ObjectMapper
ObjectMapper是jackson-databind中的核心使用API。
该API提供了可从网络URL,文件，流等多种方式，将JSON 反序列化为 JavaBean。  
##底层概要
通过`tobean`包中的ToBeanSample中的案例，可以明确查看到ObjectMapper底层是调用了该对象的`无参构造器`和`setter`