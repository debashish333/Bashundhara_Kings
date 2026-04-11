package com.example.bashundhara_kings.tazwar;

import com.example.bashundhara_kings.tazwar.Message;
import com.example.bashundhara_kings.tazwar.Player;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoachSendMessageController {

    @FXML private ComboBox<String> recipientCombo;
    @FXML private TextField subjectField;
    @FXML private TextArea messageArea;
    @FXML private Label statusLabel;

    private final String PLAYER_FILE = "players.dat";
    private final String MESSAGE_FILE = "messages.dat";

    @FXML
    public void initialize() {
        recipientCombo.getItems().add("Broadcast to All Players");
        List<Player> players = loadPlayers();
        for (Player p : players) {
            recipientCombo.getItems().add(p.getFullName() + " (" + p.getPlayerId() + ")");
        }
    }

    @FXML
    public void sendMessage(ActionEvent event) {
        String recipient = recipientCombo.getValue();
        String subject = subjectField.getText().trim();
        String body = messageArea.getText().trim();

        if (recipient == null) {
            statusLabel.setText("Please select a recipient.");
            return;
        }
        if (subject.isEmpty() || body.isEmpty()) {
            statusLabel.setText("Please fill all required fields.");
            return;
        }

        String msgId = "MSG" + (new Random().nextInt(90000) + 10000);
        Message msg = new Message(msgId, "COACH", recipient, subject, body, LocalDateTime.now());
        saveMessage(msg);
        statusLabel.setText("Message sent successfully!");
        subjectField.clear();
        messageArea.clear();
        recipientCombo.setValue(null);
    }

    private void saveMessage(Message msg) {
        List<Message> messages = loadMessages();
        messages.add(msg);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(MESSAGE_FILE))) {
            out.writeObject(messages);
        } catch (IOException e) { e.printStackTrace(); }
    }

    @SuppressWarnings("unchecked")
    private List<Message> loadMessages() {
        File file = new File(MESSAGE_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(MESSAGE_FILE))) {
            return (List<Message>) in.readObject();
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
}
