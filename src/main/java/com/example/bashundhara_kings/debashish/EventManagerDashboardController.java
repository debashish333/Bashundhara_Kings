package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;

public class EventManagerDashboardController implements Serializable
{
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createventOnAtion(ActionEvent actionEvent)  {


        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("1create_event.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

//    @Deprecated
//    public void viewTodayseventOnAtion(ActionEvent actionEvent) throws Exception{
//
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("5view_todays.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage=new Stage();
//        stage.setScene(scene);
//        stage.show();
//    }

    @javafx.fxml.FXML
    public void viewscheduleOnAtion(ActionEvent actionEvent){

       try {
           FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("2view_event_schedule.fxml"));
           Node node=fxmlLoader.load();
           mainpane.getChildren().setAll(node);

       }
       catch (Exception e){
           e.printStackTrace();
       }
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
    public void sendnotificatiOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("7send_notification.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void editeventOnAtion(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("3edit_event.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void eventhistoryOnAtion(ActionEvent actionEvent){
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("6event_history.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

//    @Deprecated
//    public void approveeventOnActoin(ActionEvent actionEvent) {
//        try {
//            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("8vipguestFilter.fxml"));
//            Node node=fxmlLoader.load();
//            mainpane.getChildren().setAll(node);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    @javafx.fxml.FXML
    public void deleteventOnAtion(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("4delet_event.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void manageVIPguestONAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("5manag_VIP _guests_EventManager.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void VipGuestFilterOnActoin(ActionEvent actionEvent) {


        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("8vipguestFilter.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}