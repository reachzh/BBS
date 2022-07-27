package com.DAO;

import com.Bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//注册——增加
//注册——判断用户名是否存在
//登录——查找，判断是否存在用户
//article——通过ID查找到用户
//session跟踪通过ID来跟踪
//
public class UserDAO {
    //增
    public static void add(User user){
        Connection conn = DB_Connection.getConnection();

        String sql = "INSERT INTO users(UserName,Password) VALUE(?,?)";
        // 获取PreparedStatement
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            int n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        DB_Connection.close(conn);

    }

    public static User get_via_id(int userid){
        Connection conn;
        PreparedStatement ps;
        ResultSet rst;
        User user = new User();


        String SQL = "SELECT * FROM users WHERE UserID=?";

        //从数据库读出信息，同时插入链表
        conn = DB_Connection.getConnection();
        try {
            //读取信息
            ps = conn.prepareStatement(SQL);
            ps.setInt(1,userid);
            rst = ps.executeQuery();
            if(rst.next()){
                String username = rst.getString("UserName");
                String password = rst.getString("Password");

                user.setUserID(userid);
                user.setUserName(username);
                user.setPassword(password);
            }


            //处理结果
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;

    }


    //注册、登录需要的逻辑
    //查找用户名在数据库是否存在
    public static boolean isUsername(String username){
        Connection conn;
        PreparedStatement ps;
        ResultSet rst;

        String SQL = "SELECT * FROM users WHERE UserName=?";

        //从数据库读出信息，同时插入链表
        conn = DB_Connection.getConnection();
        try {
            //读取信息
            ps = conn.prepareStatement(SQL);
            ps.setString(1,username);
            rst = ps.executeQuery();
            return rst.next();


            //处理结果
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //用于判断用户是否存在，若存在返回user对象
    public static User isUser(String username, String password){
        Connection conn;
        PreparedStatement ps;
        ResultSet rst;

        String SQL = "SELECT * FROM users WHERE UserName=? AND Password=?";

        //从数据库读出信息，同时插入链表
        conn = DB_Connection.getConnection();
        try {
            //读取信息
            ps = conn.prepareStatement(SQL);
            ps.setString(1,username);
            ps.setString(2,password);
            rst = ps.executeQuery();
            if(rst.next()){
                int UserID = rst.getInt("UserID");

                User user = new User();
                user.setUserID(UserID);
                user.setUserName(username);
                user.setPassword(password);
                return user;
            } else{
                return null;
            }


            //处理结果
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
