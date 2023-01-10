package com.example.doctor;

public class Appoint {
    String Fullname,Department,Time,Time1,Time2,Date;
    String Image;
    public Appoint(){

    }

    public Appoint(String fullname, String department, String time, String time1, String time2, String date, String image) {
        Fullname = fullname;
        Department = department;
        Time = time;
        Time1 = time1;
        Time2 = time2;
        Date = date;
        Image = image;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
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

    public String getTime2() {
        return Time2;
    }

    public void setTime2(String time2) {
        Time2 = time2;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
