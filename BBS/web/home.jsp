<%--
  Created by IntelliJ IDEA.
  User: reach
  Date: 2022/7/27
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Bean.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.DAO.UserDAO" %>
<%
    List<Article> articles = new ArrayList<>();
    articles = (List<Article>) request.getAttribute("articles");
%><html>
<head>
    <title>首页</title>
</head>
<body>
<a href="home">首页</a>
<br>
<a href="personal">个人页</a>

<table border="1">
    <thead>
    <tr>
        <th>ArticleID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Date</th>
        <th>CommentNum</th>

        <th>more</th>
    </tr>
    </thead>
    <tbody>

    <%
        for (Article s : articles) {
            out.println("<tr>"+"<td>"+s.getArticleID()+"</td>"+"<td>"+s.getTitle()+"</td>"+"<td>"+ UserDAO.get_via_id(s.getUserID()).getUserName()+"</td>"+"<td>"+s.getTime()+"</td>"+"<td>"+s.CommentNum()+"</td>"+"<td><a href=\"read?Title="+s.getTitle()+"\">详情</a></td>"+"</tr>");
        }
    %>

    </tbody>
</table>
</body>
</html>
