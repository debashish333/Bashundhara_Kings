package com.example.bashundhara_kings.debashish;

import java.time.LocalDate;

public abstract class  User {


    private final String name;
    private final int id,password;
    private final LocalDate dob;

    public User(String name, int id, int password, LocalDate dob) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password=" + password +
                ", dob=" + dob +
                '}';
    }
}
