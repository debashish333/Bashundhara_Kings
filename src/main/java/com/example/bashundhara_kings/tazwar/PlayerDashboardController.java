package com.example.bashundhara_kings.tazwar;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerDashboardController {

    @javafx.fxml.FXML
    public void openViewTrainingSchedule(ActionEvent event) throws IOException {
        loadScene(event, "PlayerViewTrainingSchedule.fxml");
    }

    @javafx.fxml.FXML
    public void openViewMatchSchedule(ActionEvent event) throws IOException {
        loadScene(event, "PlayerViewMatchSchedule.fxml");
    }

    @javafx.fxml.FXML
    public void openViewPerformance(ActionEvent event) throws IOException {
        loadScene(event, "PlayerViewPerformance.fxml");
    }

    @javafx.fxml.FXML
    public void openMarkAttendance(ActionEvent event) throws IOException {
        loadScene(event, "PlayerMarkAttendance.fxml");
    }

    @javafx.fxml.FXML
    public void openRequestEquipment(ActionEvent event) throws IOException {
        loadScene(event, "PlayerRequestEquipment.fxml");
    }

    @javafx.fxml.FXML
    public void openViewAnnouncements(ActionEvent event) throws IOException {
        loadScene(event, "PlayerViewAnnouncements.fxml");
    }

    @javafx.fxml.FXML
    public void openUpdateProfile(ActionEvent event) throws IOException {
        loadScene(event, "PlayerUpdateProfile.fxml");
    }

    @javafx.fxml.FXML
    public void openSendMessage(ActionEvent event) throws IOException {
        loadScene(event, "PlayerSendMessage.fxml");
    }

    @javafx.fxml.FXML
    public void logout(ActionEvent event) throws IOException {
        loadScene(event, "Login.fxml");
    }

    private void loadScene(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + fxmlFile));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
