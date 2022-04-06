<%--
  Created by IntelliJ IDEA.
  User: zhn
  Date: 2022/4/4
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1>hello shiro</h1>

<h3>测试Authentication</h3>
<a href="/index">index页面(需要认证authc)</a>

<h3>测试Authorization</h3>
<a href="/test_role">test_role(必须有admin角色)</a><br/>
<a href="/test_perm">test_permission(必须具有user:add权限)</a>
</body>
</html>
