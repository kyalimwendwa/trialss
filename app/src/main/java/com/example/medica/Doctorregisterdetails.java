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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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

public class Doctorregisterdetails extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageView imageView;
    Button register;
    EditText fullname,department,email,contact,experience,patients,biography;
    private  static final int GALLERY_CODE=1;
    Uri imageUrl=null;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorregisterdetails);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView=findViewById(R.id.imageView);
        fullname=findViewById(R.id.etname);
        department=findViewById(R.id.etdepartment);
        email=findViewById(R.id.etEmail);
        contact=findViewById(R.id.etcontact);
        experience=findViewById(R.id.etexperience);
        patients=findViewById(R.id.etpatients);
        biography=findViewById(R.id.etbiography);
        register=findViewById(R.id.registerbtn);

        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Top Doctors");
        mStorage=FirebaseStorage.getInstance();
        progressBar =findViewById(R.id.progressBar);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(Doctorregisterdetails.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Select Image File"),GALLERY_CODE);

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



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==GALLERY_CODE&&resultCode==RESULT_OK)
        {
            imageUrl=data.getData();
            imageView.setImageURI(imageUrl);

        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fn=fullname.getText().toString().trim();
                String dp=department.getText().toString().trim();
                String em=email.getText().toString().trim();
                String co=contact.getText().toString().trim();
                String ex=experience.getText().toString().trim();
                String pa=patients.getText().toString().trim();
                String bio=biography.getText().toString().trim();




                if (!(fn.isEmpty()&&dp.isEmpty()&&em.isEmpty()&&co.isEmpty()&&ex.isEmpty()&&pa.isEmpty()&&bio.isEmpty()&&imageUrl!=null))
                {
                    progressBar.setVisibility(View.VISIBLE);


                    StorageReference filepath=mStorage.getReference().child("imagePost3").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Task<Uri> downloadUrl=taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t=task.getResult().toString();
                                    DatabaseReference newpost=mRef.push();

                                    newpost.child("Fullname").setValue(fn);
                                    newpost.child("Department").setValue(dp);
                                    newpost.child("Email").setValue(em);
                                    newpost.child("Contact").setValue(co);
                                    newpost.child("Experience").setValue(ex);
                                    newpost.child("Patients").setValue(pa);
                                    newpost.child("Biography").setValue(bio);
                                    newpost.child("Image").setValue(task.getResult().toString());
                                    progressBar.setVisibility(View.GONE);


                                    Intent intent=new Intent(Doctorregisterdetails.this,Doctorregisterdetails.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });


                }
            }
        });

    }
}