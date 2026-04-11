package model;

import java.io.Serializable;
import java.time.LocalDate;

public class TrainingSchedule implements Serializable {
    private String scheduleId;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private String trainingType;
    private String venue;
    private String notes;
    private int assignedPlayers;

    public TrainingSchedule(String scheduleId, LocalDate date, String startTime, String endTime,
                            String trainingType, String venue, String notes, int assignedPlayers) {
        this.scheduleId = scheduleId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.trainingType = trainingType;
        this.venue = venue;
        this.notes = notes;
        this.assignedPlayers = assignedPlayers;
    }

    public String getScheduleId() { return scheduleId; }
    public void setScheduleId(String scheduleId) { this.scheduleId = scheduleId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getTrainingType() { return trainingType; }
    public void setTrainingType(String trainingType) { this.trainingType = trainingType; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public int getAssignedPlayers() { return assignedPlayers; }
    public void setAssignedPlayers(int assignedPlayers) { this.assignedPlayers = assignedPlayers; }

    @Override
    public String toString() {
        return "TrainingSchedule{scheduleId='" + scheduleId + "', date=" + date +
                ", startTime='" + startTime + "', endTime='" + endTime +
                "', trainingType='" + trainingType + "', venue='" + venue + "'}";
    }
}
