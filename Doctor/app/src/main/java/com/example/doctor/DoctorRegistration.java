package com.example.doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class DoctorRegistration extends AppCompatActivity {

    Button docbtn;
    EditText editTextfullname,editTextemail,editTextcontact,editTextpassword,editTextpasswordd;
    ProgressBar progressBar;
    DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_registration);

       docbtn=findViewById(R.id.docbtn);


        editTextfullname=findViewById(R.id.efullname);
        editTextemail=findViewById(R.id.eemail);
        editTextcontact=findViewById(R.id.econtact);
        editTextpassword=findViewById(R.id.epassword);
        progressBar=findViewById(R.id.progressBar);
        editTextpasswordd=findViewById(R.id.conpassword);


        docbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailTxt=editTextemail.getText().toString();
                final String passwordTxt=editTextpassword.getText().toString();
                final String fullnameTxt=editTextfullname.getText().toString();
                final String phoneTxt=editTextcontact.getText().toString();
                final String conpasswordTxt=editTextpasswordd.getText().toString();

                if (emailTxt.isEmpty()||passwordTxt.isEmpty()||fullnameTxt.isEmpty()||phoneTxt.isEmpty()||conpasswordTxt.isEmpty()){
                    Toast.makeText(DoctorRegistration.this, "Please fill all fields", Toast.LENGTH_SHORT).show();

                }else if (!passwordTxt.equals(conpasswordTxt)){
                    Toast.makeText(DoctorRegistration.this, "Passwords are not a match", Toast.LENGTH_SHORT).show();


                }
                else {

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(phoneTxt)){
                                Toast.makeText(DoctorRegistration.this, "Email is already registered", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                databaseReference.child("users").child(phoneTxt).child("fullname").setValue(fullnameTxt);
                                databaseReference.child("users").child(phoneTxt).child("email").setValue(emailTxt);
                                databaseReference.child("users").child(phoneTxt).child("password").setValue(passwordTxt);

                                Toast.makeText(DoctorRegistration.this, "User registered successfully", Toast.LENGTH_SHORT).show();


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