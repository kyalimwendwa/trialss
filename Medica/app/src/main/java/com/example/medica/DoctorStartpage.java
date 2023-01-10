package com.example.medica;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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

public class DoctorStartpage extends AppCompatActivity implements RecyclerViewInterface2 {
 TextView showname;
 ImageView showImage;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    RecyclerView recyclerView;
    PatientInfoAdapter patientInfoAdapter;
    List<PatientInfo> patientInfosMdlList;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    CardView dentalll;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_startpage);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        showname=findViewById(R.id.showname);
        showImage=findViewById(R.id.showImage);
        mAuth= FirebaseAuth.getInstance();
        dentalll=findViewById(R.id.dental);
        currentUser=mAuth.getCurrentUser();
        updateNavHeader();
        dentalll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DoctorStartpage.this,BookingTime.class);
                startActivity(intent);
            }
        });
        recyclerView=findViewById(R.id.recylerview_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        patientInfosMdlList=new ArrayList<PatientInfo>();
       patientInfoAdapter=new PatientInfoAdapter(DoctorStartpage.this,patientInfosMdlList,this);
        recyclerView.setAdapter(patientInfoAdapter);
        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Patients Appointments").child(showname.getText().toString());
        mStorage=FirebaseStorage.getInstance();

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
             PatientInfo patientInfo=snapshot.getValue(PatientInfo.class);
                patientInfosMdlList.add(patientInfo);
                patientInfoAdapter.notifyDataSetChanged();
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

    private void setTextViewColor(TextView textView, int...color) {
        TextPaint paint=textView.getPaint();
        float width=paint.measureText(textView.getText().toString());
        Shader shader=new LinearGradient(0,0,width,textView.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
        textView.setTextColor(color[0]);
    }
    private void setTextViewColor1(TextView textView1, int...color) {
        TextPaint paint=textView1.getPaint();
        float width=paint.measureText(textView1.getText().toString());
        Shader shader=new LinearGradient(0,0,width,textView1.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView1.getPaint().setShader(shader);
        textView1.setTextColor(color[0]);
    }

    public void updateNavHeader(){

        TextView navUsername=findViewById(R.id.showname);
        navUsername.setText(currentUser.getDisplayName());
        ImageView navuserPhot=findViewById(R.id.showImage);
        Glide.with(this).load(currentUser.getPhotoUrl()).into(navuserPhot);



    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(DoctorStartpage.this,ShowPatientInfo.class);
        intent.putExtra("Doctorname", patientInfosMdlList.get(position).getDoctorname());
        intent.putExtra("Purpose", patientInfosMdlList.get(position).getPurpose());
        intent.putExtra("Datetime1", patientInfosMdlList.get(position).getDatetime1());
        intent.putExtra("Datetime", patientInfosMdlList.get(position).getDatetime());
        intent.putExtra("Time", patientInfosMdlList.get(position).getTime());
        intent.putExtra("Patientname", patientInfosMdlList.get(position).getPatientname());
        intent.putExtra("Patientemail", patientInfosMdlList.get(position).getPatientemail());
        intent.putExtra("Patientcontact", patientInfosMdlList.get(position).getPatientcontact());
        intent.putExtra("Image", patientInfosMdlList.get(position).getImage());
        startActivity(intent);

    }
}