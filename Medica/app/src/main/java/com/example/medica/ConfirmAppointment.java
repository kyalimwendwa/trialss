package com.example.medica;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class ConfirmAppointment extends AppCompatActivity{
    EditText doctorname,patientname,patientemail,patientcontact,purpose,datetime;
    Button regBtn;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_appointment);
        doctorname=findViewById(R.id.doctorfullname);
        purpose=findViewById(R.id.purpose);
        datetime=findViewById(R.id.datetime);
        patientname=findViewById(R.id.patientfullname);
        patientemail=findViewById(R.id.patientemail);
        patientcontact=findViewById(R.id.patientcontact);
        regBtn=findViewById(R.id.buttonConfirm);
        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference();
        mStorage=FirebaseStorage.getInstance();



}

}