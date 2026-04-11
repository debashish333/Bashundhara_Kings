package com.example.bashundhara_kings.tazwar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CoachDashboardController {

    @FXML
    private AnchorPane mainpane;

    @FXML
    public void initialize() {
    }

    @FXML
    public void openCreateTrainingSchedule(ActionEvent event) {
        loadIntoMainpane("CoachCreateSchedule.fxml");
    }

    @FXML
    public void openViewTrainingSchedule(ActionEvent event) {
        loadIntoMainpane("CoachViewSchedule.fxml");
    }

    @FXML
    public void openViewPlayerList(ActionEvent event) {
        loadIntoMainpane("CoachViewPlayerList.fxml");
    }

    @FXML
    public void openAssignPlayers(ActionEvent event) {
        loadIntoMainpane("CoachAssignPlayers.fxml");
    }

    @FXML
    public void openRecordPerformance(ActionEvent event) {
        loadIntoMainpane("CoachRecordPerformance.fxml");
    }

    @FXML
    public void openViewAttendance(ActionEvent event) {
        loadIntoMainpane("CoachViewAttendance.fxml");
    }

    @FXML
    public void openSendMessage(ActionEvent event) {
        loadIntoMainpane("CoachSendMessage.fxml");
    }

    @FXML
    public void openUpdateTrainingPlan(ActionEvent event) {
        loadIntoMainpane("CoachUpdateTrainingPlan.fxml");
    }

    @FXML
    public void logout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/example/bashundhara_kings/loginView.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/example/bashundhara_kings/tazwar/" + fxmlFile));
            Node node = loader.load();
            mainpane.getChildren().setAll(node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
