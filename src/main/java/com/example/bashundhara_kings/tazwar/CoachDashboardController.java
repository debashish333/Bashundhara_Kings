package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CoachDashboardController {

    @javafx.fxml.FXML
    public void openCreateTrainingSchedule(ActionEvent event) throws IOException {
        loadScene(event, "CoachCreateSchedule.fxml");
    }

    @javafx.fxml.FXML
    public void openViewTrainingSchedule(ActionEvent event) throws IOException {
        loadScene(event, "CoachViewSchedule.fxml");
    }

    @javafx.fxml.FXML
    public void openViewPlayerList(ActionEvent event) throws IOException {
        loadScene(event, "CoachViewPlayerList.fxml");
    }

    @javafx.fxml.FXML
    public void openAssignPlayers(ActionEvent event) throws IOException {
        loadScene(event, "CoachAssignPlayers.fxml");
    }

    @javafx.fxml.FXML
    public void openRecordPerformance(ActionEvent event) throws IOException {
        loadScene(event, "CoachRecordPerformance.fxml");
    }

    @javafx.fxml.FXML
    public void openViewAttendance(ActionEvent event) throws IOException {
        loadScene(event, "CoachViewAttendance.fxml");
    }

    @javafx.fxml.FXML
    public void openSendMessage(ActionEvent event) throws IOException {
        loadScene(event, "CoachSendMessage.fxml");
    }

    @javafx.fxml.FXML
    public void openUpdateTrainingPlan(ActionEvent event) throws IOException {
        loadScene(event, "CoachUpdateTrainingPlan.fxml");
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
