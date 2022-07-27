<%@ page import="com.Bean.Article" %>
<%@ page import="com.DAO.ArticleDAO" %><%--
  Created by IntelliJ IDEA.
  User: reach
  Date: 2022/7/27
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Article article = (Article) request.getAttribute("article");
%>
<html>
<head>
    <title>编辑</title>
</head>
<body>
<form action="editArticle" method="post">
    <fieldset>
        <legend>发帖</legend>
        标题<input name="title" type="text" value="<%out.println(article.getTitle());%>"><br>
        内容<textarea name="context"><%out.println(article.getContext());%></textarea><br>
        <input type="submit" value="提交"/>
        <a href="personal">返回个人页面</a>
    </fieldset>
</form>
</body>
</html>
