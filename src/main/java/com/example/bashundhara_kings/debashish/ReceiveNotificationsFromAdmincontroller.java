package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReceiveNotificationsFromAdmincontroller
{
    @javafx.fxml.FXML
    private Label NotificationLabel;
    @javafx.fxml.FXML
    private AnchorPane main;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void refreshButtonOnAction(ActionEvent actionEvent) {
//        File f = new File("Notifications.bin");
//        FileInputStream fis;
//        ObjectInputStream ois;

//        try {
//            fis=new FileInputStream(f);
//            ois=new ObjectInputStream(fis);

//            try {
//                while (true){
//                    Eventmanager h=(Eventmanager) ois.readObject();
//                    NotificationLabel.setText(h.toString());
//
//                }
//            }
//            catch (Exception e){
//                ;
//            }

//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }


        File f = new File("Notifications.bin");

        if (!f.exists()) {
            NotificationLabel.setText("No notifications found");
            return;
        }

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            StringBuilder allNotifications = new StringBuilder();

            while (true) {
                try {
                    Eventmanager h = (Eventmanager) ois.readObject();
                    allNotifications.append(h.toString()).append("\n");
                } catch (Exception e) {
                    break;
                }
            }

            ois.close();

            if (allNotifications.length() == 0) {
                NotificationLabel.setText("No notifications available");
            } else {
                NotificationLabel.setText(allNotifications.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("security_guard_dashbord.fxml"));
            Node node=fxmlLoader.load();
            main.getChildren().setAll(node);
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
}