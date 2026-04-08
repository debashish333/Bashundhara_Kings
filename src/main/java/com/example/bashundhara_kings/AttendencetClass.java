package com.example.bashundhara_kings;

import java.io.Serializable;
import java.time.LocalDate;

public class AttendencetClass implements Serializable {

    private int id;
    private String name, time, status;
    private LocalDate dob;

    public AttendencetClass(int id, String name, String time, String status, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.status = status;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "AttendencetClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", dob=" + dob +
                '}';
    }
}
