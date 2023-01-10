package com.example.doctor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

public class DoctorRegister extends AppCompatActivity {
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageView imageView,doclogin;
    Button register;
    EditText fullname,department;
    private  static final int GALLERY_CODE=1;
    Uri imageUrl=null;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_register);
        imageView=findViewById(R.id.imageView);
        fullname=findViewById(R.id.etname);
        department=findViewById(R.id.etdepartment);
        register=findViewById(R.id.registerbtn);
        doclogin=findViewById(R.id.doclogin);

        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Doctors");
        mStorage=FirebaseStorage.getInstance();
        progressBar =findViewById(R.id.progressBar);
        doclogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorRegister.this,Appointment.class));
            }
        });




        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(DoctorRegister.this)
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


                if (!(fn.isEmpty()&&dp.isEmpty()&&imageUrl!=null))
                {
                 progressBar.setVisibility(View.VISIBLE);


                    StorageReference filepath=mStorage.getReference().child("imagePost").child(imageUrl.getLastPathSegment());
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
                                    newpost.child("Image").setValue(task.getResult().toString());
                                    progressBar.setVisibility(View.GONE);


                                    Intent intent=new Intent(DoctorRegister.this,RetrievedDoctorData.class);
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