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

public class ReportEmergencyController
{
    @javafx.fxml.FXML
    private DatePicker dob;
    @javafx.fxml.FXML
    private ComboBox<String> EmergencyTypeCombobox;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TextArea descriptionTextarea;
    @javafx.fxml.FXML
    private TextField tiem;
    @javafx.fxml.FXML
    private Label messageLabel;

    ArrayList<Report>ReportList;
    @javafx.fxml.FXML
    private ComboBox<String> locationofIncidencCobmobox;
    @javafx.fxml.FXML
    private TextField giardidtextfield;

    @javafx.fxml.FXML
    public void initialize() {
        ReportList=new ArrayList<Report>();
        locationofIncidencCobmobox.getItems().addAll(
                "Main Gate",
                "Gate 1",
                "Gate 2",
                "VIP Entrance",
                "Parking Area",
                "Main Stadium",
                "Gallery / Seating Area",
                "Locker Room",
                "Control Room",
                "Food Court",
                "Restroom Area",
                "Training Ground",
                "Outside Perimeter",
                "Other");
        EmergencyTypeCombobox.getItems().addAll(
                "Fire",
                "Medical Emergency",
                "Security Threat",
                "Suspicious Activity",
                "Accident",
                "Unauthorized Access",
                "Theft",
                "Vandalism",
                "Crowd Control Issue",
                "Other");



    }

    @javafx.fxml.FXML
    public void submitReportButtonOnAction(ActionEvent actionEvent) {
        //String reportType, String description, String time, int id, LocalDate dob

        if (giardidtextfield.getText()==null || descriptionTextarea.getText()==null){
            erroralert("please write your ID and Description");
            return;
        }
        Report co =new Report(
                EmergencyTypeCombobox.getValue(),
                descriptionTextarea.getText(),
                tiem.getText(),
                Integer.parseInt(giardidtextfield.getText()),
                dob.getValue()

        );
        File f =new File("EmergencyCases.bin");
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
            messageLabel.setText("Report Submit Successful.");
            oos.writeObject(co);
            oos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {

        try {

            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("security_guard_dashbord.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void erroralert(String e){
        Alert a=new Alert(Alert.AlertType.ERROR);
        a.setContentText(e);
        a.showAndWait();
    }
}