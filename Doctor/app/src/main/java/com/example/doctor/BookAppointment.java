package com.example.doctor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

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

import java.util.Calendar;

public class BookAppointment extends AppCompatActivity {
    EditText alex,betty,can,done,earn,fay,gal,hug,ian,jack,kyali,lime,mine,nike,org,rap,slots;
    EditText dateEditText;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageView imageView;
    TextView update;
    EditText fullname;
    private  static final int GALLERY_CODE=1;
    Uri imageUrl=null;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        imageView=findViewById(R.id.imageView1);
        fullname=findViewById(R.id.edit1name);
        slots=findViewById(R.id.slots);
        alex=findViewById(R.id.btn1);
        betty=findViewById(R.id.btn2);
        can=findViewById(R.id.btn3);
        done=findViewById(R.id.btn4);
        earn=findViewById(R.id.btn5);
        fay=findViewById(R.id.btn6);
        gal=findViewById(R.id.btn7);
        hug=findViewById(R.id.btn8);
        ian=findViewById(R.id.btn9);
        jack=findViewById(R.id.btn11);
       kyali=findViewById(R.id.btn12);
        lime=findViewById(R.id.btn13);
       mine=findViewById(R.id.btn14);
        nike=findViewById(R.id.btn15);
        org=findViewById(R.id.btn16);
        rap=findViewById(R.id.btn17);


        update=findViewById(R.id.update);

        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Dental Appointment");
        mStorage=FirebaseStorage.getInstance();
        progressBar =findViewById(R.id.progressBar);
        dateEditText=findViewById(R.id.datepicker);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(BookAppointment.this)
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
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fn=fullname.getText().toString().trim();
                String datee=dateEditText.getText().toString().trim();
                String sl=slots.getText().toString().trim();

                String tm=alex.getText().toString().trim();
                String tm1=betty.getText().toString().trim();
                String tm2=can.getText().toString().trim();
                String tm3=done.getText().toString().trim();
                String tm4=earn.getText().toString().trim();
                String tm5=fay.getText().toString().trim();
                String tm6=gal.getText().toString().trim();
                String tm7=hug.getText().toString().trim();
                String tm8=ian.getText().toString().trim();
                String tm9=jack.getText().toString().trim();
                String tm11=kyali.getText().toString().trim();
                String tm12=lime.getText().toString().trim();
                String tm13=mine.getText().toString().trim();
                String tm14=nike.getText().toString().trim();
                String tm15=org.getText().toString().trim();
                String tm16=rap.getText().toString().trim();


                if (!(fn.isEmpty()&&tm.isEmpty()&&sl.isEmpty()&&tm1.isEmpty()&&tm2.isEmpty()&&tm3.isEmpty()&&tm4.isEmpty()&&tm5.isEmpty()&&tm6.isEmpty()&&tm7.isEmpty()&&tm8.isEmpty()&&tm9.isEmpty()&&tm11.isEmpty()&&tm12.isEmpty()&&tm13.isEmpty()&&tm14.isEmpty()&&tm15.isEmpty()&&tm16.isEmpty()&&datee.isEmpty()&&imageUrl!=null))
                {
                    progressBar.setVisibility(View.VISIBLE);


                    StorageReference filepath=mStorage.getReference().child("imagePost1").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Task<Uri> downloadUrl=taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t=task.getResult().toString();
                                    DatabaseReference newpost=mRef.push();

                                    newpost.child("Fullname").setValue(fn);
                                    newpost.child("Date").setValue(datee);
                                    newpost.child("Slots").setValue(sl);
                                    newpost.child("Alex").setValue(tm);
                                    newpost.child("Betty").setValue(tm1);
                                    newpost.child("Can").setValue(tm2);
                                    newpost.child("Done").setValue(tm3);
                                    newpost.child("Earn").setValue(tm4);
                                    newpost.child("Fay").setValue(tm5);
                                    newpost.child("Gal").setValue(tm6);
                                    newpost.child("Hug").setValue(tm7);
                                    newpost.child("Ian").setValue(tm8);
                                    newpost.child("Jack").setValue(tm9);
                                    newpost.child("Kyali").setValue(tm11);
                                    newpost.child("Lime").setValue(tm12);
                                    newpost.child("Mine").setValue(tm13);
                                    newpost.child("Nike").setValue(tm14);
                                    newpost.child("Org").setValue(tm15);
                                    newpost.child("Rap").setValue(tm16);

                                    newpost.child("Image").setValue(task.getResult().toString());
                                    progressBar.setVisibility(View.GONE);
                                    fullname.setText("");
                                    dateEditText.setText("");




                                    Intent intent=new Intent(BookAppointment.this,Dental.class);
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