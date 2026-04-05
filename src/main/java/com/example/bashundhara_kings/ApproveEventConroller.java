package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ApproveEventConroller
{
    @javafx.fxml.FXML
    private ComboBox venueCombobox;
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private ComboBox eventtypeCombobox;
    @javafx.fxml.FXML
    private TextField idtextfield;
    @javafx.fxml.FXML
    private ComboBox statusCombobox;
    @javafx.fxml.FXML
    private TextArea reporttextArea;
    @javafx.fxml.FXML
    private Label massaegeLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void approveButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backbuttonOnAction(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("event_manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void cencleButtonOnaction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void verifybuttonOnAction(ActionEvent actionEvent) {
    }
}