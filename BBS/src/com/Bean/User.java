package com.Bean;

public class User {
    private int UserID;
    private String UserName;
    private String Password;

    public User(){

    }
    public User(int UserID, String UserName, String PassWord){
        this.UserID = UserID;
        this.UserName = UserName;
        this.Password = PassWord;
    }


    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }
}
