package com.example.bashundhara_kings.debashish;

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
import java.time.LocalDate;
import java.util.ArrayList;

public class ViewPreviousAttendenceController
{
    @javafx.fxml.FXML
    private TableColumn<AttendencetClass ,Integer> GuardidTC;
    @javafx.fxml.FXML
    private TableColumn<AttendencetClass ,String> tiemTC;
    @javafx.fxml.FXML
    private TableColumn<AttendencetClass, LocalDate> dataTC;
    @javafx.fxml.FXML
    private TableColumn<AttendencetClass,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<AttendencetClass,String> GuardTC;
    @javafx.fxml.FXML
    private AnchorPane mainPane;

    ArrayList<AttendencetClass>AttendenceList;
    @javafx.fxml.FXML
    private TableView tableViewww;

    @javafx.fxml.FXML
    public void initialize() {

        //int id, String name, String time, String status, LocalDate dob
        AttendenceList=new ArrayList<AttendencetClass>();

        GuardidTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        GuardTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        tiemTC.setCellValueFactory(new PropertyValueFactory<>("time"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        dataTC.setCellValueFactory(new PropertyValueFactory<>("dob"));
    }



    @javafx.fxml.FXML
    public void cleckButtonOnAction(ActionEvent actionEvent) {
        File f =new File("SecurityGuardAttendance.bin");
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);


                while (true){

                    try {

                        AttendencetClass a = (AttendencetClass) ois.readObject();
                        tableViewww.getItems().addAll(a);
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
    public void backOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("security_guard_dashbord.fxml"));
            Node node=fxmlLoader.load();
            mainPane.getChildren().setAll(node);
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
}