package com.example.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ConfirmAppointment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_appointment);

        String fullname=getIntent().getStringExtra("Fullname");
        String date=getIntent().getStringExtra("Date");




        TextView showfullname=findViewById(R.id.showfullname);
        TextView showdate=findViewById(R.id.showdate);




        showfullname.setText(fullname);
        showdate.setText(date);







    }
}