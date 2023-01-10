package com.example.medica;

public class DoctorModel {
    String Fullname,Email,Contact,Department,Biography,Experience,Patients;
    String Image;

    public DoctorModel(){

    }

    public DoctorModel(String fullname, String email, String contact, String department, String biography, String experience, String patients, String image) {
        Fullname = fullname;
        Email = email;
        Contact = contact;
        Department = department;
        Biography = biography;
        Experience = experience;
        Patients = patients;
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

    public String getBiography() {
        return Biography;
    }

    public void setBiography(String biography) {
        Biography = biography;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getPatients() {
        return Patients;
    }

    public void setPatients(String patients) {
        Patients = patients;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
