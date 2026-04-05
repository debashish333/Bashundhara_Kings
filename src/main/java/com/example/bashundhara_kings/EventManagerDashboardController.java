package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EventManagerDashboardController
{
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createventOnAtion(ActionEvent actionEvent) throws Exception {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("1create_event.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void viewTodayseventOnAtion(ActionEvent actionEvent) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("5view_todays.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void viewscheduleOnAtion(ActionEvent actionEvent)throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("2view_event_schedule.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("5view_todays.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage=new Stage();
//        stage.setScene(scene);
//        stage.show();
    }

    @javafx.fxml.FXML
    public void sendnotificatiOnAction(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("7send_notification.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void editeventOnAtion(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("3edit_event.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void eventhistoryOnAtion(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("6event_history.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void approveeventOnActoin(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("8approve_event.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void deleteventOnAtion(ActionEvent actionEvent)throws  Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("4delet_event.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }
}