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

public class CardiologyDentalAppointment extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    EditText dateEditText;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageView imageView;
    Button update;
    EditText fullname,department,time1,time2,time3;
    private  static final int GALLERY_CODE=1;
    Uri imageUrl=null;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiology_dental_appointment);
        imageView=findViewById(R.id.imageVie);
        fullname=findViewById(R.id.editname1);
        department=findViewById(R.id.editdepartment1);
        time1=findViewById(R.id.editTexttime1);
        time2=findViewById(R.id.editTexttime2);
        time3=findViewById(R.id.editTexttime3);
        update=findViewById(R.id.timebtn1);

        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("Cardiology Doctors");
        mStorage=FirebaseStorage.getInstance();
        progressBar =findViewById(R.id.progressBar);
        initDatePicker();
        dateEditText=findViewById(R.id.datepicker);
        dateEditText.setText(getTodaysDate());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(CardiologyDentalAppointment.this)
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
                String tm1=time1.getText().toString().trim();
                String tm2=time2.getText().toString().trim();
                String tm3=time3.getText().toString().trim();
                String datee=dateEditText.getText().toString().trim();
                String dp=department.getText().toString().trim();


                if (!(fn.isEmpty()&&dp.isEmpty()&&tm3.isEmpty()&&tm1.isEmpty()&&tm2.isEmpty()&&datee.isEmpty()&&imageUrl!=null))
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
                                    newpost.child("Time1").setValue(tm1);
                                    newpost.child("Time2").setValue(tm2);
                                    newpost.child("Time3").setValue(tm3);
                                    newpost.child("Date").setValue(datee);
                                    newpost.child("Department").setValue(dp);
                                    newpost.child("Image").setValue(task.getResult().toString());
                                    progressBar.setVisibility(View.GONE);
                                    fullname.setText("");
                                    department.setText("");
                                    time1.setText("");
                                    time2.setText("");
                                    time3.setText("");



                                    Intent intent=new Intent(CardiologyDentalAppointment.this,RetrievedDoctorData.class);
                                    startActivity(intent);
                                }
                            });
                        }
                    });


                }
            }
        });

    }

    private String getTodaysDate() {
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        month=month+1;
        int day=cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);

    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date=makeDateString(day,month,year);
                dateEditText.setText(date);

            }
        };
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,day);


    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month)+"/"+day+"/"+year;
    }

    private String getMonthFormat(int month) {
        if (month==1)
            return "1";
        if (month==2)
            return "2";
        if (month==3)
            return "3";
        if (month==4)
            return "4";
        if (month==5)
            return "5";
        if (month==6)
            return "6";
        if (month==7)
            return "7";
        if (month==8)
            return "8";
        if (month==9)
            return "9";
        if (month==10)
            return "10";
        if (month==11)
            return "11";
        if (month==12)
            return "12";
        return "9";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();

    }
}