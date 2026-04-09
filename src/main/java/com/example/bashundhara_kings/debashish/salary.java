package com.example.bashundhara_kings.debashish;

import java.time.LocalDate;

public class salary {
    private int id ,salary;

    private  String name;
    private LocalDate dob;

    public salary(int id, int salary, String name, LocalDate dob) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
