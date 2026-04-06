package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EditEventController
{
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TextField SharchidTextfield;
    @javafx.fxml.FXML
    private TextField idtextfield;
    @javafx.fxml.FXML
    private ComboBox typeCombobox;
    @javafx.fxml.FXML
    private ComboBox VanueCombobox;
    @javafx.fxml.FXML
    private TextField timetextfield;
    @javafx.fxml.FXML
    private DatePicker date1;
    @javafx.fxml.FXML
    private TextArea descriptiontextfield;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sharchButtonONACTION(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bacjButtonOnActoin(ActionEvent actionEvent) {
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
    public void clearButtonONACTION(ActionEvent actionEvent) {
    }
}