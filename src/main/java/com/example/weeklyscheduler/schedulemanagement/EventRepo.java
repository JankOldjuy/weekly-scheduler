package com.example.weeklyscheduler.schedulemanagement;

import com.example.weeklyscheduler.schedulemanagement.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jmo
 */
public interface EventRepo extends JpaRepository<Event, Long> {
}
