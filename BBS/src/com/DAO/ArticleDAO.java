package com.DAO;



//发帖 增加
//编辑 修改
//首页显示所有帖子的标题 查找所有
//个人主页显示帖子的标题 通过userid查找

import com.Bean.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    public static List<Article> findall(){
        List<Article> articles =new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        ResultSet rst;

        String SQL = "SELECT * FROM articles";

        conn = DB_Connection.getConnection();

        try {
            //读取信息
            ps = conn.prepareStatement(SQL);
            rst = ps.executeQuery();

            //处理结果
            while(rst.next()){
                int ArticleID = rst.getInt("ArticleID");
                String title =rst.getString("Title");
                String context = rst.getString("Context");
                Date time = rst.getDate("Time");
                int UserID = rst.getInt("UserID");

                Article article = new Article(ArticleID,title,context,time,UserID);
                articles.add(article);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return articles;


    }

    public static List<Article> find_in_userid(int UserID){
        List<Article> articles =new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        ResultSet rst;

        String SQL = "SELECT * FROM articles WHERE UserID=?";

        conn = DB_Connection.getConnection();

        try {
            //读取信息
            ps = conn.prepareStatement(SQL);
            ps.setInt(1,UserID);
            rst = ps.executeQuery();


            //处理结果
            while(rst.next()){
                int ArticleID = rst.getInt("ArticleID");
                String title =rst.getString("Title");
                String context = rst.getString("Context");
                Date time = rst.getDate("Time");
//                int UserID = rst.getInt("UserID");

                Article article = new Article(ArticleID,title,context,time,UserID);
                articles.add(article);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return articles;


    }


    public static Article find_via_id(int ArticleID){
        Connection conn;
        PreparedStatement ps;
        ResultSet rst;
        Article article = new Article();

        String SQL = "SELECT * FROM articles WHERE ArticleID=?";

        conn = DB_Connection.getConnection();

        try {
            //读取信息
            ps = conn.prepareStatement(SQL);
            ps.setInt(1,ArticleID);
            rst = ps.executeQuery();


            //处理结果
            if(rst.next()){
//                int ArticleID = rst.getInt("ArticleID");
                String title =rst.getString("Title");
                String context = rst.getString("Context");
                Date time = rst.getDate("Time");
                int UserID = rst.getInt("UserID");

//                Article article = new Article(ArticleID,title,context,time,UserID);
                article.setArticleID(ArticleID);
                article.setTitle(title);
                article.setContext(context);
                article.setTime(time);
                article.setUserID(UserID);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return article;

    }

    public static Article find_via_title(String Title){
        Connection conn;
        PreparedStatement ps;
        ResultSet rst;
        Article article = new Article();

        String SQL = "SELECT * FROM articles WHERE Title=?";

        conn = DB_Connection.getConnection();

        try {
            //读取信息
            ps = conn.prepareStatement(SQL);
            ps.setString(1,Title);
            rst = ps.executeQuery();


            //处理结果
            if(rst.next()){
                int ArticleID = rst.getInt("ArticleID");
                String title =rst.getString("Title");
                String context = rst.getString("Context");
                Date time = rst.getDate("Time");
                int UserID = rst.getInt("UserID");

//                Article article = new Article(ArticleID,title,context,time,UserID);
                article.setArticleID(ArticleID);
                article.setTitle(title);
                article.setContext(context);
                article.setTime(time);
                article.setUserID(UserID);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return article;

    }


    public static void add(Article article){
        Connection conn = DB_Connection.getConnection();
        String sql = "INSERT INTO articles(Title,Context,Time,UserID) VALUE(?,?,?,?)";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContext());
            ps.setDate(3,article.getTime());
            ps.setInt(4, article.getUserID());
            int n = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DB_Connection.close(conn);

    }

    public static void edit(Article article){
        Connection conn = DB_Connection.getConnection();
        String sql = "UPDATE articles SET Title = ?, Context = ?, Time = ? WHERE ArticleID = ?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContext());
            ps.setDate(3,article.getTime());
            ps.setInt(4, article.getArticleID());
            int n = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DB_Connection.close(conn);

    }


}
