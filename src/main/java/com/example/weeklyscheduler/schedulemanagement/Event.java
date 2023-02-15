package com.example.weeklyscheduler.schedulemanagement;

import com.example.weeklyscheduler.schedulemanagement.Schedule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Date;

/**
 * @author jmo
 */

@Table(name = "weekly_event")
@Entity
public class Event {


    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long eventId;

    private Date date;

    @NonNull
    private String eventDescription;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "schedule_event")
    private Schedule schedule;


    public Event() {}

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @NonNull
    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(@NonNull String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", date=" + date +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }
}



