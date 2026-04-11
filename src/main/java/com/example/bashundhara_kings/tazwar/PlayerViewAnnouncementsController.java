package com.example.bashundhara_kings.tazwar;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerViewAnnouncementsController {

    @FXML private TableView<Announcement> announcementTable;
    @FXML private TableColumn<Announcement, String> announcementIdCol;
    @FXML private TableColumn<Announcement, String> titleCol;
    @FXML private TableColumn<Announcement, String> postedDateCol;
    @FXML private TableColumn<Announcement, String> postedByCol;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "announcements.dat";

    @FXML
    public void initialize() {
        announcementIdCol.setCellValueFactory(new PropertyValueFactory<>("announcementId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        postedDateCol.setCellValueFactory(new PropertyValueFactory<>("postedDate"));
        postedByCol.setCellValueFactory(new PropertyValueFactory<>("postedBy"));

        List<Announcement> announcements = loadFromFile();
        if (announcements.isEmpty()) {
            statusLabel.setText("No announcements found.");
        } else {
            announcementTable.setItems(FXCollections.observableArrayList(announcements));
        }
    }

    @SuppressWarnings("unchecked")
    private List<Announcement> loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Announcement>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
