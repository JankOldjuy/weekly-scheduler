package com.example.weeklyscheduler.schedulemanagement;

import com.example.weeklyscheduler.auth.WeeklyPlannerUser;
import jakarta.persistence.*;


import java.util.List;

/**
 * @author jmo
 */


@Entity
@Table(name = "WeeklySchedule")
public class Schedule {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long scheduleId;

    @JoinColumn(name = "scheduleUser", referencedColumnName = "id")
    @OneToOne
    private WeeklyPlannerUser weeklyPlannerUser;


    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
    private List<Event> events;

    public Schedule() {
    }


    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public WeeklyPlannerUser getWeeklyPlannerUser() {
        return weeklyPlannerUser;
    }

    public void setWeeklyPlannerUser(WeeklyPlannerUser weeklyPlannerUser) {
        this.weeklyPlannerUser = weeklyPlannerUser;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", weeklyPlannerUser=" + weeklyPlannerUser +
                ", events=" + events +
                '}';
    }
}
