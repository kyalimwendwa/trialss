package com.example.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.time.OffsetDateTime;

public class Book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        TextView textView = findViewById(R.id.date);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            OffsetDateTime offset = OffsetDateTime.now();
            textView.setText(String.valueOf(offset.getDayOfWeek() + " : " + offset.getDayOfMonth() + " : " + offset.getDayOfYear()));
        }
    }
}