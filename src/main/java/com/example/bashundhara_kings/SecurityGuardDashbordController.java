package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class SecurityGuardDashbordController
{

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadButtonOnaction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void checkNotificationsButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void viewMatchScheduleButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void checksalaryButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("check_salary_info_page1.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Deprecated
    public void logoutButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void reportEmergencyButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void viewRulesAndInstructionsButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void viewVipGuestListButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void submitDailySecurityReportButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void markAttendanceButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
    }
}