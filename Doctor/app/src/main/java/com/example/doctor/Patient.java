package com.example.doctor;

public class Patient {
    public  Patient(){

    }
    String fullname,email,contact,number,password;

    public Patient(String fullname, String email, String contact, String number, String password) {
        this.fullname = fullname;
        this.email = email;
        this.contact = contact;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
