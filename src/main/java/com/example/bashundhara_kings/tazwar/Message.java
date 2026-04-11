package com.example.bashundhara_kings.tazwar;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String messageId;
    private String senderId;
    private String recipientId; // player ID or "ALL"
    private String subject;
    private String body;
    private LocalDateTime sentAt;

    public Message(String messageId, String senderId, String recipientId,
                   String subject, String body, LocalDateTime sentAt) {
        this.messageId = messageId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.subject = subject;
        this.body = body;
        this.sentAt = sentAt;
    }

    public String getMessageId() { return messageId; }
    public void setMessageId(String messageId) { this.messageId = messageId; }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getRecipientId() { return recipientId; }
    public void setRecipientId(String recipientId) { this.recipientId = recipientId; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public LocalDateTime getSentAt() { return sentAt; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
}
