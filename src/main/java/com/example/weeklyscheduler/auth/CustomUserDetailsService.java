package com.example.weeklyscheduler.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author jmo
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private final WeeklyPlannerUserRepo weeklyPlannerUserRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomUserDetailsService(WeeklyPlannerUserRepo weeklyPlannerUserRepo, PasswordEncoder passwordEncoder) {
        this.weeklyPlannerUserRepo = weeklyPlannerUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    ApplicationRunner applicationRunner(){
        return args -> {
            WeeklyPlannerUser user = new WeeklyPlannerUser();
            user.setUserName("cq");
            user.setEmail("cq");
            user.setPassword(passwordEncoder.encode("cq"));
            user.setRole(UserRole.ADMIN);

            weeklyPlannerUserRepo.save(user);


            WeeklyPlannerUser user1 = new WeeklyPlannerUser();
            user1.setUserName("ceq");
            user1.setEmail("ceq");
            user1.setPassword(passwordEncoder.encode("ceq"));
            user1.setRole(UserRole.USER);

            weeklyPlannerUserRepo.save(user1);
        };
    }



    public WeeklyPlannerUser saveUser(UserSubmissionRequest userSubmissionRequest){
            WeeklyPlannerUser user = new WeeklyPlannerUser();
            user.setUserName(userSubmissionRequest.getUserName());
            user.setEmail(userSubmissionRequest.getEmail());
            user.setPassword(passwordEncoder.encode(userSubmissionRequest.getPassword()));
            user.setRole(UserRole.USER);

            weeklyPlannerUserRepo.save(user);
            return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return weeklyPlannerUserRepo
                .findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " doesn't exists"));
    }
}
