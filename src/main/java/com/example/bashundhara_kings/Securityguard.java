package com.example.bashundhara_kings;

import java.time.LocalDate;

public class  Securityguard extends User{

    private String time,status,emergencyType,locationofincident,description,shiftTimeCB;
    private float salary;
    private int passkey;
    private LocalDate currentDate;

    public Securityguard(String name, int id, int password, LocalDate dob, String time, String status, String emergencyType, String locationofincident, String description, String shiftTimeCB, float salary, int passkey, LocalDate currentDate) {
        super(name, id, password, dob);
        this.time = time;
        this.status = status;
        this.emergencyType = emergencyType;
        this.locationofincident = locationofincident;
        this.description = description;
        this.shiftTimeCB = shiftTimeCB;
        this.salary = salary;
        this.passkey = passkey;
        this.currentDate = currentDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getLocationofincident() {
        return locationofincident;
    }

    public void setLocationofincident(String locationofincident) {
        this.locationofincident = locationofincident;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShiftTimeCB() {
        return shiftTimeCB;
    }

    public void setShiftTimeCB(String shiftTimeCB) {
        this.shiftTimeCB = shiftTimeCB;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getPasskey() {
        return passkey;
    }

    public void setPasskey(int passkey) {
        this.passkey = passkey;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public String toString() {
        return "Securityguard{" +
                "time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", emergencyType='" + emergencyType + '\'' +
                ", locationofincident='" + locationofincident + '\'' +
                ", description='" + description + '\'' +
                ", shiftTimeCB='" + shiftTimeCB + '\'' +
                ", salary=" + salary +
                ", passkey=" + passkey +
                ", currentDate=" + currentDate +
                '}';
    }
}
