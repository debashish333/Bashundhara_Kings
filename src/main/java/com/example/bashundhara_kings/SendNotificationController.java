package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SendNotificationController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectuserCombobox;
    @javafx.fxml.FXML
    private TextArea messageLabel;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    ArrayList<Eventmanager>EventmanagerList;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
        EventmanagerList=new ArrayList<Eventmanager>();
        selectuserCombobox.getItems().addAll("Coach","Coach","Medical Staff","System Administrator");
    }

    @javafx.fxml.FXML
    public void sendNotificationButtonONAction(ActionEvent actionEvent) {

        if (selectuserCombobox.getValue() == null) {
            outputLabel.setText("Please select a user!");
            return;
        }

        outputLabel.setText("Notification sent successfully!");
        selectuserCombobox.getSelectionModel().clearSelection();
        messageLabel.clear();
    }

    @javafx.fxml.FXML
    public void backOnaction(ActionEvent actionEvent)throws Exception {
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