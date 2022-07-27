<%--
  Created by IntelliJ IDEA.
  User: reach
  Date: 2022/7/27
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="signup" method="post">
    <fieldset>
        <legend>注册</legend>
        用户名<input name="username" type="text"/><br>
        密  码<input name="psw" type="password"/><br>
        <input type="submit" value="注册"/>
        <a href="login.jsp">返回登录</a>
    </fieldset>
</form>

