package com.example.bashundhara_kings.tazwar;

import com.example.bashundhara_kings.tazwar.Player;
import com.example.bashundhara_kings.tazwar.TrainingSchedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoachAssignPlayersController {

    @FXML private TableView<TrainingSchedule> sessionTable;
    @FXML private TableColumn<TrainingSchedule, String> sessionIdCol;
    @FXML private TableColumn<TrainingSchedule, String> sessionDateCol;
    @FXML private TableColumn<TrainingSchedule, String> trainingTypeCol;
    @FXML private TableColumn<TrainingSchedule, String> venueCol;
    @FXML private TableColumn<TrainingSchedule, Integer> assignedCountCol;
    @FXML private ListView<Player> playerListView;
    @FXML private Label statusLabel;

    private final String SCHEDULE_FILE = "training_schedules.dat";
    private final String PLAYER_FILE = "players.dat";
    private static final int MAX_CAPACITY = 20;

    @FXML
    public void initialize() {
        sessionIdCol.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        sessionDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        trainingTypeCol.setCellValueFactory(new PropertyValueFactory<>("trainingType"));
        venueCol.setCellValueFactory(new PropertyValueFactory<>("venue"));
        assignedCountCol.setCellValueFactory(new PropertyValueFactory<>("assignedPlayers"));

        List<TrainingSchedule> schedules = loadSchedules();
        sessionTable.setItems(FXCollections.observableArrayList(schedules));

        List<Player> players = loadPlayers();
        playerListView.setItems(FXCollections.observableArrayList(players));
        playerListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    public void assignPlayers(ActionEvent event) {
        TrainingSchedule selectedSession = sessionTable.getSelectionModel().getSelectedItem();
        List<Player> selectedPlayers = playerListView.getSelectionModel().getSelectedItems();

        if (selectedSession == null) {
            statusLabel.setText("Please select a training session.");
            return;
        }
        if (selectedPlayers.isEmpty()) {
            statusLabel.setText("Please select at least one player.");
            return;
        }
        if (selectedSession.getAssignedPlayers() + selectedPlayers.size() > MAX_CAPACITY) {
            statusLabel.setText("Cannot assign: session would exceed maximum capacity of " + MAX_CAPACITY + ".");
            return;
        }

        selectedSession.setAssignedPlayers(selectedSession.getAssignedPlayers() + selectedPlayers.size());
        saveSchedules(loadSchedules());
        statusLabel.setText("Players assigned successfully to session " + selectedSession.getScheduleId() + ".");
        sessionTable.refresh();
    }

    @SuppressWarnings("unchecked")
    private List<TrainingSchedule> loadSchedules() {
        File file = new File(SCHEDULE_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SCHEDULE_FILE))) {
            return (List<TrainingSchedule>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    private void saveSchedules(List<TrainingSchedule> schedules) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SCHEDULE_FILE))) {
            out.writeObject(schedules);
        } catch (IOException e) { e.printStackTrace(); }
    }

    @SuppressWarnings("unchecked")
    private List<Player> loadPlayers() {
        File file = new File(PLAYER_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PLAYER_FILE))) {
            return (List<Player>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
