package com.example.medica;

public class PatientInfo {
    String Doctorname,Purpose,Datetime,Datetime1,Time,Patientname,Patientemail,Patientcontact,Image;
    public PatientInfo() {
    }

    public PatientInfo(String doctorname, String purpose, String datetime, String datetime1, String time, String patientname, String patientemail, String patientcontact, String image) {
        Doctorname = doctorname;
        Purpose = purpose;
        Datetime = datetime;
        Datetime1 = datetime1;
        Time = time;
        Patientname = patientname;
        Patientemail = patientemail;
        Patientcontact = patientcontact;
        Image = image;
    }

    public String getDoctorname() {
        return Doctorname;
    }

    public void setDoctorname(String doctorname) {
        Doctorname = doctorname;
    }

    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }

    public String getDatetime() {
        return Datetime;
    }

    public void setDatetime(String datetime) {
        Datetime = datetime;
    }

    public String getDatetime1() {
        return Datetime1;
    }

    public void setDatetime1(String datetime1) {
        Datetime1 = datetime1;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPatientname() {
        return Patientname;
    }

    public void setPatientname(String patientname) {
        Patientname = patientname;
    }

    public String getPatientemail() {
        return Patientemail;
    }

    public void setPatientemail(String patientemail) {
        Patientemail = patientemail;
    }

    public String getPatientcontact() {
        return Patientcontact;
    }

    public void setPatientcontact(String patientcontact) {
        Patientcontact = patientcontact;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
