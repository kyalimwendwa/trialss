package com.example.medica;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowTime extends AppCompatActivity {
Button confirmAppointment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time);

        String fullname=getIntent().getStringExtra("Fullname");
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


        TextView showfullname=findViewById(R.id.showfullname);

        TextView alextextView=findViewById(R.id.btn1);
        TextView bettytextView=findViewById(R.id.btn2);
        TextView cantextView=findViewById(R.id.btn3);
        TextView donetextView=findViewById(R.id.btn4);
        TextView earntextView=findViewById(R.id.btn5);
        TextView faytextView=findViewById(R.id.btn6);
        TextView galtextView=findViewById(R.id.btn7);
        TextView hugtextView=findViewById(R.id.btn8);
        TextView iantextView=findViewById(R.id.btn9);
        TextView jacktextView=findViewById(R.id.btn11);
        TextView kyalitextView=findViewById(R.id.btn12);
        TextView limetextView=findViewById(R.id.btn13);
        TextView minetextView=findViewById(R.id.btn14);
        TextView niketextView=findViewById(R.id.btn15);
        TextView orgtextView=findViewById(R.id.btn16);
        TextView raptextView=findViewById(R.id.btn17);


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


}