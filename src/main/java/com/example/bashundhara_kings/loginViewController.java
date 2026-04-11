package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.bashundhara_kings.User.userList;

public class loginViewController {

    @FXML private ComboBox<String> userComboBox;
    @FXML private PasswordField passLogIn;
    @FXML private PasswordField password;
    @FXML private PasswordField confirmPassword;
    @FXML private TextField userField;
    @FXML private CheckBox showPass;
    @FXML private Label loginInfo;
    @FXML private Label createInfo;

    @FXML
    public void initialize() {
        userComboBox.getItems().addAll(
                "Coach",
                "Player",
                "Event Manager",
                "Security Guard",
                "Accountant",
                "Medical Staff",
                "System Administrator",
                "Club Manager"
        );
    }

    @FXML
    public void Login(ActionEvent actionEvent) throws IOException {
        if (userComboBox.getValue() == null || passLogIn.getText().isEmpty()) {
            loginInfo.setText("Please fill all the fields.");
            return;
        }

        // Check dynamically created accounts first
        for (User u : userList) {
            if (u.getUserName().equals(userComboBox.getValue()) && u.getPassword().equals(passLogIn.getText())) {
                loadScene(actionEvent, getDashboardFxml(u.getRole()), u.getRole() + " Dashboard");
                return;
            }
        }

        // Default password login for all 8 users
        String selectedUser = userComboBox.getValue();
        String enteredPass = passLogIn.getText();

        if (!enteredPass.equals("12345")) {
            showLoginError();
            return;
        }

        switch (selectedUser) {
            case "Coach":
                loadScene(actionEvent, "CoachDashboard.fxml", "Coach Dashboard");
                break;
            case "Player":
                loadScene(actionEvent, "PlayerDashboard.fxml", "Player Dashboard");
                break;
            case "Event Manager":
                loadScene(actionEvent, "EventManagerDashboard.fxml", "Event Manager Dashboard");
                break;
            case "Security Guard":
                loadScene(actionEvent, "SecurityGuardDashboard.fxml", "Security Guard Dashboard");
                break;
            case "Accountant":
                loadScene(actionEvent, "AccountantDashboard.fxml", "Accountant Dashboard");
                break;
            case "Medical Staff":
                loadScene(actionEvent, "MedicalStaffDashboard.fxml", "Medical Staff Dashboard");
                break;
            case "System Administrator":
                loadScene(actionEvent, "SystemAdminDashboard.fxml", "System Administrator Dashboard");
                break;
            case "Club Manager":
                loadScene(actionEvent, "ClubManagerDashboard.fxml", "Club Manager Dashboard");
                break;
            default:
                showLoginError();
        }
    }

    @FXML
    public void createAccount(ActionEvent actionEvent) {
        String newUser = userField.getText().trim();
        String newPass = password.getText();
        String confirmPass = confirmPassword.getText();

        if (newUser.isEmpty() || newPass.isEmpty() || confirmPass.isEmpty()) {
            createInfo.setText("Please fill all the fields!");
            return;
        }
        if (!newPass.equals(confirmPass)) {
            createInfo.setText("Passwords don't match!");
            return;
        }
        for (User u : userList) {
            if (u.getUserName().equals(newUser)) {
                createInfo.setText("This user already exists!");
                return;
            }
        }

        User user = new User(newUser, newPass, newUser);
        userList.add(user);
        userComboBox.getItems().add(newUser);
        createInfo.setText("New account created successfully!");

        userField.clear();
        password.clear();
        confirmPassword.clear();
    }

    @FXML
    public void forgetPassword(ActionEvent actionEvent) {
        loginInfo.setText("Try to remember your password!");
    }

    @FXML
    public void showPassword(ActionEvent actionEvent) {
        if (showPass.isSelected()) {
            if (passLogIn.getText().isEmpty()) {
                loginInfo.setText("Enter Password");
                return;
            }
            loginInfo.setText(passLogIn.getText());
        } else {
            loginInfo.setText("");
        }
    }

    private String getDashboardFxml(String role) {
        switch (role) {
            case "Coach":                return "CoachDashboard.fxml";
            case "Player":               return "PlayerDashboard.fxml";
            case "Event Manager":        return "EventManagerDashboard.fxml";
            case "Security Guard":       return "SecurityGuardDashboard.fxml";
            case "Accountant":           return "AccountantDashboard.fxml";
            case "Medical Staff":        return "MedicalStaffDashboard.fxml";
            case "System Administrator": return "SystemAdminDashboard.fxml";
            case "Club Manager":         return "ClubManagerDashboard.fxml";
            default:                     return "CoachDashboard.fxml";
        }
    }

    private void loadScene(ActionEvent event, String fxmlFile, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/example/bashundhara_kings/" + fxmlFile)
        );
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) loginInfo.getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
    }

    private void showLoginError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText("Invalid credentials");
        alert.setContentText("Please check your username and password.");
        alert.showAndWait();
    }
}