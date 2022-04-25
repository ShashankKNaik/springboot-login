package com.shashank.springbootlogin;

public class User {
    private String userName;
    private String password;

    public void setUserName(String name) {
        userName = name;
    }

    public String getUserName() {
        return userName;
    }


    public void setPassword(String pass) {
        password = pass;
    }

    public String getPassword() {
        return password;
    }

}
