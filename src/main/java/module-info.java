module com.example.bashundhara_kings {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bashundhara_kings to javafx.fxml;
    opens com.example.bashundhara_kings.debashish to javafx.fxml;
    //opens com.example.bashundhara_kings.debashish to javafx.base;
    opens com.example.bashundhara_kings.nirupama to javafx.fxml;
    opens com.example.bashundhara_kings.nusrat to javafx.fxml;

    exports com.example.bashundhara_kings;
    exports com.example.bashundhara_kings.debashish;
    exports com.example.bashundhara_kings.nirupama;
    exports com.example.bashundhara_kings.nusrat;



}