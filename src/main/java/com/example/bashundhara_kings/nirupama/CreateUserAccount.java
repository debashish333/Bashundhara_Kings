package com.example.bashundhara_kings.nirupama;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreateUserAccount {
    private int Id, Password, PhoneNumber;
    private String Name, Role;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField passwordTF;
    @javafx.fxml.FXML
    private TextField phonenoTF;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private TextField roleTF;


    public CreateUserAccount(int id, int password, int phoneNumber, String name) {
        Id = id;
        Password = password;
        PhoneNumber = phoneNumber;
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CreateUserAccount{" +
                "Id=" + Id +
                ", Password=" + Password +
                ", PhoneNumber=" + PhoneNumber +
                ", Name='" + Name + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @javafx.fxml.FXML
    public void loginOnAction(ActionEvent actionEvent) {
    }
}
