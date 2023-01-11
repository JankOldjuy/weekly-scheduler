package com.example.weeklyscheduler;

import com.example.weeklyscheduler.security.jwt.JwtConfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@EnableConfigurationProperties
@SpringBootApplication
public class WeeklySchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeeklySchedulerApplication.class, args);
    }

    /*@Bean
    ApplicationRunner applicationRunner(JwtConfig jwtConfig){

        return args -> {
            System.out.println(jwtConfig);
        };
    }*/


}
