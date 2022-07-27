package com.Servlet;

import com.Bean.Article;
import com.Bean.Comment;
import com.DAO.ArticleDAO;
import com.DAO.CommentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class read extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {

        Article article = ArticleDAO.find_via_title((String) request.getParameter("Title"));

        List<Comment> comments = new ArrayList<>();
        comments = CommentDao.find_in_Article(article.getArticleID());

        request.setAttribute("comments",comments);

        request.setAttribute("article",article);
        try {
            request.getSession().setAttribute("current_articleID", article.getArticleID());//session跟踪

            request.getRequestDispatcher("read.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }


}
