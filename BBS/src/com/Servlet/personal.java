package com.Servlet;

import com.Bean.Article;
import com.DAO.ArticleDAO;
import com.DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class personal extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {


        int id = (Integer) request.getSession().getAttribute("UserID");

        List<Article> articles = new ArrayList<>();

        articles = ArticleDAO.find_in_userid(id);

        request.setAttribute("articles",articles);
        try {
            request.getRequestDispatcher("personal.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
