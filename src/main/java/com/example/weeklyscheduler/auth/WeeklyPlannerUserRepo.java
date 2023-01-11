package com.example.weeklyscheduler.auth;

import com.example.weeklyscheduler.auth.WeeklyPlannerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author jmo
 */

@Repository
public interface WeeklyPlannerUserRepo extends JpaRepository<WeeklyPlannerUser, Long> {

Optional<WeeklyPlannerUser> findByUserName(String userName);


}
