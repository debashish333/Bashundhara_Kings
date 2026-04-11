
package com.example.bashundhara_kings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String userName;
    private String password;
    private String role;

    // Shared in-memory user list (same pattern as demo)
    public static List<User> userList = new ArrayList<>();

    public User(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "User{userName='" + userName + "', role='" + role + "'}";
    }
}
