package com.example.doctor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class Cardiology extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    RecyclerView recyclerView;
    CardiologyDoctorAdapter cardiologyDoctorAdapter;
    List<CardiologyDoctorModel> cardiologyMdlList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiology);


        recyclerView = findViewById(R.id.recylerview_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardiologyMdlList= new ArrayList<CardiologyDoctorModel>();
        cardiologyDoctorAdapter = new CardiologyDoctorAdapter(Cardiology.this,cardiologyMdlList);
        recyclerView.setAdapter(cardiologyDoctorAdapter);
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("Cardiology Doctors");
        mStorage = FirebaseStorage.getInstance();

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                CardiologyDoctorModel cardiologyDoctorModel = snapshot.getValue( CardiologyDoctorModel.class);
                cardiologyMdlList.add(cardiologyDoctorModel);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}