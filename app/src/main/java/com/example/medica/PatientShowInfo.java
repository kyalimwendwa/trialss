package com.example.medica;

public class PatientShowInfo {
    String Age,Time,Time1,Contact,Name,Purpose,Status,Comment,Doctor,Date;
    public PatientShowInfo() {
    }

    public PatientShowInfo(String age, String time, String time1, String contact, String name, String purpose, String status, String comment, String doctor, String date) {
        Age = age;
        Time = time;
        Time1 = time1;
        Contact = contact;
        Name = name;
        Purpose = purpose;
        Status = status;
        Comment = comment;
        Doctor = doctor;
        Date = date;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTime1() {
        return Time1;
    }

    public void setTime1(String time1) {
        Time1 = time1;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
