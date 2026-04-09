package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.ArrayList;

public class check_salary_infoController
{
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    ArrayList<Securityguard>SecurityguardList;
    @javafx.fxml.FXML
    private TextField guardIDtextfield;
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField passwprdtextfield;
    @javafx.fxml.FXML
    private TextField gueadsname;
    @javafx.fxml.FXML
    private Label messgelabel;

    @javafx.fxml.FXML
    public void initialize() {

        SecurityguardList =new ArrayList<Securityguard>();
        SecurityguardList.add(new Securityguard("Karim", 111, 123, LocalDate.of(1999,5,10)));
        SecurityguardList.add(new Securityguard("kamal",222,456, LocalDate.of(2000,1,1)));

    }



    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent) {

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
    public void verificationandNextsceneButtonOnActoin(ActionEvent actionEvent) {

        if ( gueadsname.getText().isEmpty()|| guardIDtextfield.getText().isEmpty()||passwprdtextfield.getText().isEmpty()||date.getValue()==null) {
            errorAlert("Fill all fields!");
            return;
        }
        for(Securityguard co: SecurityguardList){
            if (co.getId()==Integer.parseInt(guardIDtextfield.getText())&& co.getPassword()==Integer.parseInt(passwprdtextfield.getText())&& co.getName().equals(gueadsname.getText())){
                errorAlert("verification Successful!!");
            }
            else {
                errorAlert("ID and Password is not correct");
            }


        }



    }



    public void errorAlert(String e){
        Alert a=new Alert(Alert.AlertType.WARNING);
        a.setContentText(e);
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void nextpageOnAction(ActionEvent actionEvent) {



        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("check_salary_info_next_scene02.fxml"));
            Node node=fxmlLoader.load();
            mainpane.getChildren().setAll(node);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}