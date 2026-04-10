package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ViewVIPGuestListforSceutityGuardController
{
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,String> guestNameTC;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,Integer> gusetidTC;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,String> SeatTC;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,String> eventTypeTC;
    @javafx.fxml.FXML
    private TableView<VIPGuest> tableCalumnView;

    //int guestID, String guestName, String designation, String seatArea, String eventType
    @javafx.fxml.FXML
    public void initialize() {
        gusetidTC.setCellValueFactory(new PropertyValueFactory<>("guestID"));
        guestNameTC.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        eventTypeTC.setCellValueFactory(new PropertyValueFactory<>("seatArea"));
        SeatTC.setCellValueFactory(new PropertyValueFactory<>("seatArea"));


    }

    @javafx.fxml.FXML
    public void lodeButtonOnAction(ActionEvent actionEvent) {
        File f = new File("VIPGuest.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis =new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (true){

                try {
                    VIPGuest v = (VIPGuest) ois.readObject();
                    tableCalumnView.getItems().add(v);


                }
                catch (Exception e){
                    break;
                }
                ois.close();

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("security_guard_dashbord.fxml"));
        Node node =fxmlLoader.load();
        mainpane.getChildren().setAll(node);

    }
}