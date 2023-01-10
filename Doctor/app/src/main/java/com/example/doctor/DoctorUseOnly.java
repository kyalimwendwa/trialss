package com.example.doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DoctorUseOnly extends AppCompatActivity {
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
TextView reg;
    Button grant;
    EditText editTextphone,editTextpassword;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_use_only);
        grant=findViewById(R.id.grant);
        editTextphone=findViewById(R.id.phone);
        editTextpassword=findViewById(R.id.passwordd);
        progressBar=findViewById(R.id.progressBar);
        reg=findViewById(R.id.regbbtn);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorUseOnly.this,DoctorRegistration.class));
            }
        });




        grant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phoneTxt=editTextphone.getText().toString();
                final String passwordTxt=editTextpassword.getText().toString();
                if (phoneTxt.isEmpty()||passwordTxt.isEmpty()){
                    Toast.makeText(DoctorUseOnly.this, "Please enter Email  password or password", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(phoneTxt)){

                                final String getPassword=snapshot.child(phoneTxt).child("password").getValue(String.class);

                                
                                if (getPassword.equals(passwordTxt)){
                                    Toast.makeText(DoctorUseOnly.this, "Login success", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(DoctorUseOnly.this,ChooseDepartment.class));


                                }
                                else{
                                    Toast.makeText(DoctorUseOnly.this, "Wrong Password", Toast.LENGTH_SHORT).show();


                                }
                            }
                            else{
                                Toast.makeText(DoctorUseOnly.this, "Login not successfull", Toast.LENGTH_SHORT).show();


                            }
                            
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }



            }
        });
    }



}