package com.example.bashundhara_kings.tazwar;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CoachUpdateTrainingPlanController {

    @FXML private TextField planTitleField;
    @FXML private DatePicker datePicker;
    @FXML private TextField startTimeField;
    @FXML private TextField endTimeField;
    @FXML private ComboBox<String> trainingTypeCombo;
    @FXML private TextField venueField;
    @FXML private TextArea drillsArea;
    @FXML private TextArea notesArea;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "training_schedules.dat";

    @FXML
    public void initialize() {
        trainingTypeCombo.getItems().addAll("Fitness", "Tactical", "Technical", "Friendly Match");

        // Pre-load the first schedule for editing if exists
        List<TrainingSchedule> schedules = loadFromFile();
        if (!schedules.isEmpty()) {
            TrainingSchedule s = schedules.get(0);
            datePicker.setValue(s.getDate());
            startTimeField.setText(s.getStartTime());
            endTimeField.setText(s.getEndTime());
            trainingTypeCombo.setValue(s.getTrainingType());
            venueField.setText(s.getVenue());
            notesArea.setText(s.getNotes());
        }
    }

    @FXML
    public void updatePlan(ActionEvent event) {
        String title = planTitleField.getText().trim();
        LocalDate date = datePicker.getValue();
        String startTime = startTimeField.getText().trim();
        String endTime = endTimeField.getText().trim();
        String trainingType = trainingTypeCombo.getValue();
        String venue = venueField.getText().trim();
        String drills = drillsArea.getText().trim();
        String notes = notesArea.getText().trim();

        if (title.isEmpty() || date == null || startTime.isEmpty() || endTime.isEmpty()
                || trainingType == null || venue.isEmpty()) {
            statusLabel.setText("Please fill all required fields.");
            return;
        }
        if (endTime.compareTo(startTime) <= 0) {
            statusLabel.setText("End time must be after start time.");
            return;
        }

        List<TrainingSchedule> schedules = loadFromFile();
        if (!schedules.isEmpty()) {
            TrainingSchedule s = schedules.get(0);
            s.setDate(date);
            s.setStartTime(startTime);
            s.setEndTime(endTime);
            s.setTrainingType(trainingType);
            s.setVenue(venue);
            s.setNotes(notes);
            saveToFile(schedules);
        }
        statusLabel.setText("Training plan updated successfully!");
    }

    private void saveToFile(List<TrainingSchedule> schedules) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(schedules);
        } catch (IOException e) { e.printStackTrace(); }
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
