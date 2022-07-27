package com.Bean;

import java.sql.Date;

public class Comment {
    private int CommentID;
    private int ArticleID;
    private int UserID;
    private String Context;
    private Date Time;

    public Comment(){

    }

    public Comment(int CommentID, int ArticleID, int UserID, String Context, Date Time){
        this.CommentID = CommentID;
        this.ArticleID = ArticleID;
        this.UserID = UserID;
        this.Context = Context;
        this.Time = Time;
    }



    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int commentID) {
        CommentID = commentID;
    }

    public int getArticleID() {
        return ArticleID;
    }

    public void setArticleID(int articleID) {
        ArticleID = articleID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
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
}
