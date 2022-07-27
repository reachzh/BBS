package com.Bean;

import com.DAO.DB_Connection;

import java.sql.*;

public class Article {
    private int ArticleID;
    private String Title;
    private String Context;
    private Date Time;
    private int UserID;

    public Article(){

    }

    public Article(int ArticleID, String Title, String Context, Date Time, int UserID){
        this.ArticleID = ArticleID;
        this.Title = Title;
        this.Context = Context;
        this.Time = Time;
        this.UserID = UserID;
    }


    public int getArticleID() {
        return ArticleID;
    }

    public void setArticleID(int articleID) {
        ArticleID = articleID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int CommentNum(){
        Connection conn;
        PreparedStatement ps;
        ResultSet rst;

        int ret = 0;

        String SQL = "SELECT * FROM comments WHERE ArticleID=?";

        conn = DB_Connection.getConnection();

        try {
            //读取信息
            ps = conn.prepareStatement(SQL);
            ps.setInt(1,this.ArticleID);
            rst = ps.executeQuery();


            //处理结果
            while(rst.next()){
               ret++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ret;

    }
}
