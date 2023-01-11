package com.example.weeklyscheduler.api;

import com.example.weeklyscheduler.auth.AuthenticationService;
import com.example.weeklyscheduler.model.UserSubmissionRequest;
import com.example.weeklyscheduler.auth.CustomUserDetailsService;
import com.example.weeklyscheduler.auth.WeeklyPlannerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController()
@RequestMapping(path = "user")
public class UserManagementController {




    private final CustomUserDetailsService customUserDetailsService;


    @Autowired
    public UserManagementController(
            CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }


    @PostMapping("/saveUser/{userName}")
    public ResponseEntity<String> saveUser(@PathVariable String userName){
        //dbService.saveUser(userName);
        return new ResponseEntity<String>("User saved", HttpStatus.I_AM_A_TEAPOT);
    }


     @PreAuthorize("hasAuthority('ROLE_ADMIN')")
     @GetMapping("/getAll")
     public ResponseEntity<List<WeeklyPlannerUser>> getAll(Authentication authentication){

        System.out.println("working" + (authentication== null));
        return new ResponseEntity<>(
                List.of((WeeklyPlannerUser) customUserDetailsService.loadUserByUsername("ceq")), HttpStatus.OK);
     }



     @GetMapping("/getAuthorities")
     public ResponseEntity<Collection<GrantedAuthority>> getAuthorities(Authentication authentication){
        WeeklyPlannerUser user = (WeeklyPlannerUser)authentication.getPrincipal();
        System.out.println(user.getUserName());

        return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
     }

}
