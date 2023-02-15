package com.example.weeklyscheduler.auth;

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

    public AuthDTO register(UserSubmissionRequest userSubmissionRequest){
        System.out.println(jwtUtils.getJwtConfig().getSecretKey());

        return new AuthDTO(jwtUtils.
                createJwtToken(customUserDetailsService.
                        saveUser(userSubmissionRequest), new HashMap<>()));
    }
    public AuthDTO authenticate(UserLoginRequest userLoginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginRequest.getUserName(),
                userLoginRequest.getPassword()
        ));


        WeeklyPlannerUser user =
                (WeeklyPlannerUser) customUserDetailsService.loadUserByUsername(userLoginRequest.getUserName());

        return new AuthDTO(jwtUtils.createJwtToken(user, new HashMap<>()));
    }



}
