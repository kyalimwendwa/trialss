package com.example.medica;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

public class ShowPatientInfo extends AppCompatActivity {
    FirebaseDatabase mDatabase, mDatabase1;
    DatabaseReference mRef;
    DatabaseReference mRef1;
    FirebaseStorage mStorage;
    ImageView imaggge;
    EditText status, comment;
    TextView alextextView, bettytextView, cantextView, donetextView, earntextView, fay, doctor, hug;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_patient_info);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String patientname = getIntent().getStringExtra("Patientname");
        String datetime = getIntent().getStringExtra("Datetime");
        String datetime1 = getIntent().getStringExtra("Datetime1");
        String docname = getIntent().getStringExtra("Doctorname");
        String time = getIntent().getStringExtra("Time");
        String patientemail = getIntent().getStringExtra("Patientemail");
        String patientcontact = getIntent().getStringExtra("Patientcontact");
        String purpose = getIntent().getStringExtra("Purpose");
        String image = getIntent().getStringExtra("Image");
        mDatabase = FirebaseDatabase.getInstance();
        mDatabase1 = FirebaseDatabase.getInstance();
        mStorage = FirebaseStorage.getInstance();
        alextextView = findViewById(R.id.showpatientemail);
        alextextView.setKeyListener(null);
        hug = findViewById(R.id.showdatetime1);
        hug.setKeyListener(null);
        bettytextView = findViewById(R.id.showpatientcontact);
        bettytextView.setKeyListener(null);
        cantextView = findViewById(R.id.showpatientname);
        cantextView.setKeyListener(null);
        earntextView = findViewById(R.id.showdatetime);
        earntextView.setKeyListener(null);
        fay = findViewById(R.id.showtime);
        fay.setKeyListener(null);
        doctor = findViewById(R.id.showdoctorname);
        doctor.setKeyListener(null);
        donetextView = findViewById(R.id.showpurpose);
        donetextView.setKeyListener(null);
        status = findViewById(R.id.status);
        comment = findViewById(R.id.comment);
        Button accept = findViewById(R.id.accept);
        Button decline = findViewById(R.id.decline);
        imaggge = findViewById(R.id.showwImage);

        alextextView.setText(patientemail);
        earntextView.setText(datetime);
        bettytextView.setText(patientcontact);
        cantextView.setText(patientname);
        donetextView.setText(purpose);
        fay.setText(time);
        doctor.setText(docname);
        hug.setText(datetime1);


        String imageUri = null;
        imageUri = image;
        Picasso.get().load(imageUri).into(imaggge);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accept.setVisibility(View.INVISIBLE);
                InsertData();
                Intent intent = new Intent(ShowPatientInfo.this, DoctorStartpage.class);
                startActivity(intent);
            }
        });
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InserttData();
                Intent intent = new Intent(ShowPatientInfo.this, DoctorStartpage.class);
                startActivity(intent);
            }
        });
    }

    private void InsertData() {
        String docme = doctor.getText().toString();
        String pemail = alextextView.getText().toString();
        String ptime = earntextView.getText().toString();
        String ptime1 = hug.getText().toString();
        String pime = fay.getText().toString();
        String pcontact = bettytextView.getText().toString();
        String pname = cantextView.getText().toString();
        String pporpose = donetextView.getText().toString();
        String pstatus = status.getText().toString();
        String pcomment = comment.getText().toString();


        if (!(pemail.isEmpty() && ptime.isEmpty() && ptime1.isEmpty() && docme.isEmpty() && pime.isEmpty() && pcontact.isEmpty() && pname.isEmpty() && pporpose.isEmpty() && pstatus.isEmpty() && pcomment.isEmpty())) {
            mRef = mDatabase.getReference().child("Patients Category").child(pname);

            DatabaseReference newpost = mRef.push();
            newpost.child("Age").setValue(pemail);
            newpost.child("Doctor").setValue(docme);
            newpost.child("Date").setValue(ptime);
            newpost.child("Time").setValue(pime);
            newpost.child("Time1").setValue(ptime1);
            newpost.child("Contact").setValue(pcontact);
            newpost.child("Name").setValue(pname);
            newpost.child("Purpose").setValue(pporpose);
            newpost.child("Status").setValue("Appointment confirmed");
            newpost.child("Comment").setValue(pcomment);

        }

    }

    private void InserttData() {
        String docme = doctor.getText().toString();
        String pemail = alextextView.getText().toString();
        String ptime = earntextView.getText().toString();
        String ptime1 = hug.getText().toString();
        String pime = fay.getText().toString();
        String pcontact = bettytextView.getText().toString();
        String pname = cantextView.getText().toString();
        String pporpose = donetextView.getText().toString();
        String pstatus = status.getText().toString();
        String pcomment = comment.getText().toString();


        if (!(pemail.isEmpty() && ptime.isEmpty() && ptime1.isEmpty() && docme.isEmpty() && pime.isEmpty() && pcontact.isEmpty() && pname.isEmpty() && pporpose.isEmpty() && pstatus.isEmpty() && pcomment.isEmpty())) {
            mRef = mDatabase.getReference().child("Patients Category").child(pname);

            DatabaseReference newpost = mRef.push();
            newpost.child("Age").setValue(pemail);
            newpost.child("Doctor").setValue(docme);
            newpost.child("Date").setValue(ptime);
            newpost.child("Time").setValue(pime);
            newpost.child("Time1").setValue(ptime1);
            newpost.child("Contact").setValue(pcontact);
            newpost.child("Name").setValue(pname);
            newpost.child("Purpose").setValue(pporpose);
            newpost.child("Status").setValue("Appointment cancelled");
            newpost.child("Comment").setValue(pcomment);
        }
    }
}