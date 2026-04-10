package com.example.bashundhara_kings.nirupama;

import javafx.scene.control.ComboBox;

public class CreateManageUserRoles {
    private String Role;
    @javafx.fxml.FXML
    private ComboBox selectuserComboBox;
    @javafx.fxml.FXML
    private ComboBox selectroleComboBOX;

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

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateroleOnAction(ActionEvent actionEvent) {
    }
}
