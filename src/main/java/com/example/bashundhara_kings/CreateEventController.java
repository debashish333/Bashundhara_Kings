package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CreateEventController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField idtextfield;
    @javafx.fxml.FXML
    private ComboBox typeCombobox;
    @javafx.fxml.FXML
    private ComboBox VanueCombobox;
    @javafx.fxml.FXML
    private TextField timetextfield;
    @javafx.fxml.FXML
    private TextArea descriptiontextfield;
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveButtonONACTION(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButtonONACTION(ActionEvent actionEvent)throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("event_manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void clearButtonONACTION(ActionEvent actionEvent) {
    }
}