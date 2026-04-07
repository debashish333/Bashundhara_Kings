package com.example.bashundhara_kings;

import java.time.LocalDate;

public abstract class Eventmanager extends User{

    private String eventType,description, venue,time;
    private int eventID;
    private LocalDate eventDate;

    public Eventmanager(String name, int id, int password, LocalDate dob, String eventType, String description, String venue, String time, int eventID, LocalDate eventDate) {
        super(name, id, password, dob);
        this.eventType = eventType;
        this.description = description;
        this.venue = venue;
        this.time = time;
        this.eventID = eventID;
        this.eventDate = eventDate;
    }


}
