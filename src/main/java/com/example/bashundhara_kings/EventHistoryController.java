package com.example.bashundhara_kings;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class EventHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<Eventmanager,String> timeTablecolumn;
    @javafx.fxml.FXML
    private TableColumn<Eventmanager,String> venueTablecolumn;
    @javafx.fxml.FXML
    private TableColumn<Eventmanager,String> typeTablecolumn;
    @javafx.fxml.FXML
    private TableColumn<Eventmanager, LocalDate> dateTablecolumn;
    @javafx.fxml.FXML
    private Label massagLabel;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TableColumn<Eventmanager,Integer> idTablecolumn;
    @javafx.fxml.FXML
    private TableView<Eventmanager> tableColumnView;
    @javafx.fxml.FXML
    private ComboBox<String> filterEvenTypeComboBox;

    ArrayList<Eventmanager>EventmanagerList;
    // //String eventType, String description, String venue, String time, Integer eventID, LocalDate eventDate
    @javafx.fxml.FXML
    public void initialize() {
        EventmanagerList=new ArrayList<Eventmanager>();


        filterEvenTypeComboBox.getItems().addAll("Home Match","Training Session","League Match (BPL)","Federation Cup Match","Jersey Launch");

        typeTablecolumn.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        venueTablecolumn.setCellValueFactory(new PropertyValueFactory<>("venue"));
        timeTablecolumn.setCellValueFactory(new PropertyValueFactory<>("time"));;
        idTablecolumn.setCellValueFactory(new PropertyValueFactory<>("eventID"));
        dateTablecolumn.setCellValueFactory(new PropertyValueFactory<>("eventDate"));

    }

    @javafx.fxml.FXML
    public void viewhistoyOnActoin(ActionEvent actionEvent) {

        tableColumnView.getItems().clear();
        File f =new File("Event.bin");
        FileInputStream fis;
        ObjectInputStream ois;

        try {
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try {
                    Eventmanager s =(Eventmanager) ois.readObject();
                    if (filterEvenTypeComboBox.getValue().equals(s.getEventType())){
                        tableColumnView.getItems().add(s);
                    };



                }

                catch (Exception e){
                    break;
                }
            }
            massagLabel.setText("The following table contains specific event details ");
        }
        catch (Exception e){
            e.printStackTrace();
        }






    }

    @javafx.fxml.FXML
    public void backButtonOnActoin(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("event_manager_dashboard.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}