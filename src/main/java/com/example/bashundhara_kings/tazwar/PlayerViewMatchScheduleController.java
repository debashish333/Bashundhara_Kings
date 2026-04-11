package com.example.bashundhara_kings.tazwar;

import com.example.bashundhara_kings.tazwar.MatchSchedule;
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

public class PlayerViewMatchScheduleController {

    @FXML private TableView<MatchSchedule> matchTable;
    @FXML private TableColumn<MatchSchedule, String> matchIdCol;
    @FXML private TableColumn<MatchSchedule, String> dateTimeCol;
    @FXML private TableColumn<MatchSchedule, String> opponentCol;
    @FXML private TableColumn<MatchSchedule, String> venueCol;
    @FXML private TableColumn<MatchSchedule, String> matchTypeCol;
    @FXML private TableColumn<MatchSchedule, String> resultCol;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "match_schedules.dat";

    @FXML
    public void initialize() {
        matchIdCol.setCellValueFactory(new PropertyValueFactory<>("matchId"));
        dateTimeCol.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
        opponentCol.setCellValueFactory(new PropertyValueFactory<>("opponentTeam"));
        venueCol.setCellValueFactory(new PropertyValueFactory<>("venue"));
        matchTypeCol.setCellValueFactory(new PropertyValueFactory<>("matchType"));
        resultCol.setCellValueFactory(new PropertyValueFactory<>("result"));

        List<MatchSchedule> matches = loadFromFile();
        if (matches.isEmpty()) {
            statusLabel.setText("No match schedules found.");
        } else {
            matchTable.setItems(FXCollections.observableArrayList(matches));
        }
    }

    @SuppressWarnings("unchecked")
    private List<MatchSchedule> loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<MatchSchedule>) in.readObject();
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
