package com.DAO;

import java.sql.*;

public class DB_Connection {
    public static Connection getConnection(String table){
        Connection conn;

        String url = "jdbc:mysql://localhost:3306/"+table+"?useUnicode=true&characterEncoding=utf-8";
        // 数据库用户名
        String username = "root";
        // 数据库密码
        String password = "root";

        // 创建Connection连接
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

    public static Connection getConnection() {
        return getConnection("dbbbs");
    }



    public static PreparedStatement prepareStmt(Connection conn, String sql) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public static ResultSet executeQuery(Statement stmt, String sql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void close(Connection conn){
        if(conn !=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
