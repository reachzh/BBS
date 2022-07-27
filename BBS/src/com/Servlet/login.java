package com.Servlet;

import com.Bean.User;
import com.DAO.UserDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class login extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("psw");


        User user = new User();
        user = UserDAO.isUser(username, password);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        if (user != null) {
            out.println("<p>登录成功<p><p><a href=\"home\">打开首页</a> <a href=\"personal\">打开个人主页</a>");
            request.getSession().setAttribute("UserID", user.getUserID());//session跟踪
        } else {
            out.println("<p>登录失败<p><a href=\"login.jsp\">重新登录</a><a href=\"signup.jsp\">注册</a>");
        }
    }


}
