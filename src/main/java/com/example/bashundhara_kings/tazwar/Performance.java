package com.example.bashundhara_kings.tazwar;
import java.io.Serializable;
import java.time.LocalDate;

public class Performance implements Serializable {
    private String playerId;
    private String playerName;
    private LocalDate sessionDate;
    private String trainingType;
    private int speedScore;
    private int enduranceScore;
    private int techniqueScore;
    private int teamworkScore;
    private String comments;

    public Performance(String playerId, String playerName, LocalDate sessionDate, String trainingType,
                       int speedScore, int enduranceScore, int techniqueScore, int teamworkScore, String comments) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.sessionDate = sessionDate;
        this.trainingType = trainingType;
        this.speedScore = speedScore;
        this.enduranceScore = enduranceScore;
        this.techniqueScore = techniqueScore;
        this.teamworkScore = teamworkScore;
        this.comments = comments;
    }

    public String getPlayerId() { return playerId; }
    public void setPlayerId(String playerId) { this.playerId = playerId; }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public LocalDate getSessionDate() { return sessionDate; }
    public void setSessionDate(LocalDate sessionDate) { this.sessionDate = sessionDate; }

    public String getTrainingType() { return trainingType; }
    public void setTrainingType(String trainingType) { this.trainingType = trainingType; }

    public int getSpeedScore() { return speedScore; }
    public void setSpeedScore(int speedScore) { this.speedScore = speedScore; }

    public int getEnduranceScore() { return enduranceScore; }
    public void setEnduranceScore(int enduranceScore) { this.enduranceScore = enduranceScore; }

    public int getTechniqueScore() { return techniqueScore; }
    public void setTechniqueScore(int techniqueScore) { this.techniqueScore = techniqueScore; }

    public int getTeamworkScore() { return teamworkScore; }
    public void setTeamworkScore(int teamworkScore) { this.teamworkScore = teamworkScore; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
}
