package com.DAO;

import com.Bean.Article;
import com.Bean.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    public static List<Comment> find_in_Article(int ArticleID){
        List<Comment> articles =new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        ResultSet rst;

        String SQL = "SELECT * FROM comments WHERE ArticleID=?";

        conn = DB_Connection.getConnection();

        try {
            //读取信息
            ps = conn.prepareStatement(SQL);
            ps.setInt(1,ArticleID);
            rst = ps.executeQuery();


            //处理结果
            while(rst.next()){
                int CommentID = rst.getInt("CommentID");
                int articleID = rst.getInt("ArticleID");
                int UserID = rst.getInt("UserID");
                String context = rst.getString("Context");
                Date Time = rst.getDate("Time");

                Comment comment = new Comment(CommentID,articleID,UserID,context,Time);
                articles.add(comment);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return articles;
    }

    public static void add(Comment comment){
        Connection conn = DB_Connection.getConnection();

        String sql = "INSERT INTO comments(ArticleID,UserID,Context,Time) VALUE(?,?,?,?)";
        // 获取PreparedStatement
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,comment.getArticleID());
            ps.setInt(2,comment.getUserID());
            ps.setString(3,comment.getContext());
            ps.setDate(4,comment.getTime());
            int n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        DB_Connection.close(conn);

    }
}
