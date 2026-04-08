package com.example.bashundhara_kings;

import java.io.Serializable;

public class VIPGuest implements Serializable {
    private int guestID;
    private String guestName;
    private String designation;
    private String seatArea;
    private String eventType;

    public VIPGuest(int guestID, String guestName, String designation, String seatArea, String eventType) {
        this.guestID = guestID;
        this.guestName = guestName;
        this.designation = designation;
        this.seatArea = seatArea;
        this.eventType = eventType;
    }

    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSeatArea() {
        return seatArea;
    }

    public void setSeatArea(String seatArea) {
        this.seatArea = seatArea;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "VIPGuest{" +
                "guestID=" + guestID +
                ", guestName='" + guestName + '\'' +
                ", designation='" + designation + '\'' +
                ", seatArea='" + seatArea + '\'' +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
