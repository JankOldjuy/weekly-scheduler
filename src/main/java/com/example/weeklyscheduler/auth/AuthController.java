package com.example.weeklyscheduler.auth;

import com.example.weeklyscheduler.model.UserLoginRequest;
import com.example.weeklyscheduler.model.UserSubmissionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jmo
 */


@RequestMapping("auth")
@RestController
public class AuthController {


    private final AuthenticationService authenticationService;


    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserSubmissionRequest userSubmissionRequest){


        return new ResponseEntity<>(authenticationService.register(userSubmissionRequest),
                HttpStatus.OK);
    }



    
    @PostMapping("/login")
    public ResponseEntity<String> addUser(@RequestBody UserLoginRequest userLoginRequest){

        return new ResponseEntity<>(authenticationService.authenticate(userLoginRequest),
                HttpStatus.OK);
    }


}
