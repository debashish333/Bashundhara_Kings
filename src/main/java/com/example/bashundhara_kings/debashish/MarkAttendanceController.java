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

public class MarkAttendanceController
{
    @javafx.fxml.FXML
    private AnchorPane main;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private ComboBox<String> statusCombobox;
    @javafx.fxml.FXML
    private TextField guardIDtextfield;
    @javafx.fxml.FXML
    private TextField nameTextfield;
    @javafx.fxml.FXML
    private TextField timetextfield;
    @javafx.fxml.FXML
    private DatePicker date;
    ArrayList<AttendencetClass>AttendenceClassList;
    @javafx.fxml.FXML
    public void initialize() {
        AttendenceClassList=new ArrayList<AttendencetClass>();
        statusCombobox.getItems().addAll("Present", "Absent", "Late", "Excused");

    }

    @javafx.fxml.FXML
    public void mekeattendenceButtonOnAction(ActionEvent actionEvent) {
        //int id, String name, String time, String status, LocalDate dob


        if (guardIDtextfield.getText().isEmpty()){
            informationAlert("please fillup ID");
            return;

        }


        AttendencetClass co= new AttendencetClass(

                Integer.parseInt(guardIDtextfield.getText()),
                nameTextfield.getText(),
                timetextfield.getText(),
                statusCombobox.getValue(),
                date.getValue()

        );

        File f = new File("SecurityGuardAttendance.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if (f.exists()){
                fos=new FileOutputStream(f ,true);
                oos=new AppendableObjectOutputStream(fos);

            }
            else {
                fos=new FileOutputStream(f);
                oos=new ObjectOutputStream(fos);

            }
            oos.writeObject(co);
            oos.close();
            messageLabel.setText("Attendance Successful!!");
        }

        catch (Exception e){
            e.printStackTrace();
            guardIDtextfield.clear();
            nameTextfield.clear();
            timetextfield.clear();
            statusCombobox.getSelectionModel().clearSelection();
            date.setValue(null);
        }



    }

    @javafx.fxml.FXML
    public void back(ActionEvent actionEvent) throws Exception{
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("security_guard_dashbord.fxml"));
            Node node=fxmlLoader.load();
            main.getChildren().setAll(node);
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }

    public void informationAlert(String i ){
        Alert a= new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(i);
        a.showAndWait();
    }
}