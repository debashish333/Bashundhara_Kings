package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Player implements Serializable {
    private String playerId;
    private String fullName;
    private int age;
    private String position;
    private String contactNumber;
    private String email;
    private double attendanceRate;
    private LocalDate dateOfBirth;
    private String emergencyContactName;
    private String emergencyContactNumber;

    public Player(String playerId, String fullName, int age, String position,
                  String contactNumber, String email, double attendanceRate) {
        this.playerId = playerId;
        this.fullName = fullName;
        this.age = age;
        this.position = position;
        this.contactNumber = contactNumber;
        this.email = email;
        this.attendanceRate = attendanceRate;
    }

    public String getPlayerId() { return playerId; }
    public void setPlayerId(String playerId) { this.playerId = playerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getAttendanceRate() { return attendanceRate; }
    public void setAttendanceRate(double attendanceRate) { this.attendanceRate = attendanceRate; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getEmergencyContactName() { return emergencyContactName; }
    public void setEmergencyContactName(String emergencyContactName) { this.emergencyContactName = emergencyContactName; }

    public String getEmergencyContactNumber() { return emergencyContactNumber; }
    public void setEmergencyContactNumber(String emergencyContactNumber) { this.emergencyContactNumber = emergencyContactNumber; }

    @Override
    public String toString() {
        return fullName + " (" + playerId + ")";
    }
}
