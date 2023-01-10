package com.example.medica;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AppointmentHours extends AppCompatActivity implements  RecyclerViewInterface {
     LinearLayout Monday,Tuesday,Wednesday,Thursday,Friday;
    LinearLayout Monday2,Tuesday1,Wednesday1,Thursday1,Friday1;
    DentalDoctorAdapter dentalDoctorAdapter;
    List<DentalDoctorModel> dentalMdlList;
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_hours);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView showfullname=findViewById(R.id.showfullname);




        TextView morningslot1=findViewById(R.id.morningslot1);
        TextView afternoonslot1=findViewById(R.id.afternoonslot1);

        TextView morningslot2=findViewById(R.id.morningslot2);
        TextView afternoonslot2=findViewById(R.id.afternoonslot2);

        TextView morningslot3=findViewById(R.id.morningslot3);
        TextView afternoonslot3=findViewById(R.id.afternoonslot3);

        TextView morningslot4=findViewById(R.id.morningslot4);
        TextView afternoonslot4=findViewById(R.id.afternoonslot4);

        TextView morningslot5=findViewById(R.id.morningslot5);
        TextView afternoonslot5=findViewById(R.id.afternoonslot5);
        Monday=findViewById(R.id.Monday);
       Tuesday=findViewById(R.id.Tuesday);
        Wednesday=findViewById(R.id.Wednesday);
        Thursday=findViewById(R.id.Thursday);
        Friday=findViewById(R.id.Friday);
        Monday2=findViewById(R.id.Monday1);
        Tuesday1=findViewById(R.id.Tuesday1);
       Wednesday1=findViewById(R.id.Wednesday1);
        Thursday1=findViewById(R.id.Thursday1);
        Friday1=findViewById(R.id.Friday1);
        Monday2.setVisibility(View.INVISIBLE);
        Tuesday1.setVisibility(View.INVISIBLE);
        Wednesday1.setVisibility(View.INVISIBLE);
       Thursday1.setVisibility(View.INVISIBLE);
        Friday1.setVisibility(View.INVISIBLE);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView datetextView=findViewById(R.id.datee);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView slotstextView=findViewById(R.id.slots11);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView date1textView=findViewById(R.id.datee1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView slot2textView=findViewById(R.id.slots12);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView date2textView=findViewById(R.id.datee2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView slot3textView=findViewById(R.id.slots13);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView date3textView=findViewById(R.id.datee4);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView slot4textView=findViewById(R.id.slots14);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView date4textView=findViewById(R.id.datee5);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView slot5textView=findViewById(R.id.slots15);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})TextView slot6textView=findViewById(R.id.showspecial);
        ImageView showimage=findViewById(R.id.showImage);


        String fullname=getIntent().getStringExtra("Fullname");
        String speciality=getIntent().getStringExtra("Speciality");
        String date=getIntent().getStringExtra("Date");
        String slots=getIntent().getStringExtra("Slots");
        String date1=getIntent().getStringExtra("Date1");
        String slots2=getIntent().getStringExtra("Slots2");
        String date2=getIntent().getStringExtra("Date2");
        String slots3=getIntent().getStringExtra("Slots3");
        String date3=getIntent().getStringExtra("Date3");
        String slots4=getIntent().getStringExtra("Slots4");
        String date4=getIntent().getStringExtra("Date4");
        String slots5=getIntent().getStringExtra("Slots5");
        String image=getIntent().getStringExtra("Image");


        showfullname.setText(fullname);
        datetextView.setText(date);
        slotstextView.setText(slots);
        date1textView.setText(date1);
        slot2textView.setText(slots2);
        date2textView.setText(date2);
        slot3textView.setText(slots3);
        date3textView.setText(date3);
        slot4textView.setText(slots4);
        date4textView.setText(date4);
        slot5textView.setText(slots5);
        slot6textView.setText(speciality);

        String imageUri=null;
        imageUri= image;
        Picasso.get().load(imageUri).into(showimage);
        Monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Monday.setBackgroundResource(R.drawable.linear1);
               Friday.setBackgroundResource(R.drawable.linear);
                Thursday.setBackgroundResource(R.drawable.linear);
                Wednesday.setBackgroundResource(R.drawable.linear);
                Tuesday.setBackgroundResource(R.drawable.linear);
                Monday2.setVisibility(View.VISIBLE);
                Tuesday1.setVisibility(View.GONE);
                Wednesday1.setVisibility(View.GONE);
                Thursday1.setVisibility(View.GONE);
                Friday1.setVisibility(View.GONE);
                String alex=getIntent().getStringExtra("Alex");
                String betty=getIntent().getStringExtra("Betty");
                String can=getIntent().getStringExtra("Can");
                String done=getIntent().getStringExtra("Done");
                String earn=getIntent().getStringExtra("Earn");
                String fay=getIntent().getStringExtra("Fay");
                String gal=getIntent().getStringExtra("Gal");
                String hug=getIntent().getStringExtra("Hug");
                String ian=getIntent().getStringExtra("Ian");
                String jack=getIntent().getStringExtra("Jack");
                String kyali=getIntent().getStringExtra("Kyali");
                String lime=getIntent().getStringExtra("Lime");
                String mine=getIntent().getStringExtra("Mine");
                String nike=getIntent().getStringExtra("Nike");
                String org=getIntent().getStringExtra("Org");
                String rap=getIntent().getStringExtra("Rap");

                TextView alextextView=findViewById(R.id.btn1);
                alextextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = alextextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView bettytextView=findViewById(R.id.btn2);
                bettytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = bettytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView cantextView=findViewById(R.id.btn3);
                cantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = cantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);


                    }
                });
                TextView donetextView=findViewById(R.id.btn4);
              donetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = donetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView earntextView=findViewById(R.id.btn5);
               earntextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = earntextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView faytextView=findViewById(R.id.btn6);
               faytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = faytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView galtextView=findViewById(R.id.btn7);
                galtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = galtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView hugtextView=findViewById(R.id.btn8);
                hugtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = hugtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView iantextView=findViewById(R.id.btn9);
                iantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = iantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);;
                    }
                });
                TextView jacktextView=findViewById(R.id.btn11);
                jacktextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = jacktextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView kyalitextView=findViewById(R.id.btn12);
                kyalitextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = kyalitextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView limetextView=findViewById(R.id.btn13);
                limetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = limetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView minetextView=findViewById(R.id.btn14);
                minetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = minetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView niketextView=findViewById(R.id.btn15);
                niketextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = niketextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView orgtextView=findViewById(R.id.btn16);
                orgtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = orgtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView raptextView=findViewById(R.id.btn17);
                raptextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date;
                        String str3 = slots;
                        String str = raptextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
               // if (alex.isEmpty()||betty.isEmpty()||can.isEmpty()||done.isEmpty()||earn.isEmpty()||fay.isEmpty()
              //  ||gal.isEmpty()||hug.isEmpty()){
                  //  morningslot1.setText("No available slots for Morning");
              //  }else {
                   // morningslot1.setVisibility(View.VISIBLE);
             //   }
              //  if (ian.isEmpty()||jack.isEmpty()||kyali.isEmpty()||lime.isEmpty()||mine.isEmpty()||nike.isEmpty()
             //           ||org.isEmpty()||rap.isEmpty()){
                   // afternoonslot1.setVisibility(View.GONE);
               // }else {
                //    afternoonslot1.setVisibility(View.VISIBLE);
               // }


                showfullname.setText(fullname);

                alextextView.setText(alex);
                if (alex.isEmpty()){
                    alextextView.setVisibility(View.GONE);
                }
                bettytextView.setText(betty);
                if (betty.isEmpty()){
                    bettytextView.setVisibility(View.GONE);
                }
                cantextView.setText(can);
                if (can.isEmpty()){
                    cantextView.setVisibility(View.GONE);
                }
                donetextView.setText(done);
                if (done.isEmpty()){
                    donetextView.setVisibility(View.GONE);
                }
                earntextView.setText(earn);
                if (earn.isEmpty()){
                    earntextView.setVisibility(View.GONE);
                }
                faytextView.setText(fay);
                if (fay.isEmpty()){
                    faytextView.setVisibility(View.GONE);
                }
                galtextView.setText(gal);
                if (gal.isEmpty()){
                    galtextView.setVisibility(View.GONE);
                }
                hugtextView.setText(hug);
                if (hug.isEmpty()){
                    hugtextView.setVisibility(View.GONE);
                }
                iantextView.setText(ian);
                if (ian.isEmpty()){
                    iantextView.setVisibility(View.GONE);
                }
                jacktextView.setText(jack);
                if (jack.isEmpty()){
                    jacktextView.setVisibility(View.GONE);
                }
                kyalitextView.setText(kyali);
                if (kyali.isEmpty()){
                    kyalitextView.setVisibility(View.GONE);
                }
                limetextView.setText(lime);
                if (lime.isEmpty()){
                    limetextView.setVisibility(View.GONE);
                }
                minetextView.setText(mine);
                if (mine.isEmpty()){
                    minetextView.setVisibility(View.GONE);
                }
                niketextView.setText(nike);
                if (nike.isEmpty()){
                    niketextView.setVisibility(View.GONE);
                }
                orgtextView.setText(org);
                if (org.isEmpty()){
                    orgtextView.setVisibility(View.GONE);
                }
                raptextView.setText(rap);
                if (rap.isEmpty()){
                    raptextView.setVisibility(View.GONE);
                }

            }
        });
        Tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tuesday.setBackgroundResource(R.drawable.linear1);
                Friday.setBackgroundResource(R.drawable.linear);
                Thursday.setBackgroundResource(R.drawable.linear);
                Wednesday.setBackgroundResource(R.drawable.linear);
                Monday.setBackgroundResource(R.drawable.linear);
                Tuesday1.setVisibility(View.VISIBLE);
               Monday2.setVisibility(View.GONE);
                Wednesday1.setVisibility(View.GONE);
                Thursday1.setVisibility(View.GONE);
                Friday1.setVisibility(View.GONE);
                String ed1=getIntent().getStringExtra("Ed1");
                String ed2=getIntent().getStringExtra("Ed2");
                String ed3=getIntent().getStringExtra("Ed3");
                String ed4=getIntent().getStringExtra("Ed4");
                String ed5=getIntent().getStringExtra("Ed5");
                String ed6=getIntent().getStringExtra("Ed6");
                String ed7=getIntent().getStringExtra("Ed7");
                String ed8=getIntent().getStringExtra("Ed8");
                String ed9=getIntent().getStringExtra("Ed9");
                String ed10=getIntent().getStringExtra("Ed10");
                String ed11=getIntent().getStringExtra("Ed11");
                String ed12=getIntent().getStringExtra("Ed12");
                String ed13=getIntent().getStringExtra("Ed13");
                String ed14=getIntent().getStringExtra("Ed14");
                String ed15=getIntent().getStringExtra("Ed15");
                String ed16=getIntent().getStringExtra("Ed16");
                TextView alextextView=findViewById(R.id.btn18);
                alextextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = alextextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView bettytextView=findViewById(R.id.btn19);
                bettytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = bettytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView cantextView=findViewById(R.id.btn20);
                cantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = cantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);


                    }
                });
                TextView donetextView=findViewById(R.id.btn21);
                donetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = donetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView earntextView=findViewById(R.id.btn22);
                earntextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = earntextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView faytextView=findViewById(R.id.btn23);
                faytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = faytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView galtextView=findViewById(R.id.btn24);
                galtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = galtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView hugtextView=findViewById(R.id.btn25);
                hugtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = hugtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView iantextView=findViewById(R.id.btn26);
                iantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = iantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);;
                    }
                });
                TextView jacktextView=findViewById(R.id.btn27);
                jacktextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = jacktextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView kyalitextView=findViewById(R.id.btn28);
                kyalitextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = kyalitextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView limetextView=findViewById(R.id.btn29);
                limetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = limetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView minetextView=findViewById(R.id.btn30);
                minetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = minetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView niketextView=findViewById(R.id.btn31);
                niketextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = niketextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView orgtextView=findViewById(R.id.btn32);
                orgtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = orgtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView raptextView=findViewById(R.id.btn33);
                raptextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date1;
                        String str3 = slots2;
                        String str = raptextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });


                showfullname.setText(fullname);
                // if (ed1.isEmpty()||ed2.isEmpty()||ed3.isEmpty()||ed4.isEmpty()||ed5.isEmpty()||ed6.isEmpty()
                //        ||ed7.isEmpty()||ed8.isEmpty()){
                //    morningslot2.setVisibility(View.GONE);
                //  }
                //  if (ed9.isEmpty()||ed10.isEmpty()||ed11.isEmpty()||ed12.isEmpty()||ed13.isEmpty()||ed14.isEmpty()
                //     ||ed15.isEmpty()||ed16.isEmpty()){
                //   afternoonslot2.setVisibility(View.GONE);
                //  }


                alextextView.setText(ed1);
                if (ed1.isEmpty()){
                    alextextView.setVisibility(View.GONE);
                }
                bettytextView.setText(ed2);
                if (ed2.isEmpty()){
                    bettytextView.setVisibility(View.GONE);
                }
                cantextView.setText(ed3);
                if (ed3.isEmpty()){
                    cantextView.setVisibility(View.GONE);
                }
                donetextView.setText(ed4);
                if (ed4.isEmpty()){
                    donetextView.setVisibility(View.GONE);
                }
                earntextView.setText(ed5);
                if (ed5.isEmpty()){
                    earntextView.setVisibility(View.GONE);
                }
                faytextView.setText(ed6);
                if (ed6.isEmpty()){
                    faytextView.setVisibility(View.GONE);
                }
                galtextView.setText(ed7);
                if (ed7.isEmpty()){
                    galtextView.setVisibility(View.GONE);
                }
                hugtextView.setText(ed8);
                if (ed8.isEmpty()){
                    hugtextView.setVisibility(View.GONE);
                }
                iantextView.setText(ed9);
                if (ed9.isEmpty()){
                    iantextView.setVisibility(View.GONE);
                }
                jacktextView.setText(ed10);
                if (ed10.isEmpty()){
                    jacktextView.setVisibility(View.GONE);
                }
                kyalitextView.setText(ed11);
                if (ed11.isEmpty()){
                    kyalitextView.setVisibility(View.GONE);
                }
                limetextView.setText(ed12);
                if (ed12.isEmpty()){
                    limetextView.setVisibility(View.GONE);
                }
                minetextView.setText(ed13);
                if (ed13.isEmpty()){
                    minetextView.setVisibility(View.GONE);
                }
                niketextView.setText(ed14);
                if (ed14.isEmpty()){
                    niketextView.setVisibility(View.GONE);
                }
                orgtextView.setText(ed15);
                if (ed15.isEmpty()){
                    orgtextView.setVisibility(View.GONE);
                }
                raptextView.setText(ed16);
                if (ed16.isEmpty()){
                    raptextView.setVisibility(View.GONE);
                }

            }
        });
        Wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Wednesday.setBackgroundResource(R.drawable.linear1);
                Friday.setBackgroundResource(R.drawable.linear);
                Thursday.setBackgroundResource(R.drawable.linear);
                Monday.setBackgroundResource(R.drawable.linear);
                Tuesday.setBackgroundResource(R.drawable.linear);
                Wednesday1.setVisibility(View.VISIBLE);
                Monday2.setVisibility(View.GONE);
                Tuesday1.setVisibility(View.GONE);
                Thursday1.setVisibility(View.GONE);
                Friday1.setVisibility(View.GONE);
                String ed17=getIntent().getStringExtra("Ed17");
                String ed18=getIntent().getStringExtra("Ed18");
                String ed19=getIntent().getStringExtra("Ed19");
                String ed20=getIntent().getStringExtra("Ed20");
                String ed21=getIntent().getStringExtra("Ed21");
                String ed22=getIntent().getStringExtra("Ed22");
                String ed23=getIntent().getStringExtra("Ed23");
                String ed24=getIntent().getStringExtra("Ed24");
                String ed25=getIntent().getStringExtra("Ed25");
                String ed26=getIntent().getStringExtra("Ed26");
                String ed27=getIntent().getStringExtra("Ed27");
                String ed28=getIntent().getStringExtra("Ed28");
                String ed29=getIntent().getStringExtra("Ed29");
                String ed30=getIntent().getStringExtra("Ed30");
                String ed31=getIntent().getStringExtra("Ed31");
                String ed32=getIntent().getStringExtra("Ed32");

                TextView alextextView=findViewById(R.id.btn34);
                alextextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = alextextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView bettytextView=findViewById(R.id.btn35);
                bettytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = bettytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView cantextView=findViewById(R.id.btn36);
                cantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = cantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);


                    }
                });
                TextView donetextView=findViewById(R.id.btn37);
                donetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = donetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView earntextView=findViewById(R.id.btn38);
                earntextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = earntextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView faytextView=findViewById(R.id.btn39);
                faytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = faytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView galtextView=findViewById(R.id.btn40);
                galtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = galtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView hugtextView=findViewById(R.id.btn41);
                hugtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = hugtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView iantextView=findViewById(R.id.btn42);
                iantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = iantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);;
                    }
                });
                TextView jacktextView=findViewById(R.id.btn43);
                jacktextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = jacktextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView kyalitextView=findViewById(R.id.btn44);
                kyalitextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = kyalitextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView limetextView=findViewById(R.id.btn45);
                limetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = limetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView minetextView=findViewById(R.id.btn46);
                minetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = minetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView niketextView=findViewById(R.id.btn47);
                niketextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = niketextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView orgtextView=findViewById(R.id.btn48);
                orgtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = orgtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView raptextView=findViewById(R.id.btn49);
                raptextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date2;
                        String str3 = slots3;
                        String str = raptextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });

                showfullname.setText(fullname);
                // if (ed17.isEmpty()||ed18.isEmpty()||ed19.isEmpty()||ed20.isEmpty()||ed21.isEmpty()||ed22.isEmpty()
                //          ||ed23.isEmpty()||ed24.isEmpty()){
                //     morningslot3.setVisibility(View.GONE);
                //  }
                //   if (ed25.isEmpty()||ed26.isEmpty()||ed27.isEmpty()||ed28.isEmpty()||ed29.isEmpty()||ed30.isEmpty()
                //          ||ed31.isEmpty()||ed32.isEmpty()){
                //      afternoonslot3.setVisibility(View.GONE);
                //  }

                alextextView.setText(ed17);
                if (ed17.isEmpty()){
                    alextextView.setVisibility(View.GONE);
                }
                bettytextView.setText(ed18);
                if (ed18.isEmpty()){
                    bettytextView.setVisibility(View.GONE);
                }
                cantextView.setText(ed19);
                if (ed19.isEmpty()){
                    cantextView.setVisibility(View.GONE);
                }
                donetextView.setText(ed20);
                if (ed20.isEmpty()){
                    donetextView.setVisibility(View.GONE);
                }
                earntextView.setText(ed21);
                if (ed21.isEmpty()){
                    earntextView.setVisibility(View.GONE);
                }
                faytextView.setText(ed22);
                if (ed22.isEmpty()){
                    faytextView.setVisibility(View.GONE);
                }
                galtextView.setText(ed23);
                if (ed23.isEmpty()){
                    galtextView.setVisibility(View.GONE);
                }
                hugtextView.setText(ed24);
                if (ed24.isEmpty()){
                    hugtextView.setVisibility(View.GONE);
                }
                iantextView.setText(ed25);
                if (ed25.isEmpty()){
                    iantextView.setVisibility(View.GONE);
                }
                jacktextView.setText(ed26);
                if (ed26.isEmpty()){
                    jacktextView.setVisibility(View.GONE);
                }
                kyalitextView.setText(ed27);
                if (ed27.isEmpty()){
                    kyalitextView.setVisibility(View.GONE);
                }
                limetextView.setText(ed28);
                if (ed28.isEmpty()){
                    limetextView.setVisibility(View.GONE);
                }
                minetextView.setText(ed29);
                if (ed29.isEmpty()){
                    minetextView.setVisibility(View.GONE);
                }
                niketextView.setText(ed30);
                if (ed30.isEmpty()){
                    niketextView.setVisibility(View.GONE);
                }
                orgtextView.setText(ed31);
                if (ed31.isEmpty()){
                    orgtextView.setVisibility(View.GONE);
                }
                raptextView.setText(ed32);
                if (ed32.isEmpty()){
                    raptextView.setVisibility(View.GONE);
                }

            }
        });
        Thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thursday.setBackgroundResource(R.drawable.linear1);
                Friday.setBackgroundResource(R.drawable.linear);
                Wednesday.setBackgroundResource(R.drawable.linear);
                Monday.setBackgroundResource(R.drawable.linear);
                Tuesday.setBackgroundResource(R.drawable.linear);
                Thursday1.setVisibility(View.VISIBLE);
                Monday2.setVisibility(View.GONE);
                Tuesday1.setVisibility(View.GONE);
                Wednesday1.setVisibility(View.GONE);
                Friday1.setVisibility(View.GONE);
                String ed33=getIntent().getStringExtra("Ed33");
                String ed34=getIntent().getStringExtra("Ed34");
                String ed35=getIntent().getStringExtra("Ed35");
                String ed36=getIntent().getStringExtra("Ed36");
                String ed37=getIntent().getStringExtra("Ed37");
                String ed38=getIntent().getStringExtra("Ed38");
                String ed39=getIntent().getStringExtra("Ed39");
                String ed40=getIntent().getStringExtra("Ed40");
                String ed41=getIntent().getStringExtra("Ed41");
                String ed42=getIntent().getStringExtra("Ed42");
                String ed43=getIntent().getStringExtra("Ed43");
                String ed44=getIntent().getStringExtra("Ed44");
                String ed45=getIntent().getStringExtra("Ed45");
                String ed46=getIntent().getStringExtra("Ed46");
                String ed47=getIntent().getStringExtra("Ed47");
                String ed48=getIntent().getStringExtra("Ed48");

                TextView alextextView=findViewById(R.id.btn50);
                alextextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = alextextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView bettytextView=findViewById(R.id.btn51);
                bettytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = bettytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView cantextView=findViewById(R.id.btn52);
                cantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = cantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);


                    }
                });
                TextView donetextView=findViewById(R.id.btn53);
                donetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = donetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView earntextView=findViewById(R.id.btn54);
                earntextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = earntextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView faytextView=findViewById(R.id.btn55);
                faytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = faytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView galtextView=findViewById(R.id.btn56);
                galtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = galtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView hugtextView=findViewById(R.id.btn57);
                hugtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = hugtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView iantextView=findViewById(R.id.btn58);
                iantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = iantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);;
                    }
                });
                TextView jacktextView=findViewById(R.id.btn59);
                jacktextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = jacktextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView kyalitextView=findViewById(R.id.btn60);
                kyalitextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = kyalitextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView limetextView=findViewById(R.id.btn61);
                limetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = limetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView minetextView=findViewById(R.id.btn62);
                minetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = minetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView niketextView=findViewById(R.id.btn63);
                niketextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = niketextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView orgtextView=findViewById(R.id.btn64);
                orgtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = orgtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView raptextView=findViewById(R.id.btn65);
                raptextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date3;
                        String str3 = slots4;
                        String str = raptextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });

                showfullname.setText(fullname);
                // if (ed33.isEmpty()||ed34.isEmpty()||ed35.isEmpty()||ed36.isEmpty()||ed37.isEmpty()||ed38.isEmpty()
                //         ||ed39.isEmpty()||ed40.isEmpty()){
                //    morningslot4.setVisibility(View.GONE);
                //  }
                // if (ed41.isEmpty()||ed42.isEmpty()||ed43.isEmpty()||ed44.isEmpty()||ed45.isEmpty()||ed46.isEmpty()
                //         ||ed47.isEmpty()||ed48.isEmpty()){
                //      afternoonslot4.setVisibility(View.GONE);
                //  }

                alextextView.setText(ed33);
                if (ed33.isEmpty()){
                    alextextView.setVisibility(View.GONE);
                }
                bettytextView.setText(ed34);
                if (ed34.isEmpty()){
                    bettytextView.setVisibility(View.GONE);
                }
                cantextView.setText(ed35);
                if (ed35.isEmpty()){
                    cantextView.setVisibility(View.GONE);
                }
                donetextView.setText(ed36);
                if (ed36.isEmpty()){
                    donetextView.setVisibility(View.GONE);
                }
                earntextView.setText(ed37);
                if (ed37.isEmpty()){
                    earntextView.setVisibility(View.GONE);
                }
                faytextView.setText(ed38);
                if (ed38.isEmpty()){
                    faytextView.setVisibility(View.GONE);
                }
                galtextView.setText(ed39);
                if (ed39.isEmpty()){
                    galtextView.setVisibility(View.GONE);
                }
                hugtextView.setText(ed40);
                if (ed40.isEmpty()){
                    hugtextView.setVisibility(View.GONE);
                }
                iantextView.setText(ed41);
                if (ed41.isEmpty()){
                    iantextView.setVisibility(View.GONE);
                }
                jacktextView.setText(ed42);
                if (ed42.isEmpty()){
                    jacktextView.setVisibility(View.GONE);
                }
                kyalitextView.setText(ed43);
                if (ed43.isEmpty()){
                    kyalitextView.setVisibility(View.GONE);
                }
                limetextView.setText(ed44);
                if (ed44.isEmpty()){
                    limetextView.setVisibility(View.GONE);
                }
                minetextView.setText(ed45);
                if (ed45.isEmpty()){
                    minetextView.setVisibility(View.GONE);
                }
                niketextView.setText(ed46);
                if (ed46.isEmpty()){
                    niketextView.setVisibility(View.GONE);
                }
                orgtextView.setText(ed47);
                if (ed47.isEmpty()){
                    orgtextView.setVisibility(View.GONE);
                }
                raptextView.setText(ed48);
                if (ed48.isEmpty()){
                    raptextView.setVisibility(View.GONE);
                }

            }
        });
        Friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friday.setBackgroundResource(R.drawable.linear1);
               Thursday.setBackgroundResource(R.drawable.linear);
                Wednesday.setBackgroundResource(R.drawable.linear);
                Monday.setBackgroundResource(R.drawable.linear);
                Tuesday.setBackgroundResource(R.drawable.linear);
                Friday1.setVisibility(View.VISIBLE);
                Monday2.setVisibility(View.GONE);
                Tuesday1.setVisibility(View.GONE);
                Wednesday1.setVisibility(View.GONE);
                Thursday1.setVisibility(View.GONE);
                String ed49=getIntent().getStringExtra("Ed49");
                String ed50=getIntent().getStringExtra("Ed50");
                String ed51=getIntent().getStringExtra("Ed51");
                String ed52=getIntent().getStringExtra("Ed52");
                String ed53=getIntent().getStringExtra("Ed53");
                String ed54=getIntent().getStringExtra("Ed54");
                String ed55=getIntent().getStringExtra("Ed55");
                String ed56=getIntent().getStringExtra("Ed56");
                String ed57=getIntent().getStringExtra("Ed57");
                String ed58=getIntent().getStringExtra("Ed58");
                String ed59=getIntent().getStringExtra("Ed59");
                String ed60=getIntent().getStringExtra("Ed60");
                String ed61=getIntent().getStringExtra("Ed61");
                String ed62=getIntent().getStringExtra("Ed62");
                String ed63=getIntent().getStringExtra("Ed63");
                String ed64=getIntent().getStringExtra("Ed64");

              TextView alextextView=findViewById(R.id.btn66);
                alextextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = alextextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView bettytextView=findViewById(R.id.btn67);
                bettytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = bettytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView cantextView=findViewById(R.id.btn68);
                cantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = cantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);


                    }
                });
                TextView donetextView=findViewById(R.id.btn69);
                donetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = donetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView earntextView=findViewById(R.id.btn70);
                earntextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = earntextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView faytextView=findViewById(R.id.btn71);
                faytextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = faytextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView galtextView=findViewById(R.id.btn72);
                galtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = galtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView hugtextView=findViewById(R.id.btn73);
                hugtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = hugtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView iantextView=findViewById(R.id.btn74);
                iantextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = iantextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);;
                    }
                });
                TextView jacktextView=findViewById(R.id.btn75);
                jacktextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = jacktextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView kyalitextView=findViewById(R.id.btn76);
                kyalitextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = kyalitextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView limetextView=findViewById(R.id.btn77);
                limetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = limetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView minetextView=findViewById(R.id.btn78);
                minetextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = minetextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView niketextView=findViewById(R.id.btn79);
                niketextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = niketextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView orgtextView=findViewById(R.id.btn80);
                orgtextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = orgtextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });
                TextView raptextView=findViewById(R.id.btn81);
                raptextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str1 = fullname;
                        String str2 = date4;
                        String str3 = slots5;
                        String str = raptextView.getText().toString();
                        Intent intent = new Intent(getApplicationContext(), SendOTPActivity.class);
                        intent.putExtra("message_key", str);
                        intent.putExtra("message_fullname", str1);
                        intent.putExtra("message_date", str2);
                        intent.putExtra("message_slots", str3);
                        // start the Intent
                        startActivity(intent);
                    }
                });

                showfullname.setText(fullname);
                //  if (ed49.isEmpty()||ed50.isEmpty()||ed51.isEmpty()||ed52.isEmpty()||ed53.isEmpty()||ed54.isEmpty()
                //         ||ed55.isEmpty()||ed56.isEmpty()){
                //    morningslot5.setVisibility(View.GONE);
                //  }
                //  if (ed57.isEmpty()||ed58.isEmpty()||ed59.isEmpty()||ed60.isEmpty()||ed61.isEmpty()||ed62.isEmpty()
                //        ||ed63.isEmpty()||ed64.isEmpty()){
                //    afternoonslot5.setVisibility(View.GONE);
                //  }

                alextextView.setText(ed49);
                if (ed49.isEmpty()){
                    alextextView.setVisibility(View.GONE);
                }
                bettytextView.setText(ed50);
                if (ed50.isEmpty()){
                    bettytextView.setVisibility(View.GONE);
                }
                cantextView.setText(ed51);
                if (ed51.isEmpty()){
                    cantextView.setVisibility(View.GONE);
                }
                donetextView.setText(ed52);
                if (ed52.isEmpty()){
                    donetextView.setVisibility(View.GONE);
                }
                earntextView.setText(ed53);
                if (ed53.isEmpty()){
                    earntextView.setVisibility(View.GONE);
                }
                faytextView.setText(ed54);
                if (ed54.isEmpty()){
                    faytextView.setVisibility(View.GONE);
                }
                galtextView.setText(ed55);
                if (ed55.isEmpty()){
                    galtextView.setVisibility(View.GONE);
                }
                hugtextView.setText(ed56);
                if (ed56.isEmpty()){
                    hugtextView.setVisibility(View.GONE);
                }
                iantextView.setText(ed57);
                if (ed57.isEmpty()){
                    iantextView.setVisibility(View.GONE);
                }
                jacktextView.setText(ed58);
                if (ed58.isEmpty()){
                    jacktextView.setVisibility(View.GONE);
                }
                kyalitextView.setText(ed59);
                if (ed59.isEmpty()){
                    kyalitextView.setVisibility(View.GONE);
                }
                limetextView.setText(ed60);
                if (ed60.isEmpty()){
                    limetextView.setVisibility(View.GONE);
                }
                minetextView.setText(ed61);
                if (ed61.isEmpty()){
                    minetextView.setVisibility(View.GONE);
                }
                niketextView.setText(ed62);
                if (ed62.isEmpty()){
                    niketextView.setVisibility(View.GONE);
                }
                orgtextView.setText(ed63);
                if (ed63.isEmpty()){
                    orgtextView.setVisibility(View.GONE);
                }
                raptextView.setText(ed64);
                if (ed64.isEmpty()){
                    raptextView.setVisibility(View.GONE);
                }

            }
        });



    }
    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(AppointmentHours.this,SendOTPActivity.class);
        intent.putExtra("Fullname",dentalMdlList.get(position).getFullname());
        intent.putExtra("Image",dentalMdlList.get(position).getImage());
        intent.putExtra("Date",dentalMdlList.get(position).getDate());
        intent.putExtra("Slots",dentalMdlList.get(position).getSlots());
        intent.putExtra("Date1",dentalMdlList.get(position).getDate1());
        intent.putExtra("Slots2",dentalMdlList.get(position).getSlots2());
        intent.putExtra("Date2",dentalMdlList.get(position).getDate2());
        intent.putExtra("Slots3",dentalMdlList.get(position).getSlots3());
        intent.putExtra("Date3",dentalMdlList.get(position).getDate3());
        intent.putExtra("Slots4",dentalMdlList.get(position).getSlots4());
        intent.putExtra("Date4",dentalMdlList.get(position).getDate4());
        intent.putExtra("Slots5",dentalMdlList.get(position).getSlots5());


        intent.putExtra("Alex",dentalMdlList.get(position).getAlex());
        intent.putExtra("Betty",dentalMdlList.get(position).getBetty());
        intent.putExtra("Can",dentalMdlList.get(position).getCan());
        intent.putExtra("Done",dentalMdlList.get(position).getDone());
        intent.putExtra("Earn",dentalMdlList.get(position).getEarn());
        intent.putExtra("Fay",dentalMdlList.get(position).getFay());
        intent.putExtra("Gal",dentalMdlList.get(position).getGal());
        intent.putExtra("Hug",dentalMdlList.get(position).getHug());
        intent.putExtra("Ian",dentalMdlList.get(position).getIan());
        intent.putExtra("Jack",dentalMdlList.get(position).getJack());
        intent.putExtra("Kyali",dentalMdlList.get(position).getKyali());
        intent.putExtra("Lime",dentalMdlList.get(position).getLime());
        intent.putExtra("Mine",dentalMdlList.get(position).getMine());
        intent.putExtra("Nike",dentalMdlList.get(position).getNike());
        intent.putExtra("Org",dentalMdlList.get(position).getOrg());
        intent.putExtra("Rap",dentalMdlList.get(position).getRap());

        intent.putExtra("Ed1",dentalMdlList.get(position).getEd1());
        intent.putExtra("Ed2",dentalMdlList.get(position).getEd2());
        intent.putExtra("Ed3",dentalMdlList.get(position).getEd3());
        intent.putExtra("Ed4",dentalMdlList.get(position).getEd4());
        intent.putExtra("Ed5",dentalMdlList.get(position).getEd5());
        intent.putExtra("Ed6",dentalMdlList.get(position).getEd6());
        intent.putExtra("Ed7",dentalMdlList.get(position).getEd7());
        intent.putExtra("Ed8",dentalMdlList.get(position).getEd8());
        intent.putExtra("Ed9",dentalMdlList.get(position).getEd9());
        intent.putExtra("Ed10",dentalMdlList.get(position).getEd10());
        intent.putExtra("Ed11",dentalMdlList.get(position).getEd11());
        intent.putExtra("Ed12",dentalMdlList.get(position).getEd12());
        intent.putExtra("Ed13",dentalMdlList.get(position).getEd13());
        intent.putExtra("Ed14",dentalMdlList.get(position).getEd14());
        intent.putExtra("Ed15",dentalMdlList.get(position).getEd15());
        intent.putExtra("Ed16",dentalMdlList.get(position).getEd16());

        intent.putExtra("Ed17",dentalMdlList.get(position).getEd17());
        intent.putExtra("Ed18",dentalMdlList.get(position).getEd18());
        intent.putExtra("Ed19",dentalMdlList.get(position).getEd19());
        intent.putExtra("Ed20",dentalMdlList.get(position).getEd20());
        intent.putExtra("Ed21",dentalMdlList.get(position).getEd21());
        intent.putExtra("Ed22",dentalMdlList.get(position).getEd22());
        intent.putExtra("Ed23",dentalMdlList.get(position).getEd23());
        intent.putExtra("Ed24",dentalMdlList.get(position).getEd24());
        intent.putExtra("Ed25",dentalMdlList.get(position).getEd25());
        intent.putExtra("Ed26",dentalMdlList.get(position).getEd26());
        intent.putExtra("Ed27",dentalMdlList.get(position).getEd27());
        intent.putExtra("Ed28",dentalMdlList.get(position).getEd28());
        intent.putExtra("Ed29",dentalMdlList.get(position).getEd29());
        intent.putExtra("Ed30",dentalMdlList.get(position).getEd30());
        intent.putExtra("Ed31",dentalMdlList.get(position).getEd31());
        intent.putExtra("Ed32",dentalMdlList.get(position).getEd32());

        intent.putExtra("Ed33",dentalMdlList.get(position).getEd33());
        intent.putExtra("Ed34",dentalMdlList.get(position).getEd34());
        intent.putExtra("Ed35",dentalMdlList.get(position).getEd35());
        intent.putExtra("Ed36",dentalMdlList.get(position).getEd36());
        intent.putExtra("Ed37",dentalMdlList.get(position).getEd37());
        intent.putExtra("Ed38",dentalMdlList.get(position).getEd38());
        intent.putExtra("Ed39",dentalMdlList.get(position).getEd39());
        intent.putExtra("Ed40",dentalMdlList.get(position).getEd40());
        intent.putExtra("Ed41",dentalMdlList.get(position).getEd41());
        intent.putExtra("Ed42",dentalMdlList.get(position).getEd42());
        intent.putExtra("Ed43",dentalMdlList.get(position).getEd43());
        intent.putExtra("Ed44",dentalMdlList.get(position).getEd44());
        intent.putExtra("Ed45",dentalMdlList.get(position).getEd45());
        intent.putExtra("Ed46",dentalMdlList.get(position).getEd46());
        intent.putExtra("Ed47",dentalMdlList.get(position).getEd47());
        intent.putExtra("Ed48",dentalMdlList.get(position).getEd48());

        intent.putExtra("Ed49",dentalMdlList.get(position).getEd49());
        intent.putExtra("Ed50",dentalMdlList.get(position).getEd50());
        intent.putExtra("Ed51",dentalMdlList.get(position).getEd51());
        intent.putExtra("Ed52",dentalMdlList.get(position).getEd52());
        intent.putExtra("Ed53",dentalMdlList.get(position).getEd53());
        intent.putExtra("Ed54",dentalMdlList.get(position).getEd54());
        intent.putExtra("Ed55",dentalMdlList.get(position).getEd55());
        intent.putExtra("Ed56",dentalMdlList.get(position).getEd56());
        intent.putExtra("Ed57",dentalMdlList.get(position).getEd57());
        intent.putExtra("Ed58",dentalMdlList.get(position).getEd58());
        intent.putExtra("Ed59",dentalMdlList.get(position).getEd59());
        intent.putExtra("Ed60",dentalMdlList.get(position).getEd60());
        intent.putExtra("Ed61",dentalMdlList.get(position).getEd61());
        intent.putExtra("Ed62",dentalMdlList.get(position).getEd62());
        intent.putExtra("Ed63",dentalMdlList.get(position).getEd63());
        intent.putExtra("Ed64",dentalMdlList.get(position).getEd64());

        startActivity(intent);

    }


}