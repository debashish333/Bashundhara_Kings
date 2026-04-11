package com.example.bashundhara_kings.tazwar;

import com.example.bashundhara_kings.tazwar.TrainingSchedule;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoachViewScheduleController {

    @FXML private TableView<TrainingSchedule> scheduleTable;
    @FXML private TableColumn<TrainingSchedule, String> scheduleIdCol;
    @FXML private TableColumn<TrainingSchedule, String> dateCol;
    @FXML private TableColumn<TrainingSchedule, String> timeRangeCol;
    @FXML private TableColumn<TrainingSchedule, String> trainingTypeCol;
    @FXML private TableColumn<TrainingSchedule, String> venueCol;
    @FXML private TableColumn<TrainingSchedule, Integer> assignedPlayersCol;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "training_schedules.dat";

    @FXML
    public void initialize() {
        scheduleIdCol.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeRangeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        trainingTypeCol.setCellValueFactory(new PropertyValueFactory<>("trainingType"));
        venueCol.setCellValueFactory(new PropertyValueFactory<>("venue"));
        assignedPlayersCol.setCellValueFactory(new PropertyValueFactory<>("assignedPlayers"));

        List<TrainingSchedule> schedules = loadFromFile();
        if (schedules.isEmpty()) {
            statusLabel.setText("No training schedules found.");
        } else {
            scheduleTable.setItems(FXCollections.observableArrayList(schedules));
        }
    }

    @SuppressWarnings("unchecked")
    private List<TrainingSchedule> loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<TrainingSchedule>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
