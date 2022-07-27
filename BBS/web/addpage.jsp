<%--
  Created by IntelliJ IDEA.
  User: reach
  Date: 2022/7/27
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = (Integer) request.getSession().getAttribute("UserID");
%>
<html>
<head>
    <title>发帖</title>
</head>
<body>

<form action="addArticle" method="post">
    <fieldset>
        <legend>发帖</legend>
        标题<input name="title" type="text"/><br>
        内容<textarea name="context"></textarea><br>
        <input type="submit" value="提交"/>
        <a href="personal">返回个人页面</a>
    </fieldset>
</form>
</body>
</html>
