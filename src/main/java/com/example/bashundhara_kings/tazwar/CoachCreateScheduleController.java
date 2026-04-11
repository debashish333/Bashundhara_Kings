package com.example.bashundhara_kings.tazwar;

import com.example.bashundhara_kings.tazwar.TrainingSchedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoachCreateScheduleController {

    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TextField startTimeField;
    @javafx.fxml.FXML
    private TextField endTimeField;
    @javafx.fxml.FXML
    private ComboBox<String> trainingTypeCombo;
    @javafx.fxml.FXML
    private TextField venueField;
    @javafx.fxml.FXML
    private TextArea notesArea;
    @javafx.fxml.FXML
    private Label statusLabel;

    private final String FILE_PATH = "training_schedules.dat";

    @javafx.fxml.FXML
    public void initialize() {
        trainingTypeCombo.getItems().addAll("Fitness", "Tactical", "Technical", "Friendly Match");
    }

    @javafx.fxml.FXML
    public void saveSchedule(ActionEvent event) {
        LocalDate date = datePicker.getValue();
        String startTime = startTimeField.getText().trim();
        String endTime = endTimeField.getText().trim();
        String trainingType = trainingTypeCombo.getValue();
        String venue = venueField.getText().trim();
        String notes = notesArea.getText().trim();

        // Validation
        if (date == null || startTime.isEmpty() || endTime.isEmpty() || trainingType == null || venue.isEmpty()) {
            statusLabel.setText("Please fill all required fields.");
            return;
        }
        if (date.isBefore(LocalDate.now())) {
            statusLabel.setText("Date must not be in the past.");
            return;
        }
        if (endTime.compareTo(startTime) <= 0) {
            statusLabel.setText("End time must be after start time.");
            return;
        }
        if (hasConflict(date, startTime)) {
            statusLabel.setText("Schedule conflict: another session exists at this date/time.");
            return;
        }

        String scheduleId = "SCH" + (new Random().nextInt(90000) + 10000);
        TrainingSchedule schedule = new TrainingSchedule(scheduleId, date, startTime, endTime, trainingType, venue, notes, 0);
        saveToFile(schedule);
        statusLabel.setText("Training schedule created successfully!");
    }

    private boolean hasConflict(LocalDate date, String startTime) {
        List<TrainingSchedule> schedules = loadFromFile();
        for (TrainingSchedule s : schedules) {
            if (s.getDate().equals(date) && s.getStartTime().equals(startTime)) return true;
        }
        return false;
    }

    private void saveToFile(TrainingSchedule schedule) {
        List<TrainingSchedule> schedules = loadFromFile();
        schedules.add(schedule);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(schedules);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<TrainingSchedule> loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<TrainingSchedule>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CoachDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
