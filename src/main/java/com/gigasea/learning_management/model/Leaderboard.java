package com.gigasea.learning_management.model;
public class Leaderboard {
    private Long studentId;
    private String firstname;
    private String lastname;
    private String email; // Optional
    private int totalScore;
    private int rank;

    // Constructors
    public Leaderboard(Long studentId, String firstname, String lastname, int totalScore, int rank) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalScore = totalScore;
        this.rank = rank;
    }

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
