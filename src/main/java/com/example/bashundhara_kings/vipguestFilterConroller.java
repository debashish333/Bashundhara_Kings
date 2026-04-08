package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class vipguestFilterConroller
{
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,String> seat_areaTableColumn;
    @javafx.fxml.FXML
    private TableView<VIPGuest> TableolumnVieww;
    @javafx.fxml.FXML
    private TextField idtextfield;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,Integer> guestIDTableColumn;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,String> eventTypeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<VIPGuest,String> guestNameTableColumn;

    ArrayList<VIPGuest>VipGuestList;
    @javafx.fxml.FXML
    public void initialize() {

        //int guestID, String guestName, String designation, String seatArea, String eventType
        VipGuestList=new ArrayList<VIPGuest>();

        guestIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("guestID"));
        guestNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("guestName"));
        eventTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        seat_areaTableColumn.setCellValueFactory(new PropertyValueFactory<>("seatArea"));

    }

    @javafx.fxml.FXML
    public void FilterButtonOnAction(ActionEvent actionEvent) {



        if (idtextfield.getText()==null){
            erroralert("Enter the guest ID first");

        }
        TableolumnVieww.getItems().clear();
        File f = new File("VIPGuest.bin");
        FileInputStream fis;
        ObjectInputStream ois;

        try {
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){

                try {
                    VIPGuest v= (VIPGuest) ois.readObject();

                    // improtant line for filtering.
                    if (Integer.parseInt(idtextfield.getText())== v.getGuestID()){
                        TableolumnVieww.getItems().add(v);
                    }

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

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("event_manager_dashboard.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void erroralert(String e){
        Alert a=new Alert(Alert.AlertType.WARNING);
        a.setContentText(e);
        a.showAndWait();
    }
}