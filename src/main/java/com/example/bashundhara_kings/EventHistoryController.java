package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void viewhistoyOnActoin(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonOnActoin(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("event_manager_dashboard.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}