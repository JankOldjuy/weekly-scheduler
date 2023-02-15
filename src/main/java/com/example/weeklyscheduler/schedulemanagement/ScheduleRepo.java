package com.example.weeklyscheduler.schedulemanagement;

import com.example.weeklyscheduler.schedulemanagement.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author jmo
 */
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

    Optional<Schedule> findByWeeklyPlannerUser_Id(Long weeklyPlannerUser_Id);

}
