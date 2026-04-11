package com.example.bashundhara_kings.tazwar;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerUpdateProfileController {

    @FXML private TextField fullNameField;
    @FXML private DatePicker dobPicker;
    @FXML private TextField contactField;
    @FXML private TextField emailField;
    @FXML private ComboBox<String> positionCombo;
    @FXML private TextField emergencyNameField;
    @FXML private TextField emergencyContactField;
    @FXML private Label statusLabel;

    private final String FILE_PATH = "players.dat";

    // In a real app this comes from a session/singleton
    private final String CURRENT_PLAYER_ID = "P001";

    @FXML
    public void initialize() {
        positionCombo.getItems().addAll("Forward", "Midfielder", "Defender", "Goalkeeper", "Winger", "Striker");

        // Pre-load existing profile data
        Player current = loadCurrentPlayer();
        if (current != null) {
            fullNameField.setText(current.getFullName());
            contactField.setText(current.getContactNumber());
            emailField.setText(current.getEmail());
            positionCombo.setValue(current.getPosition());
            if (current.getDateOfBirth() != null) dobPicker.setValue(current.getDateOfBirth());
            if (current.getEmergencyContactName() != null) emergencyNameField.setText(current.getEmergencyContactName());
            if (current.getEmergencyContactNumber() != null) emergencyContactField.setText(current.getEmergencyContactNumber());
        }
    }

    @FXML
    public void saveChanges(ActionEvent event) {
        String fullName = fullNameField.getText().trim();
        LocalDate dob = dobPicker.getValue();
        String contact = contactField.getText().trim();
        String email = emailField.getText().trim();
        String position = positionCombo.getValue();
        String emergencyName = emergencyNameField.getText().trim();
        String emergencyContact = emergencyContactField.getText().trim();

        if (fullName.isEmpty() || dob == null || contact.isEmpty() || email.isEmpty() || position == null) {
            statusLabel.setText("Please fill all required fields.");
            return;
        }
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            statusLabel.setText("Invalid email format.");
            return;
        }
        if (!contact.matches("\\d{11}")) {
            statusLabel.setText("Contact number must be 11 digits.");
            return;
        }
        if (dob.isAfter(LocalDate.now())) {
            statusLabel.setText("Date of birth must be a past date.");
            return;
        }

        List<Player> players = loadAllPlayers();
        boolean updated = false;
        for (Player p : players) {
            if (p.getPlayerId().equals(CURRENT_PLAYER_ID)) {
                p.setFullName(fullName);
                p.setDateOfBirth(dob);
                p.setContactNumber(contact);
                p.setEmail(email);
                p.setPosition(position);
                p.setEmergencyContactName(emergencyName);
                p.setEmergencyContactNumber(emergencyContact);
                updated = true;
                break;
            }
        }

        if (!updated) {
            // First time saving — create new player entry
            Player newPlayer = new Player(CURRENT_PLAYER_ID, fullName, 0, position, contact, email, 0);
            newPlayer.setDateOfBirth(dob);
            newPlayer.setEmergencyContactName(emergencyName);
            newPlayer.setEmergencyContactNumber(emergencyContact);
            players.add(newPlayer);
        }

        saveAllPlayers(players);
        statusLabel.setText("Profile updated successfully!");
    }

    private Player loadCurrentPlayer() {
        return loadAllPlayers().stream()
                .filter(p -> p.getPlayerId().equals(CURRENT_PLAYER_ID))
                .findFirst().orElse(null);
    }

    @SuppressWarnings("unchecked")
    private List<Player> loadAllPlayers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Player>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    private void saveAllPlayers(List<Player> players) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(players);
        } catch (IOException e) { e.printStackTrace(); }
    }
}
