package com.example.medica;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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

public class BookingTime extends AppCompatActivity {
    EditText alex,betty,can,done,earn,fay,gal,hug,ian,jack,kyali,lime,mine,nike,org,rap,slots;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9,ed10,ed11,ed12,ed13,ed14,ed15,ed16;
    EditText ed17,ed18,ed19,ed20,ed21,ed22,ed23,ed24,ed25,ed26,ed27,ed28,ed29,ed30,ed31,ed32;
    EditText ed33,ed34,ed35,ed36,ed37,ed38,ed39,ed40,ed41,ed42,ed43,ed44,ed45,ed46,ed47,ed48;
    EditText ed49,ed50,ed51,ed52,ed53,ed54,ed55,ed56,ed57,ed58,ed59,ed60,ed61,ed62,ed63,ed64;

    EditText dateEditText,slot2,slot3,slot4,slot5,datepicker2,datepicker3,datepicker4,datepicker5,speciality;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    ImageView imageView;
    EditText update;
    EditText fullname;
    private  static final int GALLERY_CODE=1;
    Uri imageUrl=null;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_time);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mDatabase=FirebaseDatabase.getInstance();
        mRef=mDatabase.getReference().child("All Doctors ");
        mStorage=FirebaseStorage.getInstance();
        progressBar =findViewById(R.id.progressBar);
        dateEditText=findViewById(R.id.datepicker);
        imageView=findViewById(R.id.imageView1);
        fullname=findViewById(R.id.edit1name);
        slots=findViewById(R.id.slots);
        speciality=findViewById(R.id.edit1special);
        datepicker2=findViewById(R.id.datepicker2);
        datepicker3=findViewById(R.id.datepicker3);
        datepicker4=findViewById(R.id.datepicker4);
        datepicker5=findViewById(R.id.datepicker5);
        slot2=findViewById(R.id.slots2);
        slot3=findViewById(R.id.slots3);
        slot4=findViewById(R.id.slots4);
        slot5=findViewById(R.id.slots5);
        alex=findViewById(R.id.btn1);
        alex.setKeyListener(null);

        betty=findViewById(R.id.btn2);
        betty.setKeyListener(null);
        can=findViewById(R.id.btn3);
        can.setKeyListener(null);
        done=findViewById(R.id.btn4);
        done.setKeyListener(null);
        earn=findViewById(R.id.btn5);
        earn.setKeyListener(null);
        fay=findViewById(R.id.btn6);
        fay.setKeyListener(null);
        gal=findViewById(R.id.btn7);
        gal.setKeyListener(null);
        hug=findViewById(R.id.btn8);
        hug.setKeyListener(null);
        ian=findViewById(R.id.btn9);
        ian.setKeyListener(null);
        jack=findViewById(R.id.btn11);
        jack.setKeyListener(null);
        kyali=findViewById(R.id.btn12);
        kyali.setKeyListener(null);
        lime=findViewById(R.id.btn13);
        lime.setKeyListener(null);
        mine=findViewById(R.id.btn14);
        mine.setKeyListener(null);
        nike=findViewById(R.id.btn15);
        nike.setKeyListener(null);
        org=findViewById(R.id.btn16);
        org.setKeyListener(null);
        rap=findViewById(R.id.btn17);
        rap.setKeyListener(null);
        ed1=findViewById(R.id.btn18);
        ed1.setKeyListener(null);
        ed2=findViewById(R.id.btn19);
        ed2.setKeyListener(null);
        ed3=findViewById(R.id.btn20);
        ed3.setKeyListener(null);
        ed4=findViewById(R.id.btn21);
        ed4.setKeyListener(null);
        ed5=findViewById(R.id.btn22);
        ed5.setKeyListener(null);
        ed6=findViewById(R.id.btn23);
        ed6.setKeyListener(null);
        ed7=findViewById(R.id.btn24);
        ed7.setKeyListener(null);
        ed8=findViewById(R.id.btn25);
        ed8.setKeyListener(null);
        ed9=findViewById(R.id.btn26);
        ed9.setKeyListener(null);
        ed10=findViewById(R.id.btn27);
        ed10.setKeyListener(null);
        ed11=findViewById(R.id.btn28);
        ed11.setKeyListener(null);
        ed12=findViewById(R.id.btn29);
        ed12.setKeyListener(null);
        ed13=findViewById(R.id.btn30);
        ed13.setKeyListener(null);
        ed14=findViewById(R.id.btn31);
        ed14.setKeyListener(null);
        ed15=findViewById(R.id.btn32);
        ed15.setKeyListener(null);
        ed16=findViewById(R.id.btn33);
        ed16.setKeyListener(null);
        ed17=findViewById(R.id.btn34);
        ed17.setKeyListener(null);
        ed18=findViewById(R.id.btn35);
        ed18.setKeyListener(null);
        ed19=findViewById(R.id.btn36);
        ed19.setKeyListener(null);
        ed20=findViewById(R.id.btn37);
        ed20.setKeyListener(null);
        ed21=findViewById(R.id.btn38);
        ed21.setKeyListener(null);
        ed22=findViewById(R.id.btn39);
        ed22.setKeyListener(null);
        ed23=findViewById(R.id.btn40);
        ed23.setKeyListener(null);
        ed24=findViewById(R.id.btn41);
        ed24.setKeyListener(null);
        ed25=findViewById(R.id.btn42);
        ed25.setKeyListener(null);
        ed26=findViewById(R.id.btn43);
        ed26.setKeyListener(null);
        ed27=findViewById(R.id.btn44);
        ed27.setKeyListener(null);
        ed28=findViewById(R.id.btn45);
        ed28.setKeyListener(null);
        ed29=findViewById(R.id.btn46);
        ed29.setKeyListener(null);
        ed30=findViewById(R.id.btn47);
        ed30.setKeyListener(null);
        ed31=findViewById(R.id.btn48);
        ed31.setKeyListener(null);
        ed32=findViewById(R.id.btn49);
        ed32.setKeyListener(null);
        ed33=findViewById(R.id.btn50);
        ed33.setKeyListener(null);
        ed34=findViewById(R.id.btn51);
        ed34.setKeyListener(null);
        ed35=findViewById(R.id.btn52);
        ed35.setKeyListener(null);
        ed36=findViewById(R.id.btn53);
        ed36.setKeyListener(null);
        ed37=findViewById(R.id.btn54);
        ed37.setKeyListener(null);
        ed38=findViewById(R.id.btn55);
        ed38.setKeyListener(null);
        ed39=findViewById(R.id.btn56);
        ed39.setKeyListener(null);
        ed40=findViewById(R.id.btn57);
        ed40.setKeyListener(null);
        ed41=findViewById(R.id.btn58);
        ed41.setKeyListener(null);
        ed42=findViewById(R.id.btn59);
        ed42.setKeyListener(null);
        ed43=findViewById(R.id.btn60);
        ed43.setKeyListener(null);
        ed44=findViewById(R.id.btn61);
        ed44.setKeyListener(null);
        ed45=findViewById(R.id.btn62);
        ed45.setKeyListener(null);
        ed46=findViewById(R.id.btn63);
        ed46.setKeyListener(null);
        ed47=findViewById(R.id.btn64);
        ed47.setKeyListener(null);
        ed48=findViewById(R.id.btn65);
        ed48.setKeyListener(null);
        ed49=findViewById(R.id.btn66);
        ed49.setKeyListener(null);
        ed50=findViewById(R.id.btn67);
        ed50.setKeyListener(null);
        ed51=findViewById(R.id.btn68);
        ed51.setKeyListener(null);
        ed52=findViewById(R.id.btn69);
        ed52.setKeyListener(null);
        ed53=findViewById(R.id.btn70);
        ed53.setKeyListener(null);
        ed54=findViewById(R.id.btn71);
        ed54.setKeyListener(null);
        ed55=findViewById(R.id.btn72);
        ed55.setKeyListener(null);
        ed56=findViewById(R.id.btn73);
        ed56.setKeyListener(null);
        ed57=findViewById(R.id.btn74);
        ed57.setKeyListener(null);
        ed58=findViewById(R.id.btn75);
        ed58.setKeyListener(null);
        ed59=findViewById(R.id.btn76);
        ed59.setKeyListener(null);
        ed60=findViewById(R.id.btn77);
        ed60.setKeyListener(null);
        ed61=findViewById(R.id.btn78);
        ed61.setKeyListener(null);
        ed62=findViewById(R.id.btn79);
        ed62.setKeyListener(null);
        ed63=findViewById(R.id.btn80);
        ed63.setKeyListener(null);
        ed64=findViewById(R.id.btn81);
        ed64.setKeyListener(null);


        update=findViewById(R.id.update);
        update.setKeyListener(null);
        alex.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                alex.setBackgroundResource(R.color.alex);
                alex.setText("9:00AM");

            }
        });
        betty.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                betty.setBackgroundResource(R.color.alex);
                betty.setText("9:30AM");

            }
        });
        can.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                can.setBackgroundResource(R.color.alex);
                can.setText("10:00AM");

            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                done.setBackgroundResource(R.color.alex);
                done.setText("10:30AM");

            }
        });
        earn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                earn.setBackgroundResource(R.color.alex);
                earn.setText("11:00AM");

            }
        });
        fay.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                fay.setBackgroundResource(R.color.alex);
                fay.setText("11:30AM");

            }
        });
        gal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                gal.setBackgroundResource(R.color.alex);
                gal.setText("12:00");

            }
        });
        hug.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                hug.setBackgroundResource(R.color.alex);
                hug.setText("12:30PM");

            }
        });
        ian.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ian.setBackgroundResource(R.color.alex);
                ian.setText("01:00PM");

            }
        });
        jack.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                jack.setBackgroundResource(R.color.alex);
                jack.setText("02:00PM");

            }
        });
        kyali.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                kyali.setBackgroundResource(R.color.alex);
                kyali.setText("02:30PM");

            }
        });
        lime.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                lime.setBackgroundResource(R.color.alex);
                lime.setText("03:00PM");

            }
        });
        mine.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                mine.setBackgroundResource(R.color.alex);
                mine.setText("03:30PM");

            }
        });
        nike.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                nike.setBackgroundResource(R.color.alex);
                nike.setText("04:00PM");

            }
        });
        org.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                org.setBackgroundResource(R.color.alex);
                org.setText("04:30PM");

            }
        });
        rap.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                rap.setBackgroundResource(R.color.alex);
                rap.setText("05:00PM");

            }
        });


        ed1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed1.setBackgroundResource(R.color.alex);
                ed1.setText("9:00AM");

            }
        });
        ed2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed2.setBackgroundResource(R.color.alex);
                ed2.setText("9:30AM");

            }
        });
        ed3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed3.setBackgroundResource(R.color.alex);
                ed3.setText("10:00AM");

            }
        });
        ed4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed4.setBackgroundResource(R.color.alex);
                ed4.setText("10:30AM");

            }
        });
        ed5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed5.setBackgroundResource(R.color.alex);
                ed5.setText("11:00AM");

            }
        });
        ed6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed6.setBackgroundResource(R.color.alex);
                ed6.setText("11:30AM");

            }
        });
        ed7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed7.setBackgroundResource(R.color.alex);
                ed7.setText("12:00");

            }
        });
        ed8.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed8.setBackgroundResource(R.color.alex);
                ed8.setText("12:30PM");

            }
        });
        ed9.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed9.setBackgroundResource(R.color.alex);
                ed9.setText("01:00PM");

            }
        });
        ed10.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed10.setBackgroundResource(R.color.alex);
                ed10.setText("02:00PM");

            }
        });
        ed11.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed11.setBackgroundResource(R.color.alex);
                ed11.setText("02:30PM");

            }
        });
        ed12.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
               ed12.setBackgroundResource(R.color.alex);
                ed12.setText("03:00PM");

            }
        });
        ed13.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed13.setBackgroundResource(R.color.alex);
                ed13.setText("03:30PM");

            }
        });
        ed14.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed14.setBackgroundResource(R.color.alex);
                ed14.setText("04:00PM");

            }
        });
        ed15.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed15.setBackgroundResource(R.color.alex);
                ed15.setText("04:30PM");

            }
        });
        ed16.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed16.setBackgroundResource(R.color.alex);
                ed16.setText("05:00PM");

            }
        });

        ed17.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed17.setBackgroundResource(R.color.alex);
                ed17.setText("9:00AM");

            }
        });
        ed18.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed18.setBackgroundResource(R.color.alex);
                ed18.setText("9:30AM");

            }
        });
        ed19.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed19.setBackgroundResource(R.color.alex);
                ed19.setText("10:00AM");

            }
        });
        ed20.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed20.setBackgroundResource(R.color.alex);
                ed20.setText("10:30AM");

            }
        });
        ed21.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed21.setBackgroundResource(R.color.alex);
                ed21.setText("11:00AM");

            }
        });
        ed22.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed22.setBackgroundResource(R.color.alex);
                ed22.setText("11:30AM");

            }
        });
        ed23.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed23.setBackgroundResource(R.color.alex);
                ed23.setText("12:00");

            }
        });
        ed24.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed24.setBackgroundResource(R.color.alex);
                ed24.setText("12:30PM");

            }
        });
        ed25.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed25.setBackgroundResource(R.color.alex);
                ed25.setText("01:00PM");

            }
        });
        ed26.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed26.setBackgroundResource(R.color.alex);
                ed26.setText("02:00PM");

            }
        });
        ed27.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed27.setBackgroundResource(R.color.alex);
                ed27.setText("02:30PM");

            }
        });
        ed28.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed28.setBackgroundResource(R.color.alex);
                ed28.setText("03:00PM");

            }
        });
        ed29.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed29.setBackgroundResource(R.color.alex);
                ed29.setText("03:30PM");

            }
        });
        ed30.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed30.setBackgroundResource(R.color.alex);
                ed30.setText("04:00PM");

            }
        });
        ed31.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed31.setBackgroundResource(R.color.alex);
                ed31.setText("04:30PM");

            }
        });
        ed32.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed32.setBackgroundResource(R.color.alex);
                ed32.setText("05:00PM");

            }
        });

        ed33.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed33.setBackgroundResource(R.color.alex);
                ed33.setText("9:00AM");

            }
        });
        ed34.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed34.setBackgroundResource(R.color.alex);
                ed34.setText("9:30AM");

            }
        });
        ed35.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed35.setBackgroundResource(R.color.alex);
                ed35.setText("10:00AM");

            }
        });
        ed36.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed36.setBackgroundResource(R.color.alex);
                ed36.setText("10:30AM");

            }
        });
        ed37.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed37.setBackgroundResource(R.color.alex);
                ed37.setText("11:00AM");

            }
        });
        ed38.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed38.setBackgroundResource(R.color.alex);
                ed38.setText("11:30AM");

            }
        });
        ed39.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed39.setBackgroundResource(R.color.alex);
                ed39.setText("12:00");

            }
        });
        ed40.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed40.setBackgroundResource(R.color.alex);
                ed40.setText("12:30PM");

            }
        });
        ed41.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed41.setBackgroundResource(R.color.alex);
                ed41.setText("01:00PM");

            }
        });
        ed42.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed42.setBackgroundResource(R.color.alex);
                ed42.setText("02:00PM");

            }
        });
        ed43.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed43.setBackgroundResource(R.color.alex);
                ed43.setText("02:30PM");

            }
        });
        ed44.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed44.setBackgroundResource(R.color.alex);
                ed44.setText("03:00PM");

            }
        });
        ed45.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed45.setBackgroundResource(R.color.alex);
                ed45.setText("03:30PM");

            }
        });
        ed46.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed46.setBackgroundResource(R.color.alex);
                ed46.setText("04:00PM");

            }
        });
        ed47.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed47.setBackgroundResource(R.color.alex);
                ed47.setText("04:30PM");

            }
        });
        ed48.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed48.setBackgroundResource(R.color.alex);
                ed48.setText("05:00PM");

            }
        });

        ed49.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed49.setBackgroundResource(R.color.alex);
                ed49.setText("9:00AM");

            }
        });
        ed50.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed50.setBackgroundResource(R.color.alex);
                ed50.setText("9:30AM");

            }
        });
        ed51.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed51.setBackgroundResource(R.color.alex);
                ed51.setText("10:00AM");

            }
        });
        ed52.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed52.setBackgroundResource(R.color.alex);
                ed52.setText("10:30AM");

            }
        });
        ed53.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed53.setBackgroundResource(R.color.alex);
                ed53.setText("11:00AM");

            }
        });
        ed54.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed54.setBackgroundResource(R.color.alex);
                ed54.setText("11:30AM");

            }
        });
        ed55.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed55.setBackgroundResource(R.color.alex);
                ed55.setText("12:00");

            }
        });
        ed56.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed56.setBackgroundResource(R.color.alex);
                ed56.setText("12:30PM");

            }
        });
        ed57.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed57.setBackgroundResource(R.color.alex);
                ed57.setText("01:00PM");

            }
        });
        ed58.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed58.setBackgroundResource(R.color.alex);
                ed58.setText("02:00PM");

            }
        });
        ed59.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed59.setBackgroundResource(R.color.alex);
                ed59.setText("02:30PM");

            }
        });
        ed60.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed60.setBackgroundResource(R.color.alex);
                ed60.setText("03:00PM");

            }
        });
        ed61.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed61.setBackgroundResource(R.color.alex);
                ed61.setText("03:30PM");

            }
        });
        ed62.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed62.setBackgroundResource(R.color.alex);
                ed62.setText("04:00PM");

            }
        });
        ed63.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed63.setBackgroundResource(R.color.alex);
                ed63.setText("04:30PM");

            }
        });
        ed64.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                ed64.setBackgroundResource(R.color.alex);
                ed64.setText("05:00PM");

            }
        });



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(BookingTime.this)
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
                String spec=speciality.getText().toString().trim();
                String datee=dateEditText.getText().toString().trim();
                String datee1=datepicker2.getText().toString().trim();
                String datee2=datepicker3.getText().toString().trim();
                String datee3=datepicker4.getText().toString().trim();
                String datee4=datepicker5.getText().toString().trim();
                String sl=slots.getText().toString().trim();
                String sl1=slot2.getText().toString().trim();
                String sl2=slot3.getText().toString().trim();
                String sl3=slot4.getText().toString().trim();
                String sl4=slot5.getText().toString().trim();

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

                String tm17=ed1.getText().toString().trim();
                String tm18=ed2.getText().toString().trim();
                String tm19=ed3.getText().toString().trim();
                String tm20=ed4.getText().toString().trim();
                String tm21=ed5.getText().toString().trim();
                String tm22=ed6.getText().toString().trim();
                String tm23=ed7.getText().toString().trim();
                String tm24=ed8.getText().toString().trim();
                String tm25=ed9.getText().toString().trim();
                String tm26=ed10.getText().toString().trim();
                String tm27=ed11.getText().toString().trim();
                String tm28=ed12.getText().toString().trim();
                String tm29=ed13.getText().toString().trim();
                String tm30=ed14.getText().toString().trim();
                String tm31=ed15.getText().toString().trim();
                String tm32=ed16.getText().toString().trim();


                String tm33=ed17.getText().toString().trim();
                String tm34=ed18.getText().toString().trim();
                String tm35=ed19.getText().toString().trim();
                String tm36=ed20.getText().toString().trim();
                String tm37=ed21.getText().toString().trim();
                String tm38=ed22.getText().toString().trim();
                String tm39=ed23.getText().toString().trim();
                String tm40=ed24.getText().toString().trim();
                String tm41=ed25.getText().toString().trim();
                String tm42=ed26.getText().toString().trim();
                String tm43=ed27.getText().toString().trim();
                String tm44=ed28.getText().toString().trim();
                String tm45=ed29.getText().toString().trim();
                String tm46=ed30.getText().toString().trim();
                String tm47=ed31.getText().toString().trim();
                String tm48=ed32.getText().toString().trim();


                String tm49=ed33.getText().toString().trim();
                String tm50=ed34.getText().toString().trim();
                String tm51=ed35.getText().toString().trim();
                String tm52=ed36.getText().toString().trim();
                String tm53=ed37.getText().toString().trim();
                String tm54=ed38.getText().toString().trim();
                String tm55=ed39.getText().toString().trim();
                String tm56=ed40.getText().toString().trim();
                String tm57=ed41.getText().toString().trim();
                String tm58=ed42.getText().toString().trim();
                String tm59=ed43.getText().toString().trim();
                String tm60=ed44.getText().toString().trim();
                String tm61=ed45.getText().toString().trim();
                String tm62=ed46.getText().toString().trim();
                String tm63=ed47.getText().toString().trim();
                String tm64=ed48.getText().toString().trim();

                String tm65=ed49.getText().toString().trim();
                String tm66=ed50.getText().toString().trim();
                String tm67=ed51.getText().toString().trim();
                String tm68=ed52.getText().toString().trim();
                String tm69=ed53.getText().toString().trim();
                String tm70=ed54.getText().toString().trim();
                String tm71=ed55.getText().toString().trim();
                String tm72=ed56.getText().toString().trim();
                String tm73=ed57.getText().toString().trim();
                String tm74=ed58.getText().toString().trim();
                String tm75=ed59.getText().toString().trim();
                String tm76=ed60.getText().toString().trim();
                String tm77=ed61.getText().toString().trim();
                String tm78=ed62.getText().toString().trim();
                String tm79=ed63.getText().toString().trim();
                String tm80=ed64.getText().toString().trim();





                if (!(fn.isEmpty()&&tm.isEmpty()&&spec.isEmpty()&&sl.isEmpty()&&sl1.isEmpty()&&sl2.isEmpty()&&sl3.isEmpty()&&sl4.isEmpty()&&tm1.isEmpty()&&tm2.isEmpty()&&tm3.isEmpty()&&tm4.isEmpty()&&tm5.isEmpty()&&tm6.isEmpty()&&tm7.isEmpty()&&tm8.isEmpty()&&tm9.isEmpty()&&tm11.isEmpty()&&tm12.isEmpty()&&tm13.isEmpty()&&tm14.isEmpty()&&tm15.isEmpty()&&tm16.isEmpty()&&datee.isEmpty()
                        &&datee1.isEmpty()&&datee2.isEmpty()&&datee3.isEmpty()&&datee4.isEmpty()
                        &&tm17.isEmpty()&&tm18.isEmpty()&&tm19.isEmpty()&&tm20.isEmpty()&&tm21.isEmpty()&&tm22.isEmpty()&&tm23.isEmpty()
                        &&tm24.isEmpty()&&tm25.isEmpty()&&tm26.isEmpty()&&tm27.isEmpty()&&tm28.isEmpty()&&tm29.isEmpty()&&tm30.isEmpty()
                        &&tm31.isEmpty()&&tm32.isEmpty()&&tm33.isEmpty()&&tm34.isEmpty()&&tm35.isEmpty()&&tm36.isEmpty()&&tm38.isEmpty()
                        &&tm39.isEmpty()&&tm40.isEmpty()&&tm41.isEmpty()&&tm42.isEmpty()&&tm43.isEmpty()&&tm44.isEmpty()&&tm45.isEmpty()
                        &&tm46.isEmpty()&&tm47.isEmpty()&&tm48.isEmpty()&&tm49.isEmpty()&&tm50.isEmpty()&&tm51.isEmpty()&&tm52.isEmpty()
                        &&tm53.isEmpty()&&tm54.isEmpty()&&tm55.isEmpty()&&tm56.isEmpty()&&tm57.isEmpty()&&tm58.isEmpty()&&tm59.isEmpty()
                        &&tm60.isEmpty()&&tm61.isEmpty()&&tm62.isEmpty()&&tm63.isEmpty()&&tm64.isEmpty()&&tm65.isEmpty()&&tm66.isEmpty()
                        &&tm67.isEmpty()&&tm68.isEmpty()&&tm69.isEmpty()&&tm70.isEmpty()&&tm71.isEmpty()&&tm72.isEmpty()&&tm73.isEmpty()
                        &&tm74.isEmpty()&&tm75.isEmpty()&&tm76.isEmpty()&&tm77.isEmpty()&&tm78.isEmpty()&&tm79.isEmpty()&&tm80.isEmpty()
                        &&imageUrl!=null))
                {
                    progressBar.setVisibility(View.VISIBLE);


                    StorageReference filepath=mStorage.getReference().child("Doctors Available").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Task<Uri> downloadUrl=taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    String t=task.getResult().toString();
                                    DatabaseReference newpost=mRef.push();

                                    newpost.child("Fullname").setValue(fn);
                                    newpost.child("Speciality").setValue(spec);
                                    newpost.child("Date").setValue(datee);
                                    newpost.child("Date1").setValue(datee1);
                                    newpost.child("Date2").setValue(datee2);
                                    newpost.child("Date3").setValue(datee3);
                                    newpost.child("Date4").setValue(datee4);
                                    newpost.child("Slots").setValue(sl);
                                    newpost.child("Slots2").setValue(sl1);
                                    newpost.child("Slots3").setValue(sl2);
                                    newpost.child("Slots4").setValue(sl3);
                                    newpost.child("Slots5").setValue(sl4);

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

                                    newpost.child("Ed1").setValue(tm17);
                                    newpost.child("Ed2").setValue(tm18);
                                    newpost.child("Ed3").setValue(tm19);
                                    newpost.child("Ed4").setValue(tm20);
                                    newpost.child("Ed5").setValue(tm21);
                                    newpost.child("Ed6").setValue(tm22);
                                    newpost.child("Ed7").setValue(tm23);
                                    newpost.child("Ed8").setValue(tm24);
                                    newpost.child("Ed9").setValue(tm25);
                                    newpost.child("Ed10").setValue(tm26);
                                    newpost.child("Ed11").setValue(tm27);
                                    newpost.child("Ed12").setValue(tm28);
                                    newpost.child("Ed13").setValue(tm29);
                                    newpost.child("Ed14").setValue(tm30);
                                    newpost.child("Ed15").setValue(tm31);
                                    newpost.child("Ed16").setValue(tm32);

                                    newpost.child("Ed17").setValue(tm33);
                                    newpost.child("Ed18").setValue(tm34);
                                    newpost.child("Ed19").setValue(tm35);
                                    newpost.child("Ed20").setValue(tm36);
                                    newpost.child("Ed21").setValue(tm37);
                                    newpost.child("Ed22").setValue(tm38);
                                    newpost.child("Ed23").setValue(tm39);
                                    newpost.child("Ed24").setValue(tm40);
                                    newpost.child("Ed25").setValue(tm41);
                                    newpost.child("Ed26").setValue(tm42);
                                    newpost.child("Ed27").setValue(tm43);
                                    newpost.child("Ed28").setValue(tm44);
                                    newpost.child("Ed29").setValue(tm45);
                                    newpost.child("Ed30").setValue(tm46);
                                    newpost.child("Ed31").setValue(tm47);
                                    newpost.child("Ed32").setValue(tm48);

                                    newpost.child("Ed33").setValue(tm49);
                                    newpost.child("Ed34").setValue(tm50);
                                    newpost.child("Ed35").setValue(tm51);
                                    newpost.child("Ed36").setValue(tm52);
                                    newpost.child("Ed37").setValue(tm53);
                                    newpost.child("Ed38").setValue(tm54);
                                    newpost.child("Ed39").setValue(tm55);
                                    newpost.child("Ed40").setValue(tm56);
                                    newpost.child("Ed41").setValue(tm57);
                                    newpost.child("Ed42").setValue(tm58);
                                    newpost.child("Ed43").setValue(tm59);
                                    newpost.child("Ed44").setValue(tm60);
                                    newpost.child("Ed45").setValue(tm61);
                                    newpost.child("Ed46").setValue(tm62);
                                    newpost.child("Ed47").setValue(tm63);
                                    newpost.child("Ed48").setValue(tm64);

                                    newpost.child("Ed49").setValue(tm65);
                                    newpost.child("Ed50").setValue(tm66);
                                    newpost.child("Ed51").setValue(tm67);
                                    newpost.child("Ed52").setValue(tm68);
                                    newpost.child("Ed53").setValue(tm69);
                                    newpost.child("Ed54").setValue(tm70);
                                    newpost.child("Ed55").setValue(tm71);
                                    newpost.child("Ed56").setValue(tm72);
                                    newpost.child("Ed57").setValue(tm73);
                                    newpost.child("Ed58").setValue(tm74);
                                    newpost.child("Ed59").setValue(tm75);
                                    newpost.child("Ed60").setValue(tm76);
                                    newpost.child("Ed61").setValue(tm77);
                                    newpost.child("Ed62").setValue(tm78);
                                    newpost.child("Ed63").setValue(tm79);
                                    newpost.child("Ed64").setValue(tm80);

                                    newpost.child("Image").setValue(task.getResult().toString());

                                    progressBar.setVisibility(View.GONE);
                                    fullname.setText("");
                                    dateEditText.setText("");




                                    Intent intent=new Intent(BookingTime.this,BookingTime.class);
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