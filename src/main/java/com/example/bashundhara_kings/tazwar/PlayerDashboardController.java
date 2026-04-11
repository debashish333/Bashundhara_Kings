package com.example.bashundhara_kings.tazwar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerDashboardController {

    @FXML
    private AnchorPane mainpane;

    @FXML
    public void initialize() {

    }



    @FXML
    public void openViewTrainingSchedule(ActionEvent event) {
        loadIntoMainpane("PlayerViewTrainingSchedule.fxml");
    }

    @FXML
    public void openViewMatchSchedule(ActionEvent event) {
        loadIntoMainpane("PlayerViewMatchSchedule.fxml");
    }

    @FXML
    public void openViewPerformance(ActionEvent event) {
        loadIntoMainpane("PlayerViewPerformance.fxml");
    }

    @FXML
    public void openMarkAttendance(ActionEvent event) {
        loadIntoMainpane("PlayerMarkAttendance.fxml");
    }

    @FXML
    public void openRequestEquipment(ActionEvent event) {
        loadIntoMainpane("PlayerRequestEquipment.fxml");
    }

    @FXML
    public void openViewAnnouncements(ActionEvent event) {
        loadIntoMainpane("PlayerViewAnnouncements.fxml");
    }

    @FXML
    public void openUpdateProfile(ActionEvent event) {
        loadIntoMainpane("PlayerUpdateProfile.fxml");
    }

    @FXML
    public void openSendMessage(ActionEvent event) {
        loadIntoMainpane("PlayerSendMessage.fxml");
    }



    @FXML
    public void logout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/bashundhara_kings/loginView.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) mainpane.getScene().getWindow();
            stage.setTitle("Login");
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void loadIntoMainpane(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/example/bashundhara_kings/tazwar/" + fxmlFile
                    )
            );

            Node node = loader.load();
            mainpane.getChildren().setAll(node);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void loadScene(ActionEvent event, String fxmlFile) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/example/bashundhara_kings/tazwar/" + fxmlFile
                )
        );

        Scene scene = new Scene(loader.load());

        Stage stage = (Stage) ((Button) event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
    }
}