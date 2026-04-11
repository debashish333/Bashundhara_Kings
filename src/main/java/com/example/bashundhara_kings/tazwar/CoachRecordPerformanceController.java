package controller;

import model.Performance;
import model.Player;
import javafx.collections.FXCollections;
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

public class CoachRecordPerformanceController {

    @FXML private ComboBox<Player> playerCombo;
    @FXML private DatePicker sessionDatePicker;
    @FXML private TextField speedField;
    @FXML private TextField enduranceField;
    @FXML private TextField techniqueField;
    @FXML private TextField teamworkField;
    @FXML private TextArea commentsArea;
    @FXML private Label statusLabel;

    private final String PLAYER_FILE = "players.dat";
    private final String PERFORMANCE_FILE = "performances.dat";

    @FXML
    public void initialize() {
        List<Player> players = loadPlayers();
        playerCombo.setItems(FXCollections.observableArrayList(players));
    }

    @FXML
    public void savePerformance(ActionEvent event) {
        Player selectedPlayer = playerCombo.getValue();
        LocalDate sessionDate = sessionDatePicker.getValue();
        String speedText = speedField.getText().trim();
        String enduranceText = enduranceField.getText().trim();
        String techniqueText = techniqueField.getText().trim();
        String teamworkText = teamworkField.getText().trim();
        String comments = commentsArea.getText().trim();

        if (selectedPlayer == null || sessionDate == null || speedText.isEmpty() ||
                enduranceText.isEmpty() || techniqueText.isEmpty() || teamworkText.isEmpty()) {
            statusLabel.setText("Please fill all required fields.");
            return;
        }
        if (!sessionDate.isBefore(LocalDate.now())) {
            statusLabel.setText("Session date must be a past date.");
            return;
        }

        int speed, endurance, technique, teamwork;
        try {
            speed = Integer.parseInt(speedText);
            endurance = Integer.parseInt(enduranceText);
            technique = Integer.parseInt(techniqueText);
            teamwork = Integer.parseInt(teamworkText);
        } catch (NumberFormatException e) {
            statusLabel.setText("Scores must be numeric values.");
            return;
        }

        if (speed < 1 || speed > 10 || endurance < 1 || endurance > 10 ||
                technique < 1 || technique > 10 || teamwork < 1 || teamwork > 10) {
            statusLabel.setText("All scores must be between 1 and 10.");
            return;
        }

        Performance perf = new Performance(selectedPlayer.getPlayerId(), selectedPlayer.getFullName(),
                sessionDate, "Training", speed, endurance, technique, teamwork, comments);
        saveToFile(perf);
        statusLabel.setText("Performance saved successfully!");
    }

    private void saveToFile(Performance perf) {
        List<Performance> list = loadPerformances();
        list.add(perf);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PERFORMANCE_FILE))) {
            out.writeObject(list);
        } catch (IOException e) { e.printStackTrace(); }
    }

    @SuppressWarnings("unchecked")
    private List<Performance> loadPerformances() {
        File file = new File(PERFORMANCE_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PERFORMANCE_FILE))) {
            return (List<Performance>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    @SuppressWarnings("unchecked")
    private List<Player> loadPlayers() {
        File file = new File(PLAYER_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PLAYER_FILE))) {
            return (List<Player>) in.readObject();
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
