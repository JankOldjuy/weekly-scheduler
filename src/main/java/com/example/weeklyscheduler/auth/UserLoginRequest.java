package com.example.weeklyscheduler.auth;

/**
 * @author jmo
 */

public class UserLoginRequest {


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String userName;
    private String password;


    public UserLoginRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
