package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class check_salary_infoController
{


    @javafx.fxml.FXML
    private TextField guardIDtextfield;
    @javafx.fxml.FXML
    private TextField passwprdtextfield;
    @javafx.fxml.FXML
    private TextField gueadsname;
    @javafx.fxml.FXML
    private Label messgelabel;
    @javafx.fxml.FXML
    private AnchorPane mainpane;
    ArrayList<Securityguard>SecurityguardList;
    @javafx.fxml.FXML
    private Label MessageLabell;

    @javafx.fxml.FXML
    public void initialize() {


    }
    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent)throws Exception{
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("security_guard_dashbord.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void verificationandNextsceneButtonOnActoin(ActionEvent actionEvent) {

        if (guardIDtextfield.getText()==null || gueadsname.getText()==null ||passwprdtextfield.getText()==null) {
            erroralert("Please fill all the fields.");
            return;
        }


        else {
            MessageLabell.setText("Verification Successful now you can go to the next page!!");
        }


    }

    @javafx.fxml.FXML
    public void nextpageOnAction(ActionEvent actionEvent) throws Exception{


        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("check_salary_info_next_scene02.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }

    public void erroralert(String e){
        Alert a=new Alert(Alert.AlertType.WARNING);
        a.setContentText(e);
        a.showAndWait();
    }
}