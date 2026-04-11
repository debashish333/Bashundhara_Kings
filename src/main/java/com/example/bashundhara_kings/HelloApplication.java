package com.example.bashundhara_kings;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class  HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/bashundhara_kings/debashish/security_guard_dashbord.fxml"));
=======
<<<<<<< HEAD
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/bashundhara_kings/CoachDashboard.fxml"));
=======
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/bashundhara_kings/debashish/event_manager_dashboard.fxml"));
>>>>>>> 72d5d00eb621fa869391f5e1bc70a44fde1382f6
>>>>>>> a5af0069e80a739c877fbe51759d6b4d6a17dfc5
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("BASHUNDHARA KINGS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}