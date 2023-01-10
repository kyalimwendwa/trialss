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

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Dental extends AppCompatActivity implements RecyclerViewInterface {
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    RecyclerView recyclerView;
    DentalDoctorAdapter dentalDoctorAdapter;
    List<DentalDoctorModel> dentalMdlList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental);


        recyclerView = findViewById(R.id.recylerview_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dentalMdlList= new ArrayList<DentalDoctorModel>();
        dentalDoctorAdapter = new DentalDoctorAdapter(Dental.this,dentalMdlList,this);
        recyclerView.setAdapter(dentalDoctorAdapter);
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("Dental Appointment");
        mStorage = FirebaseStorage.getInstance();

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                DentalDoctorModel dentalDoctorModel= snapshot.getValue( DentalDoctorModel.class);
                dentalMdlList.add(dentalDoctorModel);
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

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(Dental.this,ShowTime.class);
        intent.putExtra("Fullname",dentalMdlList.get(position).getFullname());
        intent.putExtra("Alex",dentalMdlList.get(position).getAlex());
        intent.putExtra("Betty",dentalMdlList.get(position).getBetty());
        intent.putExtra("Can",dentalMdlList.get(position).getCan());
        intent.putExtra("Done",dentalMdlList.get(position).getDone());
        intent.putExtra("Earn",dentalMdlList.get(position).getEarn());
        intent.putExtra("Fay",dentalMdlList.get(position).getFay());
        intent.putExtra("Gal",dentalMdlList.get(position).getGal());
        intent.putExtra("Hug",dentalMdlList.get(position).getHug());
        intent.putExtra("Ian",dentalMdlList.get(position).getIan());
        intent.putExtra("Jack",dentalMdlList.get(position).getJack());
        intent.putExtra("Kyali",dentalMdlList.get(position).getKyali());
        intent.putExtra("Lime",dentalMdlList.get(position).getLime());
        intent.putExtra("Mine",dentalMdlList.get(position).getMine());
        intent.putExtra("Nike",dentalMdlList.get(position).getNike());
        intent.putExtra("Org",dentalMdlList.get(position).getOrg());
        intent.putExtra("Rap",dentalMdlList.get(position).getRap());

        startActivity(intent);

    }
}