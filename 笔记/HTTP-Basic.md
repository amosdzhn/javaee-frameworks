# HTTP-Basic
HTTP-Basic是从HTTP1.0定义的认证方式


## 如何认证?
1. 在HTTP请求头的 Authorization 头中 传值 `Basic + Base64("用户名=密码")`


## 安全系数？
用户名 和 密码 直接使用Base64编码 放在Authorization头中，并未加密，很容易被抓包工具看到明文的账号和密码。  

HTTP-Basic只有登录操作，并无注销操作  

安全级别较低，使用较少
