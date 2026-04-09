package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    public void initialize() {
//        SecurityguardList =new ArrayList<Securityguard>();
//
//        SecurityguardList


    }
    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent)throws Exception{
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("security_guard_dashbord.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }

    @javafx.fxml.FXML
    public void verificationandNextsceneButtonOnActoin(ActionEvent actionEvent) {



    }

    @javafx.fxml.FXML
    public void nextpageOnAction(ActionEvent actionEvent) throws Exception{


        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("check_salary_info_next_scene02.fxml"));
        Node node=fxmlLoader.load();
        mainpane.getChildren().setAll(node);
    }
}