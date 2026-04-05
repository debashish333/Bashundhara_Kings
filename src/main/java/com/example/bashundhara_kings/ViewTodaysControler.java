package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewTodaysControler
{
    @javafx.fxml.FXML
    private TableColumn timeTablecolumn;
    @javafx.fxml.FXML
    private TableColumn venueTablecolumn;
    @javafx.fxml.FXML
    private TableView TVV;
    @javafx.fxml.FXML
    private TableColumn typeTablecolumn;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TableColumn dateTablecolumn;
    @javafx.fxml.FXML
    private TableColumn idTablecolumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("event_manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}