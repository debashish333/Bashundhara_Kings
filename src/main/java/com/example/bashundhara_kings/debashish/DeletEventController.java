package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class DeletEventController
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
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void LoadButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backbuttonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("event_manager_dashboard.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void deletOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void selectONAction(ActionEvent actionEvent) {
    }
}