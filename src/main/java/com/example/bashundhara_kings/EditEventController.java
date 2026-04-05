package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EditEventController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private ComboBox venueCombobox;
    @javafx.fxml.FXML
    private TextArea descriptionTextfield;
    @javafx.fxml.FXML
    private ComboBox typeofeventCombobox;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TextField timeTextfield;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TextField SharchidTextfield;

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
    public void bacjButtonOnActoin(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("event_manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}