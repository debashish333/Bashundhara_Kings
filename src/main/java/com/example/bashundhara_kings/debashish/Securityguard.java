package com.example.bashundhara_kings.debashish;

import java.time.LocalDate;

public class  Securityguard {

    private String name;
    private  int id,password;

    public Securityguard(String name, int id, int password) {
        this.name = name;
        this.id = id;
        this.password = password;
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



    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
