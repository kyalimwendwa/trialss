package com.example.medica;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class PatientHistory extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    TextView names;
    ImageView showImage;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    RecyclerView recyclerView;
    PatientShowInfoAdapter patientShowInfoAdapter;
    List<PatientShowInfo> patientShowInfos;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_history);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        names=findViewById(R.id.showname);
        showImage=findViewById(R.id.showImage);
        mAuth= FirebaseAuth.getInstance();
        currentUser=mAuth.getCurrentUser();
        updateNavHeader();
        recyclerView=findViewById(R.id.recylerview_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        patientShowInfos=new ArrayList<PatientShowInfo>();
        patientShowInfoAdapter = new PatientShowInfoAdapter(PatientHistory.this,patientShowInfos);
        recyclerView.setAdapter(patientShowInfoAdapter);
        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Patients Category").child(names.getText().toString());
        mStorage=FirebaseStorage.getInstance();
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                PatientShowInfo patientShowInfo=snapshot.getValue(PatientShowInfo.class);
                patientShowInfos.add(patientShowInfo);
                patientShowInfoAdapter.notifyDataSetChanged();
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

    private void updateNavHeader() {
        TextView navUsername=findViewById(R.id.showname);
        navUsername.setText(currentUser.getDisplayName());
        ImageView navuserPhot=findViewById(R.id.showImage);
        Glide.with(this).load(currentUser.getPhotoUrl()).into(navuserPhot);
    }
}