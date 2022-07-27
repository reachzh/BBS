package com.Servlet;

import com.Bean.Article;
import com.DAO.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

public class editArticle extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        request.setCharacterEncoding("UTF-8");
        String Title = request.getParameter("title");
        String Context = request.getParameter("context");
        int UserID = (Integer) request.getSession().getAttribute("UserID");
        Date Time = new Date(System.currentTimeMillis());

        Article article = new Article();
        article.setTitle(Title);
        article.setContext(Context);
        article.setUserID(UserID);
        article.setTime(Time);
        article.setArticleID(ArticleDAO.find_via_title(Title).getArticleID());

        ArticleDAO.edit(article);

        try {
            request.getRequestDispatcher("home").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


    }
}
