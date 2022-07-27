package com.Servlet;

import com.Bean.User;
import com.DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class signup extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("psw");


        if(password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}") && !UserDAO.isUsername(username)) {//密码需要包含大小写字母和数字，长度6-20位

            User user = new User();
            user.setUserName(username);
            user.setPassword(password);

            UserDAO.add(user);

            response.setContentType("text/html;charset=UTF-8");

            PrintWriter out = response.getWriter();

            out.println("<p>注册成功<p><a href=\"login.jsp\">返回登录</a>");


        } else {
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter out = response.getWriter();
            if(UserDAO.isUsername(username)){
                out.println("<p>用户名已存在<p><a href=\"signup.jsp\">返回注册</a>");
            }else {
                out.println("<p>密码长度大于6位且要包含大小写字母以及数字<p><a href=\"signup.jsp\">返回注册</a>");
            }
        }

    }}
