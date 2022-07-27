package com.Servlet;

import com.Bean.Article;
import com.DAO.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class home extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        List<Article> articles = new ArrayList<>();
        articles = ArticleDAO.findall();

        request.setAttribute("articles",articles);
        try {
            request.getRequestDispatcher("home.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

}
