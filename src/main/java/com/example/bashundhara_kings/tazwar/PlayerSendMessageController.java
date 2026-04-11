package com.example.bashundhara_kings.tazwar;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerSendMessageController {

    @FXML private Label coachNameLabel;
    @FXML private TextField subjectField;
    @FXML private TextArea messageArea;
    @FXML private Label statusLabel;

    private final String MESSAGE_FILE = "messages.dat";

    // In a real app these come from session/singleton
    private final String CURRENT_PLAYER_ID = "P001";
    private final String COACH_ID = "COACH001";
    private final String COACH_NAME = "Coach Ahmed";

    @FXML
    public void initialize() {
        coachNameLabel.setText(COACH_NAME);
    }

    @FXML
    public void sendMessage(ActionEvent event) {
        String subject = subjectField.getText().trim();
        String body = messageArea.getText().trim();

        if (subject.isEmpty()) {
            statusLabel.setText("Subject must not be blank.");
            return;
        }
        if (body.isEmpty()) {
            statusLabel.setText("Message body must not be blank.");
            return;
        }

        String msgId = "MSG" + (new Random().nextInt(90000) + 10000);
        Message msg = new Message(msgId, CURRENT_PLAYER_ID, COACH_ID, subject, body, LocalDateTime.now());
        saveMessage(msg);

        statusLabel.setText("Message sent to coach successfully!");
        subjectField.clear();
        messageArea.clear();
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
}
