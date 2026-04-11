package com.example.bashundhara_kings.tazwar;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerViewPerformanceController {

    @FXML private TableView<Performance> performanceTable;
    @FXML private TableColumn<Performance, String> sessionDateCol;
    @FXML private TableColumn<Performance, String> trainingTypeCol;
    @FXML private TableColumn<Performance, Integer> speedCol;
    @FXML private TableColumn<Performance, Integer> enduranceCol;
    @FXML private TableColumn<Performance, Integer> techniqueCol;
    @FXML private TableColumn<Performance, Integer> teamworkCol;
    @FXML private TableColumn<Performance, String> commentsCol;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "performances.dat";

    // In a real app, logged-in player ID would come from a session/singleton
    private final String CURRENT_PLAYER_ID = "P001";

    @FXML
    public void initialize() {
        sessionDateCol.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));
        trainingTypeCol.setCellValueFactory(new PropertyValueFactory<>("trainingType"));
        speedCol.setCellValueFactory(new PropertyValueFactory<>("speedScore"));
        enduranceCol.setCellValueFactory(new PropertyValueFactory<>("enduranceScore"));
        techniqueCol.setCellValueFactory(new PropertyValueFactory<>("techniqueScore"));
        teamworkCol.setCellValueFactory(new PropertyValueFactory<>("teamworkScore"));
        commentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));

        List<Performance> all = loadFromFile();
        List<Performance> mine = all.stream()
                .filter(p -> p.getPlayerId().equals(CURRENT_PLAYER_ID))
                .collect(Collectors.toList());

        if (mine.isEmpty()) {
            statusLabel.setText("No performance records found.");
        } else {
            performanceTable.setItems(FXCollections.observableArrayList(mine));
        }
    }

    @SuppressWarnings("unchecked")
    private List<Performance> loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Performance>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
