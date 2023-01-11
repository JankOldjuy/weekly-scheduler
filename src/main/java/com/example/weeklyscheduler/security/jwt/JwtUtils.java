package com.example.weeklyscheduler.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author jmo
 */
@Component
public class JwtUtils {

    private final JwtConfig jwtConfig;

    @Autowired
    public JwtUtils(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public JwtConfig getJwtConfig() {
        return jwtConfig;
    }



    public <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver){
        Claims claims = extractClaims(token);

        return claimsResolver.apply(claims);
    }


    public String extractUserName(String jwt){
        return extractClaim(jwt, Claims::getSubject);
    }

    private Claims extractClaims(String jwt){
        return Jwts
                .parser()
                .setSigningKey(jwtConfig.getSecretKey())
                .parseClaimsJws(jwt)
                .getBody();
    }


    public String createJwtToken(UserDetails userDetails, Map<String, Object> claims){
        return "Bearer " + Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(jwtConfig.getExpiration())))
                .signWith(SignatureAlgorithm.HS256, Keys.hmacShaKeyFor(getJwtConfig().getSecretKey().getBytes()))
                .compact();
    }


    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUserName(token);
        return (!isTokenExpired(token) && userDetails.getUsername().equals(username));
    }


    private Date extractExpiration(String jwt){
        return extractClaim(jwt, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());

    }


}
