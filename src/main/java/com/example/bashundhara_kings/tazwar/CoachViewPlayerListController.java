package controller;

import model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoachViewPlayerListController {

    @FXML private TableView<Player> playerTable;
    @FXML private TableColumn<Player, String> playerIdCol;
    @FXML private TableColumn<Player, String> fullNameCol;
    @FXML private TableColumn<Player, Integer> ageCol;
    @FXML private TableColumn<Player, String> positionCol;
    @FXML private TableColumn<Player, String> contactCol;
    @FXML private TableColumn<Player, String> emailCol;
    @FXML private TableColumn<Player, Double> attendanceCol;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "players.dat";

    @FXML
    public void initialize() {
        playerIdCol.setCellValueFactory(new PropertyValueFactory<>("playerId"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        attendanceCol.setCellValueFactory(new PropertyValueFactory<>("attendanceRate"));

        List<Player> players = loadFromFile();
        if (players.isEmpty()) {
            statusLabel.setText("No players found.");
        } else {
            ObservableList<Player> data = FXCollections.observableArrayList(players);
            playerTable.setItems(data);
        }
    }

    @SuppressWarnings("unchecked")
    private List<Player> loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Player>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CoachDashboard.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
