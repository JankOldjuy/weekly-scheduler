package com.example.weeklyscheduler.schedulemanagement;

import com.example.weeklyscheduler.auth.WeeklyPlannerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

/**
 * @author jmo
 */


@RequestMapping("/event")
@CrossOrigin("${clientSide.url}")
@RestController
public class SchedulerController {


    private final ScheduleRepo scheduleRepo;
    private final EventRepo eventRepo;


    @Autowired
    public SchedulerController(ScheduleRepo scheduleRepo, EventRepo eventRepo) {
        this.scheduleRepo = scheduleRepo;
        this.eventRepo = eventRepo;
    }


    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    @PostMapping("addEvent")
    public ResponseEntity<String> addEvent(@RequestBody WeeklyEventRequest weeklyEventRequest) throws UserPrincipalNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Schedule schedule = scheduleRepo.
                findByWeeklyPlannerUser_Id(((WeeklyPlannerUser)auth.getPrincipal()).getId()).
                orElse(null);



        Event event = new Event();
        event.setEventDescription(weeklyEventRequest.getEventDescription());
        event.setDate(weeklyEventRequest.getDate());


        if(schedule == null){
            schedule = new Schedule();
            schedule.setWeeklyPlannerUser((WeeklyPlannerUser) auth.getPrincipal());
            schedule.setEvents(List.of());
            scheduleRepo.save(schedule);
        }

        event.setSchedule(schedule);
        eventRepo.save(event);


        return ResponseEntity.ok("Event is successfully added");

    }


    @GetMapping("getAllEvents")
    public ResponseEntity<List<Event>> getAllEvents() throws UserPrincipalNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Schedule schedule = scheduleRepo.
                findByWeeklyPlannerUser_Id(((WeeklyPlannerUser)auth.getPrincipal()).getId()).
                orElse(null);



        return ResponseEntity.ok(schedule == null? null: schedule.getEvents());

    }



}






