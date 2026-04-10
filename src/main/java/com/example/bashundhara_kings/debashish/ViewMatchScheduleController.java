package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class ViewMatchScheduleController
{
    @javafx.fxml.FXML
    private TableColumn<Eventmanager ,String> timeTablecolumn;
    @javafx.fxml.FXML
    private TableColumn<Eventmanager,String> venueTablecolumn;
    @javafx.fxml.FXML
    private TableColumn<Eventmanager,String> typeTablecolumn;
    @javafx.fxml.FXML
    private TableColumn<Eventmanager, LocalDate> dateTablecolumn;
    @javafx.fxml.FXML
    private TableColumn<Eventmanager,Integer> idTablecolumn;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    @javafx.fxml.FXML
    private TableView<Eventmanager> tableCalumnViewww;

    //string eventType, String description, String venue, String time, Integer eventID, LocalDate eventDate
    @javafx.fxml.FXML
    public void initialize() {

       idTablecolumn.setCellValueFactory(new PropertyValueFactory<>("eventID"));
       dateTablecolumn.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
       venueTablecolumn.setCellValueFactory(new PropertyValueFactory<>("venue"));
       typeTablecolumn.setCellValueFactory(new PropertyValueFactory<>("eventType"));
       timeTablecolumn.setCellValueFactory(new PropertyValueFactory<>("time"));


    }

    @javafx.fxml.FXML
    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("security_guard_dashbord.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void scheduleButtonOnAction(ActionEvent actionEvent) {
        File f =new File("event_manager_dashboard.fxml");
        FileInputStream fis;
        ObjectInputStream ois;

        try {

            fis=new FileInputStream(f);
            ois=new ObjectInputStream(fis);
            while (true){
                try {
                    Eventmanager s= (Eventmanager) ois.readObject();
                    tableCalumnViewww.getItems().add(s);



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