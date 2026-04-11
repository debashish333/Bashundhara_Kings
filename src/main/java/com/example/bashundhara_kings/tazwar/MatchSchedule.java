package com.example.bashundhara_kings.tazwar;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MatchSchedule implements Serializable {
    private String matchId;
    private LocalDateTime dateTime;
    private String opponentTeam;
    private String venue; // Home / Away
    private String matchType; // Friendly / League / Cup
    private String result; // Win / Loss / Draw / TBD

    public MatchSchedule(String matchId, LocalDateTime dateTime, String opponentTeam,
                         String venue, String matchType, String result) {
        this.matchId = matchId;
        this.dateTime = dateTime;
        this.opponentTeam = opponentTeam;
        this.venue = venue;
        this.matchType = matchType;
        this.result = result;
    }

    public String getMatchId() { return matchId; }
    public void setMatchId(String matchId) { this.matchId = matchId; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getOpponentTeam() { return opponentTeam; }
    public void setOpponentTeam(String opponentTeam) { this.opponentTeam = opponentTeam; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
}
