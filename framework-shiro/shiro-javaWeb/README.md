### JavaWeb + Shiro
####使用的框架
- Shiro1.9.0
- SpringMVC
- Spring5.3.17
- Mybatis

####主要测试功能
- Shiro 认证
- Shiro 授权


####项目搭建步骤
1. 创建JavaWeb项目，使用Maven作为构建工具
2. 修改项目结构
3. 导入Spring 和 SpringMvc 5.3.17依赖
4. 导入Shiro-core Shiro-spring 1.9.0依赖
5. 编写web.xml文件
   1. 配置SpringMvc 的DispatcherServlet 和 spring-mvc.xml
   2. 配置Spring application.xml
   3. 配置Spring ContextLoader的监听器
   4. 配置Shiro 的过滤器
6. 在application.xml中配置ShiroFilterFactoryBean


####测试步骤
1. 启动程序
2. 访问localhost:8080
3. 在页面测试认证，授权(基于角色，基于权限)