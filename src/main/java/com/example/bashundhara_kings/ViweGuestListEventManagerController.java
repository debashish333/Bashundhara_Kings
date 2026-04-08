package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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
    }
}