package com.example.weeklyscheduler.service;

import com.example.weeklyscheduler.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jmo
 */
public interface EventRepo extends JpaRepository<Event, Long> {
}
