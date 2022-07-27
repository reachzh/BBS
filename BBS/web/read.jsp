<%@ page import="com.Bean.Article" %>
<%@ page import="com.DAO.UserDAO" %>
<%@ page import="com.Bean.Comment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: reach
  Date: 2022/7/27
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    Article article = (Article) request.getAttribute("article");
    int userid = (Integer) request.getSession().getAttribute("UserID");
    List<Comment> comments = (List<Comment>) request.getAttribute("comments");
%>
<html>
<head>
    <title>详情</title>
</head>
<body>

<a href="home">首页</a>
<br>
<a href="personal">个人页</a>

<%
    if(userid == article.getUserID()){
        out.println("<a href=\"editpage?article="+article.getTitle()+"\">编辑</a>");
    }
%>

<table border="1">
    <tr>
        <td>标题</td>
        <td>
            <%out.println(article.getTitle());%>
        </td>
    </tr>
    <tr>
        <td>作者</td>
        <td>
            <%out.println(UserDAO.get_via_id(article.getUserID()).getUserName());%>
        </td>
    </tr>

    <tr>
        <td>发布时间</td>
        <td>
            <%out.println(article.getTime());%>
        </td>
    </tr>
    <tr>
        <td>内容</td>
        <td>
            <%out.println(article.getContext());%>
        </td>
    </tr>

</table>

<form action="addComment" method="post">
    <fieldset>
        <legend>评论</legend>
        <textarea name="context"></textarea>
        <input type="submit" value="提交"/>

    </fieldset>
</form>

<table border="1">
    <thead>
    <tr>
        <th>Responsor</th>
        <th>Date</th>
        <th>Context</th>
    </tr>
    </thead>
    <tbody>

    <%
        for (Comment s : comments) {
            out.println("<tr>"+"<td>"+UserDAO.get_via_id(s.getUserID()).getUserName()+"</td>"+"<td>"+s.getTime()+"</td>"+"<td>"+ s.getContext()+"</td></tr>");
        }
    %>

    </tbody>
</table>



</body>
</html>
