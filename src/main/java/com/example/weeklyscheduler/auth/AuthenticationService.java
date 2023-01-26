package com.example.weeklyscheduler.auth;

import com.example.weeklyscheduler.model.UserLoginRequest;
import com.example.weeklyscheduler.model.UserSubmissionRequest;
import com.example.weeklyscheduler.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author jmo
 */


@Service
public class AuthenticationService {



    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthenticationService(
            AuthenticationManager authenticationManager,
            CustomUserDetailsService customUserDetailsService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtils = jwtUtils;
    }

    public String register(UserSubmissionRequest userSubmissionRequest){
        System.out.println(jwtUtils.getJwtConfig().getSecretKey());

        return jwtUtils.createJwtToken(customUserDetailsService.saveUser(userSubmissionRequest), new HashMap<>());
    }
    public String authenticate(UserLoginRequest userLoginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginRequest.getUserName(),
                userLoginRequest.getPassword()
        ));

        WeeklyPlannerUser user =
                (WeeklyPlannerUser) customUserDetailsService.loadUserByUsername(userLoginRequest.getUserName());

        return jwtUtils.createJwtToken(user, new HashMap<>());



    }



}
