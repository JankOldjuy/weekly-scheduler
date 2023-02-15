package com.example.weeklyscheduler.auth;

/**
 * @author jmo
 */
public class AuthDTO {


    private String Token;


    public AuthDTO(String token) {
        Token = token;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
