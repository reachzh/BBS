<%--
  Created by IntelliJ IDEA.
  User: reach
  Date: 2022/7/27
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form action="login" method="post">
    <fieldset>
        <legend>登录</legend>
        用户名<input name="username" type="text"/><br>
        密  码<input name="psw" type="password"/><br>
        <input type="submit" value="登录"/>
        <a href="signup.jsp">注册</a>

    </fieldset>
</form>

</body>
</html>

