//package com.example.bashundhara_kings;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//
//public class ApproveEventConroller
//{
//    @javafx.fxml.FXML
//    private ComboBox<String> venueCombobox;
//    @javafx.fxml.FXML
//    private DatePicker date;
//    @javafx.fxml.FXML
//    private ComboBox<String> eventtypeCombobox;
//    @javafx.fxml.FXML
//    private TextField idtextfield;
//    @javafx.fxml.FXML
//    private ComboBox<String> statusCombobox;
//    @javafx.fxml.FXML
//    private TextArea reporttextArea;
//    @javafx.fxml.FXML
//    private Label massaegeLabel;
//    @javafx.fxml.FXML
//    private AnchorPane mainpane;
//
//    ArrayList<Eventmanager>EventmanagerList;
//    @javafx.fxml.FXML
//    public void initialize() {
//        EventmanagerList=new ArrayList<Eventmanager>();
//
//        venueCombobox.getItems().addAll("Kings Arena (Main Stadium)", "Bashundhara Kings Training Ground","Bashundhara Sports Complex - Indoor Arena","Bashundhara Kings Youth Academy Ground","National Stadium, Dhaka (Old Paltan)","Bir Shreshtha Shaheed Shipahi Mostafa Kamal Stadium, Kamalapur");
//        eventtypeCombobox.getItems().addAll("Home Match","Training Session","League Match (BPL)","Federation Cup Match","Jersey Launch");
//
//
//    }
//
//    @javafx.fxml.FXML
//    public void approveButtonOnAction(ActionEvent actionEvent) {
//
//        //String eventType, String description, String venue, String time, Integer eventID, LocalDate eventDate
//        Eventmanager co = new Eventmanager(
//                eventtypeCombobox.getValue(),
//                reporttextArea.getText(),
//                venueCombobox.getValue(),
//
//                Integer.parseInt(idtextfield.getText()),
//                date.getValue()
//        );
//
//        File f =new File("EventApprovalFile,bin");
//        FileOutputStream fos;
//        ObjectOutputStream oos;
//
//         try {
//             if (f.exists()){
//                 fos=new FileOutputStream(f,true);
//                 oos=new AppendableObjectOutputStream(fos);
//             }
//             else {
//                 fos=new FileOutputStream(f);
//                 oos=new ObjectOutputStream(fos);
//             }
//
//             oos.writeObject();
//         }
//
//         catch (Exception e){
//             e.printStackTrace();
//         }
//    }
//
//    @javafx.fxml.FXML
//    public void backbuttonOnAction(ActionEvent actionEvent)throws Exception {
//        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("event_manager_dashboard.fxml"));
//        Node node= fxmlLoader.load();
//        mainpane.getChildren().setAll(node);
//
//
//    }
//
//    @javafx.fxml.FXML
//    public void cencleButtonOnaction(ActionEvent actionEvent) {
//
//    }
//
//    @javafx.fxml.FXML
//    public void verifybuttonOnAction(ActionEvent actionEvent) {
//    }
//}