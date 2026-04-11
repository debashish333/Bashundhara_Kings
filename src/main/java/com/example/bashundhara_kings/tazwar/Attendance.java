package com.example.bashundhara_kings.tazwar;

import java.io.Serializable;
import java.time.LocalDate;

public class Attendance implements Serializable {
    private String playerId;
    private String playerName;
    private LocalDate sessionDate;
    private String sessionType;
    private String status; // Present / Absent / Late
    private double attendancePercentage;

    public Attendance(String playerId, String playerName, LocalDate sessionDate,
                      String sessionType, String status, double attendancePercentage) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.sessionDate = sessionDate;
        this.sessionType = sessionType;
        this.status = status;
        this.attendancePercentage = attendancePercentage;
    }

    public String getPlayerId() { return playerId; }
    public void setPlayerId(String playerId) { this.playerId = playerId; }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public LocalDate getSessionDate() { return sessionDate; }
    public void setSessionDate(LocalDate sessionDate) { this.sessionDate = sessionDate; }

    public String getSessionType() { return sessionType; }
    public void setSessionType(String sessionType) { this.sessionType = sessionType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getAttendancePercentage() { return attendancePercentage; }
    public void setAttendancePercentage(double attendancePercentage) { this.attendancePercentage = attendancePercentage; }
}
