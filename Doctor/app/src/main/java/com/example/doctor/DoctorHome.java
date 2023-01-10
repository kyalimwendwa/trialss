package com.example.doctor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class DoctorHome extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    RecyclerView recyclerView;
    DoctorAdapter doctorAdapter;
    List<DoctorModel> doctorMdlList;
    ImageView doclogin;
    CardView dental,cardiology,consultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        doclogin=findViewById(R.id.doclogin);
        dental=findViewById(R.id.dental);
        cardiology=findViewById(R.id.cardiology);
        consultation=findViewById(R.id.consulation);

        recyclerView=findViewById(R.id.recylerview_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        doctorMdlList=new ArrayList<DoctorModel>();
        doctorAdapter=new DoctorAdapter(DoctorHome.this,doctorMdlList);
        recyclerView.setAdapter(doctorAdapter);
        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Doctors");
        mStorage=FirebaseStorage.getInstance();

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                DoctorModel doctorModel=snapshot.getValue(DoctorModel.class);
                doctorMdlList.add(doctorModel);
                doctorAdapter.notifyDataSetChanged();
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

        cardiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorHome.this,CardiologyDentalAppointment.class));
            }
        });
        dental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorHome.this,DentalDoctorsAppointment.class));
            }
        });
        consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorHome.this,ConsultationDoctorAppointment.class));
            }
        });


    }
}