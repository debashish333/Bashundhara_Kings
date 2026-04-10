package com.example.bashundhara_kings.nirupama;

import javafx.scene.control.ComboBox;

public class CreateManageUserRoles {
    private String Role;
    @javafx.fxml.FXML
    private ComboBox roleComboBox;

    public CreateManageUserRoles(String role) {
        Role = role;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "CreatManageUserRoles{" +
                "Role='" + Role + '\'' +
                '}';
    }
}
