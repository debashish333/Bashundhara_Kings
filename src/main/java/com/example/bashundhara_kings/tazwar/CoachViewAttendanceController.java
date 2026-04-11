package com.example.bashundhara_kings.tazwar;

import com.example.bashundhara_kings.tazwar.Attendance;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoachViewAttendanceController {

    @FXML private TableView<Attendance> attendanceTable;
    @FXML private TableColumn<Attendance, String> playerIdCol;
    @FXML private TableColumn<Attendance, String> playerNameCol;
    @FXML private TableColumn<Attendance, String> sessionDateCol;
    @FXML private TableColumn<Attendance, String> sessionTypeCol;
    @FXML private TableColumn<Attendance, String> statusCol;
    @FXML private TableColumn<Attendance, Double> attendancePctCol;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "attendance.dat";

    @FXML
    public void initialize() {
        playerIdCol.setCellValueFactory(new PropertyValueFactory<>("playerId"));
        playerNameCol.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        sessionDateCol.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));
        sessionTypeCol.setCellValueFactory(new PropertyValueFactory<>("sessionType"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        attendancePctCol.setCellValueFactory(new PropertyValueFactory<>("attendancePercentage"));

        List<Attendance> records = loadFromFile();
        if (records.isEmpty()) {
            statusLabel.setText("No attendance records found.");
        } else {
            attendanceTable.setItems(FXCollections.observableArrayList(records));
        }
    }

    @SuppressWarnings("unchecked")
    private List<Attendance> loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Attendance>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CoachDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
