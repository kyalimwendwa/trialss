package com.example.medica;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.concurrent.TimeUnit;

public class SendOTPActivity  extends AppCompatActivity {
    EditText  patientname, patientemail, patientcontact, purpose;
    TextView  doctorname, datetime,time,datetime1;
    Button regBtn, buttonGetOTP;
    ImageView imageView,back;
    FloatingActionButton uploadimage;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;

    private static final int GALLERY_CODE = 1;
    Uri imageUrl = null;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendotp);
        doctorname = findViewById(R.id.doctorfullname);
        doctorname.setKeyListener(null);
        datetime1 = findViewById(R.id.datetime1);
        datetime1.setKeyListener(null);
        uploadimage=findViewById(R.id.uploadimage);





        purpose = findViewById(R.id.purpose);
        mAuth= FirebaseAuth.getInstance();
        currentUser=mAuth.getCurrentUser();
        updateNavHeader();
        back=findViewById(R.id.backk);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SendOTPActivity.this,AppointmentHours.class);
                startActivity(intent);
            }
        });

        imageView = findViewById(R.id.regUserPhoto);
        datetime = findViewById(R.id.datetime);
        datetime.setKeyListener(null);
        time = findViewById(R.id.time);
        time.setKeyListener(null);
        Intent intent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String str = intent.getStringExtra("message_key");
        // display the string into textView
        time.setText(str);
        String str1 = intent.getStringExtra("message_fullname");
        // display the string into textView
        doctorname.setText(str1);

        String str2 = intent.getStringExtra("message_date");
        // display the string into textView
        datetime.setText(str2);

        String str3 = intent.getStringExtra("message_slots");
        // display the string into textView
        datetime1.setText(str3);



        patientname = findViewById(R.id.patientfullname);
        patientemail = findViewById(R.id.patientemail);
        patientcontact = findViewById(R.id.inputMobile);
        regBtn = findViewById(R.id.buttonConfirm);
        mDatabase = FirebaseDatabase.getInstance();
        mStorage = FirebaseStorage.getInstance();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final EditText inputMobile = findViewById(R.id.inputMobile);
        buttonGetOTP = findViewById(R.id.buttonGetOTP);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        uploadimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(SendOTPActivity.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent, "Select Image File"), GALLERY_CODE);

                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();


            }
        });


        buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputMobile.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendOTPActivity.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                buttonGetOTP.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber("" +
                                "+254" + inputMobile.getText().toString(),
                        30,
                        TimeUnit.SECONDS,
                        SendOTPActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(View.VISIBLE);
                                Toast.makeText(SendOTPActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(getApplicationContext(), Verifyotpnumber.class);
                                intent.putExtra("mobile", inputMobile.getText().toString());
                                intent.putExtra("verificationId", verificationId);
                                startActivity(intent);
                                InsertData();


                            }
                        }
                );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_CODE && resultCode == RESULT_OK) {
            imageUrl = data.getData();
            imageView.setImageURI(imageUrl);

        }

    }

    private void InsertData() {
        String docname = doctorname.getText().toString();
        String pu = purpose.getText().toString();
        String dame = datetime.getText().toString();
        String dame1 = datetime1.getText().toString();
        String tim = time.getText().toString();
        String patname = patientname.getText().toString();
        String patem = patientemail.getText().toString();
        String patco = patientcontact.getText().toString();
        patientcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageUrl == null){
                    Toast.makeText(SendOTPActivity.this,"Please insert your image",Toast.LENGTH_LONG).show();
                }
            }
        });





        if (docname.isEmpty()){
            Toast.makeText(SendOTPActivity.this,"Please fill all fields",Toast.LENGTH_LONG).show();
        }
        if (pu.isEmpty()){
            Toast.makeText(SendOTPActivity.this,"Please fill all fields",Toast.LENGTH_LONG).show();
        }
        if (dame.isEmpty()){
            Toast.makeText(SendOTPActivity.this,"Please fill all fields",Toast.LENGTH_LONG).show();
        }
        if (dame1.isEmpty()){
            Toast.makeText(SendOTPActivity.this,"Please fill all fields",Toast.LENGTH_LONG).show();
        }
        if (tim.isEmpty()){
            Toast.makeText(SendOTPActivity.this,"Please fill all fields",Toast.LENGTH_LONG).show();
        }
        if (patname.isEmpty()){
            Toast.makeText(SendOTPActivity.this,"Please fill all fields",Toast.LENGTH_LONG).show();
        }
        if (patem.isEmpty()){
            Toast.makeText(SendOTPActivity.this,"Please fill all fields",Toast.LENGTH_LONG).show();
        }
        if (patco.isEmpty()){
            Toast.makeText(SendOTPActivity.this,"Please fill all fields",Toast.LENGTH_LONG).show();
        }


       else  {
            mRef = mDatabase.getReference().child("Patients Appointments").child(docname);

            StorageReference filepath = mStorage.getReference().child("AppointsImages").child(String.valueOf(imageView));
            filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            String t = task.getResult().toString();
                            DatabaseReference newpost = mRef.push();

                            newpost.child("Doctorname").setValue(docname);
                            newpost.child("Purpose").setValue(pu);
                            newpost.child("Datetime").setValue(dame);
                            newpost.child("Datetime1").setValue(dame1);
                            newpost.child("Time").setValue(tim);
                            newpost.child("Patientname").setValue(patname);
                            newpost.child("Patientemail").setValue(patem);
                            newpost.child("Patientcontact").setValue("+254"+patco);
                            newpost.child("Image").setValue(task.getResult().toString());

                        }
                    });
                }
            });


        }

    }

    public void updateNavHeader(){

        EditText navUsername=findViewById(R.id.patientfullname);
        navUsername.setText(currentUser.getDisplayName());

        navUsername.setText(currentUser.getDisplayName());



    }
}