package com.example.doctor;

public class CardiologyDoctorModel {
    String Fullname,Department,Time1,Time2,Time3,Date;
    String Image;
    public CardiologyDoctorModel(){

    }

    public CardiologyDoctorModel(String fullname, String department, String time1, String time2, String time3, String date, String image) {
        Fullname = fullname;
        Department = department;
        Time1 = time1;
        Time2 = time2;
        Time3 = time3;
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

    public String getTime3() {
        return Time3;
    }

    public void setTime3(String time3) {
        Time3 = time3;
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
