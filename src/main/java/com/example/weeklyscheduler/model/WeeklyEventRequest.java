package com.example.weeklyscheduler.model;

import java.util.Date;

/**
 * @author jmo
 */


public class WeeklyEventRequest {


    private String eventDescription;
    private Date date;


    public WeeklyEventRequest() {
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "WeeklyEventRequest{" +
                "description='" + eventDescription + '\'' +
                ", date=" + date +
                '}';
    }
}
