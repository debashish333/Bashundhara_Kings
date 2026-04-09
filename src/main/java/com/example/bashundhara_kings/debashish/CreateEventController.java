package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CreateEventController implements Serializable
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField idtextfield;
    @javafx.fxml.FXML
    private ComboBox<String> typeCombobox;
    @javafx.fxml.FXML
    private ComboBox<String> VanueCombobox;
    @javafx.fxml.FXML
    private TextField timetextfield;
    @javafx.fxml.FXML
    private TextArea descriptiontextfield;
    @javafx.fxml.FXML
    private AnchorPane mainpane;


    ArrayList<Eventmanager>EventmanagerList;
    @javafx.fxml.FXML
    private Label messageLabel;

    @javafx.fxml.FXML
    public void initialize() {
        EventmanagerList=new ArrayList<Eventmanager>();

        VanueCombobox.getItems().addAll("Kings Arena (Main Stadium)", "Bashundhara Kings Training Ground","Bashundhara Sports Complex - Indoor Arena","Bashundhara Kings Youth Academy Ground","National Stadium, Dhaka (Old Paltan)","Bir Shreshtha Shaheed Shipahi Mostafa Kamal Stadium, Kamalapur");
        typeCombobox.getItems().addAll("Home Match","Training Session","League Match (BPL)","Federation Cup Match","Jersey Launch");

    }

    //String eventType, String description, String venue, String time, Integer eventID, LocalDate eventDate
    @javafx.fxml.FXML
    public void saveButtonONACTION(ActionEvent actionEvent) {

        if (typeCombobox.getValue() == null ||
                descriptiontextfield.getText().isEmpty() ||
                VanueCombobox.getValue() == null ||
                timetextfield.getText().isEmpty() ||
                idtextfield.getText().isEmpty() ||
                date.getValue() == null) {

            errorAlert("Please Fill Up All Fields");
            return;
        }
        //if (idtextfield.getText()==)
        for (Eventmanager co:EventmanagerList){
            if (Integer.parseInt(idtextfield.getText())==co.getEventID()){
                errorAlert("This Event ID is already in Use");
                return;
            }
        }

        Eventmanager co = new Eventmanager(
                typeCombobox.getValue(),
                descriptiontextfield.getText(),
                VanueCombobox.getValue(),
                timetextfield.getText(),
                Integer.parseInt(idtextfield.getText()),
                date.getValue()
        );
        EventmanagerList.add(co);

        File f = new File("Event.bin");
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
            successAlert("Event Saved Successfully!!");

            oos.writeObject(co);
            oos.close();
        }



        catch (Exception e){
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void backButtonONACTION(ActionEvent actionEvent)throws Exception {

        try {

            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("event_manager_dashboard.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void clearButtonONACTION(ActionEvent actionEvent) {
        idtextfield.clear();
        descriptiontextfield.clear();
        timetextfield.clear();
        date.getEditor().clear();
        typeCombobox.getSelectionModel().clearSelection();
        VanueCombobox.getSelectionModel().clearSelection();
    }

    public void errorAlert(String ee){
        Alert a= new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(ee);
        a.showAndWait();
    }

    public void successAlert(String msg){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(msg);
        a.showAndWait();
    }
}