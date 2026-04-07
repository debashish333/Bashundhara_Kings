package com.example.bashundhara_kings;

import java.io.Serializable;
import java.time.LocalDate;

public class Eventmanager implements Serializable {

    private String eventType,description, venue,time,eventID;
    private LocalDate eventDate;

    public Eventmanager(String eventType, String description, String venue, String time, String eventID, LocalDate eventDate) {
        this.eventType = eventType;
        this.description = description;
        this.venue = venue;
        this.time = time;
        this.eventID = eventID;
        this.eventDate = eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Eventmanager{" +
                "eventType='" + eventType + '\'' +
                ", description='" + description + '\'' +
                ", venue='" + venue + '\'' +
                ", time='" + time + '\'' +
                ", eventID='" + eventID + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}
