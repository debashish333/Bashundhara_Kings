package com.example.bashundhara_kings.debashish;

import java.io.Serializable;
import java.time.LocalDate;

public class Report implements Serializable {
    private String reportType,description,time;
    private int id;
    private LocalDate dob;


    public Report(String reportType, String description, String time, int id, LocalDate dob) {
        this.reportType = reportType;
        this.description = description;
        this.time = time;
        this.id = id;
        this.dob = dob;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
