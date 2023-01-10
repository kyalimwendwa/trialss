package com.example.doctor;

public class Doctor {
    String fullname,email,contact,password;
    public  Doctor(){

    }

    public Doctor(String fullname, String email, String contact, String password) {
        this.fullname = fullname;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
