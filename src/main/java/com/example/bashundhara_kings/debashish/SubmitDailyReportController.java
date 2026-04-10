package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.util.ArrayList;

public class SubmitDailyReportController
{
    @javafx.fxml.FXML
    private TextField guardIDtextfield;
    @javafx.fxml.FXML
    private DatePicker dob;
    @javafx.fxml.FXML
    private ComboBox<String> shiftTimeCombobox;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private Label message;

    ArrayList<Report>ReportList;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeCombobox;

    @javafx.fxml.FXML
    public void initialize() {
        ReportList=new ArrayList<Report>();
        shiftTimeCombobox.getItems().addAll("Morning Shift (06:00 AM – 02:00 PM)", "Afternoon Shift (02:00 PM – 10:00 PM)", "Night Shift (10:00 PM – 06:00 AM)");
        reportTypeCombobox.getItems().addAll(   "Routine Report", "Patrol Report");


    }

    @javafx.fxml.FXML
    public void submitButtonOnAction(ActionEvent actionEvent) {

        //String reportType, String description, String time, int id, LocalDate dob
        Report co=new Report(
                reportTypeCombobox.getValue(),
                descriptionTextArea.getText(),
                shiftTimeCombobox.getValue(),
                Integer.parseInt(guardIDtextfield.getText()),
                dob.getValue()
        );

        File f =new File("DailyReport.bin");
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
            message.setText("Report Submit Successfully!");
            oos.writeObject(co);
            oos.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }

//        File f =new File("DailyReport.bin");
//        FileInputStream fis;
//        ObjectInputStream ois;
//
//        try {
//            fis=new FileInputStream(f);
//            ois=new ObjectInputStream(fis);
//            while (true){
//                try {
//                    Report r = (Report) ois.readObject();
//                    System.out.println(r);
//
//
//                }
//                catch (Exception e){
//                    break;
//                }
//            }
//
//            ois.close();
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

    }

    @javafx.fxml.FXML
    public void backButtonONAction(ActionEvent actionEvent) {
       try {
           FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("security_guard_dashbord.fxml"));
           Node node=fxmlLoader.load();
           mainpane.getChildren().setAll(node);
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }
}