package com.shashank.springbootlogin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
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
