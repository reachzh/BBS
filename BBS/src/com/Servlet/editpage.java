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

public class editpage extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {

        String title = request.getParameter("article");

        System.out.println(title);

        int id = (Integer) request.getSession().getAttribute("UserID");

        Article article = new Article();
        article = ArticleDAO.find_via_title(title);

        request.setAttribute("article",article);
        try {
            request.getRequestDispatcher("editpage.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
