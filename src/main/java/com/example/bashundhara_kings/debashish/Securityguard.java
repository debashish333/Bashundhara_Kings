package com.example.bashundhara_kings.debashish;

import java.time.LocalDate;

public class  Securityguard {

    private String name;
    private  int id,password;
    private LocalDate dob;

    public Securityguard(String name, int id, int password, LocalDate dob) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Securityguard{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password=" + password +
                ", dob=" + dob +
                '}';
    }
}
