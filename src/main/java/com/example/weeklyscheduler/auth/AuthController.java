package com.example.weeklyscheduler.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jmo
 */


@RequestMapping("auth")
@CrossOrigin("${clientSide.url}")
@RestController
public class AuthController {


    private final AuthenticationService authenticationService;


    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/addUser")
    public ResponseEntity<AuthDTO> addUser(@RequestBody UserSubmissionRequest userSubmissionRequest){


        return new ResponseEntity<>(authenticationService.register(userSubmissionRequest),
                HttpStatus.OK);
    }



    @PostMapping("/login")
    public ResponseEntity<AuthDTO> addUser(@RequestBody UserLoginRequest userLoginRequest){

        return new ResponseEntity<>(
                authenticationService.authenticate(userLoginRequest),
                HttpStatus.OK);
    }


}
