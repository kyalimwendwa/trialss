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
import com.google.firebase.database.FirebaseDatabase;

public class PatientRegister extends AppCompatActivity  implements  View.OnClickListener{

    Button registerbutton;
    EditText editTextfullname,editTextemail,editTextcontact,editTextnumber,editTextpassword;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);

        mAuth = FirebaseAuth.getInstance();

        registerbutton=findViewById(R.id.registerbutton);
        registerbutton.setOnClickListener(this);
        editTextfullname=findViewById(R.id.etfullname);
        editTextemail=findViewById(R.id.etemail);
        editTextcontact=findViewById(R.id.etcontact);
        editTextnumber=findViewById(R.id.etnumber);
        editTextpassword=findViewById(R.id.etpassword);
        progressBar=findViewById(R.id.progressBar);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerbutton:
                registerUser();
                break;

        }

    }

    private void registerUser() {
        String fullname=editTextfullname.getText().toString().trim();
        String email=editTextemail.getText().toString().trim();
        String contact=editTextcontact.getText().toString().trim();
        String number=editTextnumber.getText().toString().trim();
        String password=editTextpassword.getText().toString().trim();
        if (fullname.isEmpty()){
            editTextfullname.setError("Fullname field is empty");
            editTextfullname.requestFocus();
            return;
        }
        if (email.isEmpty()){
            editTextemail.setError("Email field is empty");
            editTextemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("Enter a valid email address");
            editTextemail.requestFocus();
            return;
        }
        if (contact.isEmpty()){
            editTextcontact.setError("Contact field is empty");
            editTextcontact.requestFocus();
            return;
        }
        if (number.isEmpty()){
            editTextnumber.setError("Enter national ID");
            editTextnumber.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editTextpassword.setError("Password field is empty");
            editTextpassword.requestFocus();
            return;
        }
        if (password.length()<7){
            editTextpassword.setError("Minimum password characters is 7");
            editTextpassword.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Patient patient=new Patient(fullname,email,contact,number,password);
                            FirebaseDatabase.getInstance().getReference("Patients")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(patient).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){

                                        Toast.makeText(PatientRegister.this, "Registration Success", Toast.LENGTH_LONG).show();
                                       editTextfullname.setText("");
                                       editTextemail.setText("");
                                       editTextcontact.setText("");
                                       editTextnumber.setText("");
                                       editTextpassword.setText("");
                                        progressBar.setVisibility(View.GONE);

                                    }else {
                                        Toast.makeText(PatientRegister.this, "Error!!!Registration not success", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });

                        }
                        else {
                            Toast.makeText(PatientRegister.this, "Connection Failed", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}