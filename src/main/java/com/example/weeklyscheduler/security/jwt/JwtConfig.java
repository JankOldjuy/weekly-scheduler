package com.example.weeklyscheduler.security.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * @author jmo
 */


@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {


    /**
     * Header of JWT token
     */
    private String header;
    private String secretKey;
    private int expiration;
    //private SignatureAlgorithm signatureAlgorithm;


    /*public void setSignatureAlgorithm(SignatureAlgorithm signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
    }*/

    public void setHeader(String header) {
        this.header = header;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }



    public String getHeader() {
        return header;
    }

    /*public SignatureAlgorithm getSignatureAlgorithm() {
        return signatureAlgorithm;
    }*/
    public String getSecretKey() {
        return secretKey;
    }

    public int getExpiration() {
        return expiration;
    }


    @Override
    public String toString() {
        return "JwtConfig{" +
                "header='" + header + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", expiration=" + expiration +
                '}';
    }
}
