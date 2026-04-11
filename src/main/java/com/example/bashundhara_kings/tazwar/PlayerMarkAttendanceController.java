package controller;

import model.Attendance;
import model.TrainingSchedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerMarkAttendanceController {

    @FXML private Label todayDateLabel;
    @FXML private Label sessionLabel;
    @FXML private Label eligibilityLabel;
    @FXML private Button presentButton;
    @FXML private Label statusLabel;

    private final String SCHEDULE_FILE = "training_schedules.dat";
    private final String ATTENDANCE_FILE = "attendance.dat";

    // In a real app this comes from a session/singleton
    private final String CURRENT_PLAYER_ID = "P001";
    private final String CURRENT_PLAYER_NAME = "Player One";

    private TrainingSchedule todaySession = null;

    @FXML
    public void initialize() {
        LocalDate today = LocalDate.now();
        todayDateLabel.setText(today.toString());

        todaySession = findTodaySession(today);

        if (todaySession == null) {
            sessionLabel.setText("No session scheduled today.");
            eligibilityLabel.setText("Not eligible to mark attendance.");
            presentButton.setDisable(true);
            return;
        }

        sessionLabel.setText(todaySession.getTrainingType() + " at " + todaySession.getVenue());

        if (alreadyMarked(today)) {
            eligibilityLabel.setText("Attendance already marked for today.");
            presentButton.setDisable(true);
        } else {
            eligibilityLabel.setText("You may mark your attendance now.");
            presentButton.setDisable(false);
        }
    }

    @FXML
    public void markPresent(ActionEvent event) {
        if (todaySession == null) {
            statusLabel.setText("No active session available for attendance marking.");
            return;
        }

        Attendance record = new Attendance(
                CURRENT_PLAYER_ID,
                CURRENT_PLAYER_NAME,
                LocalDate.now(),
                todaySession.getTrainingType(),
                "Present",
                100.0
        );
        saveAttendance(record);
        statusLabel.setText("Attendance marked successfully!");
        presentButton.setDisable(true);
        eligibilityLabel.setText("Attendance already marked for today.");
    }

    private boolean alreadyMarked(LocalDate today) {
        List<Attendance> records = loadAttendance();
        return records.stream().anyMatch(a ->
                a.getPlayerId().equals(CURRENT_PLAYER_ID) && a.getSessionDate().equals(today));
    }

    private TrainingSchedule findTodaySession(LocalDate today) {
        List<TrainingSchedule> schedules = loadSchedules();
        return schedules.stream()
                .filter(s -> s.getDate().equals(today))
                .findFirst()
                .orElse(null);
    }

    private void saveAttendance(Attendance record) {
        List<Attendance> records = loadAttendance();
        records.add(record);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ATTENDANCE_FILE))) {
            out.writeObject(records);
        } catch (IOException e) { e.printStackTrace(); }
    }

    @SuppressWarnings("unchecked")
    private List<Attendance> loadAttendance() {
        File file = new File(ATTENDANCE_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ATTENDANCE_FILE))) {
            return (List<Attendance>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    @SuppressWarnings("unchecked")
    private List<TrainingSchedule> loadSchedules() {
        File file = new File(SCHEDULE_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SCHEDULE_FILE))) {
            return (List<TrainingSchedule>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PlayerDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
