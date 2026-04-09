package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ManagVIPGuestsforEventManagerController
{
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TextField guestnametextField;
    @javafx.fxml.FXML
    private TextField giestidtextField;
    @javafx.fxml.FXML
    private TextArea designationtextarea;
    @javafx.fxml.FXML
    private ComboBox<String> seatCombobox;
    @javafx.fxml.FXML
    private ComboBox<String> eventTypeCombobox;
    @javafx.fxml.FXML
    private Label messageLabel;

    ArrayList<VIPGuest>VIPList;
    @javafx.fxml.FXML
    public void initialize() {

       VIPList=new ArrayList<VIPGuest>();


        seatCombobox.getItems().addAll(
                "VVIP Lounge (Top Level)",
                "VIP Box (Main Stand)",
                "Corporate Hospitality Suite",
                "Media & Press Area",
                "Match Officials Zone",
                "Premium Front Row Seating",
                "East Stand - General",
                "West Stand - General",
                "North Stand (Behind Goal)",
                "South Stand (Behind Goal)"
        );

        eventTypeCombobox.getItems().addAll("Home Match","Training Session","League Match (BPL)","Federation Cup Match","Jersey Launch");


    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("event_manager_dashboard.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void viewguestListButtonOnAction(ActionEvent actionEvent) {



        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("5.1viwe_guest_list_for_EventManager.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //public VIPGuest(int guestID, String guestName, String designation, String seatArea, String eventType)
    @javafx.fxml.FXML
    public void addVIPButtonOnaction(ActionEvent actionEvent) {

        if (giestidtextField.getText().isEmpty() ||
                guestnametextField.getText().isEmpty() ||
                designationtextarea.getText().isEmpty() ||
                seatCombobox.getValue() == null ||
                eventTypeCombobox.getValue() == null) {

            messageLabel.setText("Please fill all fields!");
            return;
        }
        VIPGuest co=new VIPGuest(
                Integer.parseInt(giestidtextField.getText()),
                guestnametextField.getText(),
                designationtextarea.getText(),
                seatCombobox.getValue(),
                eventTypeCombobox.getValue()



        );
        VIPList.add(co);

        File f = new File("VIPGuest.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if (f.exists()){
                fos=new FileOutputStream(f,true);
                oos=new AppendableObjectOutputStream(fos);
            }
            else {
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);
            }

            oos.writeObject(co);
            oos.close();
        }


        catch (Exception e){
            e.printStackTrace();
        }
        informatoinAlert("Information Saved Successfully!!");
        giestidtextField.clear();
        guestnametextField.clear();
        designationtextarea.clear();
        seatCombobox.setValue(null);
        eventTypeCombobox.setValue(null);



    }


    public void informatoinAlert(String msg){
        Alert a= new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(msg);
        a.showAndWait();
    }
//    public void successAlert(String msg){
//        Alert a = new Alert(Alert.AlertType.INFORMATION);
//        a.setContentText(msg);
//        a.showAndWait();
//    }
}
