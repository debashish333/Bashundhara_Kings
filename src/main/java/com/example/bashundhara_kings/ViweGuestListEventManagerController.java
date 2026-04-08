package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ViweGuestListEventManagerController
{
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,String> seat_areaTableColumn;
    @javafx.fxml.FXML
    private TableView<VIPGuest> TableolumnVieww;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,Integer> guestIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,String>  eventTypeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,String>  guestNameTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        //int guestID, String guestName, String designation, String seatArea, String eventType
        guestIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("guestID"));
        guestNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        seat_areaTableColumn.setCellValueFactory(new PropertyValueFactory<>("seatArea"));
        eventTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("eventType"));


    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
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
    public void loadButtonOnAction(ActionEvent actionEvent) {

        File f = new File("VIPGuest.bin");
        FileInputStream fis;
        ObjectInputStream ois;

        try {
            fis=new FileInputStream(f);
            ois =new ObjectInputStream(fis);
            while (true){
                try {
                    VIPGuest v = (VIPGuest) ois.readObject();
                    TableolumnVieww.getItems().addAll(v);

                }
                catch (Exception e){
                    break;
                }
            }

            ois.close();
        }


        catch (Exception e){
            e.printStackTrace();
        }


    }
}