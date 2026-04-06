package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class ManagVIPGuestsforEventManagerController
{
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
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
    public void viewguestListButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("5.1viwe_guest_list_for_EventManager.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}