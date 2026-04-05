package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class EventHistoryController
{
    @javafx.fxml.FXML
    private TableColumn timeTablecolumn;
    @javafx.fxml.FXML
    private TableColumn venueTablecolumn;
    @javafx.fxml.FXML
    private TableColumn typeTablecolumn;
    @javafx.fxml.FXML
    private TableColumn dateTablecolumn;
    @javafx.fxml.FXML
    private TableColumn idTablecolumn;
    @javafx.fxml.FXML
    private Label massagLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void viewhistoyOnActoin(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnActoin(ActionEvent actionEvent)throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("event_manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}