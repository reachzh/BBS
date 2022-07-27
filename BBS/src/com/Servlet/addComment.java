package com.Servlet;

import com.Bean.Article;
import com.Bean.Comment;
import com.DAO.ArticleDAO;
import com.DAO.CommentDao;
import com.DAO.CommentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

public class addComment extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        request.setCharacterEncoding("UTF-8");
        String Context = request.getParameter("context");
        int UserID = (Integer) request.getSession().getAttribute("UserID");
        Date Time = new Date(System.currentTimeMillis());
        int ArticleID = (Integer) request.getSession().getAttribute("current_articleID");

        Comment comment = new Comment(0,ArticleID,UserID,Context,Time);


        CommentDao.add(comment);

        try {
            request.getRequestDispatcher("read?Title="+ ArticleDAO.find_via_id(ArticleID).getTitle()).forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


    }
}
