module com.example.bashundhara_kings {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bashundhara_kings to javafx.fxml;
    exports com.example.bashundhara_kings;

}