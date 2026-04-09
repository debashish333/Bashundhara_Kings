package com.example.bashundhara_kings.debashish;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.ArrayList;

public class CheckSalaryInfoNextScene02Controller
{
    @javafx.fxml.FXML
    private AnchorPane mainpane;

    ArrayList<salary>salaryList;
    @javafx.fxml.FXML
    public void initialize() {
        salaryList =new ArrayList<salary>();
        salaryList.add(new salary(221,15000,"kamal", LocalDate.now()));
        salaryList.add(new salary(222,16000,"Rahim", LocalDate.now()));
        salaryList.add(new salary(223,17000,"Karim", LocalDate.now()));
        salaryList.add(new salary(224,18000,"Sakib", LocalDate.now()));
        salaryList.add(new salary(225,19000,"Jamal", LocalDate.now()));
        salaryList.add(new salary(226,20000,"Nayeem", LocalDate.now()));
        salaryList.add(new salary(227,21000,"Hasan", LocalDate.now()));
        salaryList.add(new salary(228,22000,"Rafi", LocalDate.now()));
        salaryList.add(new salary(229,23000,"Sohel", LocalDate.now()));
        salaryList.add(new salary(230,24000,"Tanvir", LocalDate.now()));
        salaryList.add(new salary(555,25555,"Hasibul",LocalDate.now()));

    }

    @javafx.fxml.FXML
    public void loadButtonOnaction(ActionEvent actionEvent) {
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
}