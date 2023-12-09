package com.example.nuvote;

public class Student {
    private String studentNumber;
    private String email;
    private String password;
    private String status = "Pending";
    public boolean votedPresident = false;
    public boolean votedVicePresident = false;
    public boolean votedSecretary = false;
    public boolean votedTreasurer = false;
    public boolean votedPIO = false;
    public boolean votedAuditor = false;


    public Student(String studentNumber, String email, String password) {
        this.studentNumber = studentNumber;
        this.email = email;
        this.password = password;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVotedPresident() {
        return votedPresident;
    }

    public void setVotedPresident(boolean votedPresident) {
        this.votedPresident = votedPresident;
    }

    public boolean isVotedVicePresident() {
        return votedVicePresident;
    }

    public void setVotedVicePresident(boolean votedVicePresident) {
        this.votedVicePresident = votedVicePresident;
    }

    public boolean isVotedSecretary() {
        return votedSecretary;
    }

    public void setVotedSecretary(boolean votedSecretary) {
        this.votedSecretary = votedSecretary;
    }

    public boolean isVotedTreasurer() {
        return votedTreasurer;
    }

    public void setVotedTreasurer(boolean votedTreasurer) {
        this.votedTreasurer = votedTreasurer;
    }

    public boolean isVotedPIO() {
        return votedPIO;
    }

    public void setVotedPIO(boolean votedPIO) {
        this.votedPIO = votedPIO;
    }

    public boolean isVotedAuditor() {
        return votedAuditor;
    }

    public void setVotedAuditor(boolean votedAuditor) {
        this.votedAuditor = votedAuditor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
