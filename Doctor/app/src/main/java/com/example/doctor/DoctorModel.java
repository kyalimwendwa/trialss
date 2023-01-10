package com.example.doctor;

import android.graphics.Bitmap;

public class DoctorModel {
    String Fullname,Email,Contact,Department;
    String Image;

    public DoctorModel(){

    }

    public DoctorModel(String fullname, String email, String contact, String department, String image) {
        Fullname = fullname;
        Email = email;
        Contact = contact;
        Department = department;
        Image = image;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
