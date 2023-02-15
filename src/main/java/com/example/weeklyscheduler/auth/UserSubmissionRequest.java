package com.example.weeklyscheduler.auth;

/**
 * @author jmo
 */



public class UserSubmissionRequest {

    private String userName;
    private String email;
    private String password;

    public UserSubmissionRequest() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
