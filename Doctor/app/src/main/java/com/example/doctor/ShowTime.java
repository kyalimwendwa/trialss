package com.example.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowTime extends AppCompatActivity {

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
        bettytextView.setText(betty);
        cantextView.setText(can);
        donetextView.setText(done);
        earntextView.setText(earn);
        faytextView.setText(fay);
        galtextView.setText(gal);
        hugtextView.setText(hug);
        iantextView.setText(ian);
        jacktextView.setText(jack);
        kyalitextView.setText(kyali);
        limetextView.setText(lime);
        minetextView.setText(mine);
        niketextView.setText(nike);
        orgtextView.setText(org);
        raptextView.setText(rap);


        alextextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShowTime.this,ConfirmAppointment.class));
            }
        });




    }

}