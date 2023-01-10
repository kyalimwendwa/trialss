package com.example.medica;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Biography extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biography);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String fullname=getIntent().getStringExtra("Fullname");
        String email=getIntent().getStringExtra("Email");
        String contact=getIntent().getStringExtra("Contact");
        String department=getIntent().getStringExtra("Department");
        String experience=getIntent().getStringExtra("Experience");
        String patients=getIntent().getStringExtra("Patients");
        String biography=getIntent().getStringExtra("Biography");
        String image=getIntent().getStringExtra("Image");



        TextView showfullname=findViewById(R.id.fullname);
        LinearLayout btnWhatsapp=findViewById(R.id.whatsapp);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout btnWhatsapp1=findViewById(R.id.whatsapp1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout btnWhatsapp2=findViewById(R.id.whatsapp2);
        btnWhatsapp.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                try {
                    String headerReceiver = "";// Replace with your message.
                    String bodyMessageFormal = "";// Replace with your message.
                    String whatsappContain = headerReceiver + bodyMessageFormal;
                    String trimToNumner =contact; //10 digit number
                    Intent intent = new Intent ( Intent.ACTION_VIEW );
                    intent.setData ( Uri.parse ( "https://wa.me/" + trimToNumner + "/?text=" + "" ) );
                    startActivity ( intent );
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        } );
        btnWhatsapp1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                try {
                    String headerReceiver = "";// Replace with your message.
                    String bodyMessageFormal = "";// Replace with your message.
                    String whatsappContain = headerReceiver + bodyMessageFormal;
                    String trimToNumner =contact; //10 digit number
                    Intent intent = new Intent ( Intent.ACTION_VIEW );
                    intent.setData ( Uri.parse ( "https://wa.me/" + trimToNumner + "/?text=" + "" ) );
                    startActivity ( intent );
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        } );
        btnWhatsapp2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                try {
                    String headerReceiver = "";// Replace with your message.
                    String bodyMessageFormal = "";// Replace with your message.
                    String whatsappContain = headerReceiver + bodyMessageFormal;
                    String trimToNumner =contact; //10 digit number
                    Intent intent = new Intent ( Intent.ACTION_VIEW );
                    intent.setData ( Uri.parse ( "https://wa.me/" + trimToNumner + "/?text=" + "" ) );
                    startActivity ( intent );
                } catch (Exception e) {
                    e.printStackTrace ();
                }
            }
        } );

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView alextextView=findViewById(R.id.emaill);
        TextView bettytextView=findViewById(R.id.contaact);
        TextView cantextView=findViewById(R.id.department);
        TextView donetextView=findViewById(R.id.experience);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView earntextView=findViewById(R.id.biography);
        TextView faytextView=findViewById(R.id.patients);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView imaggge=findViewById(R.id.shomage);



        showfullname.setText(fullname);

        alextextView.setText(email);
        bettytextView.setText(contact);
        cantextView.setText(department);
        donetextView.setText(experience);
        earntextView.setText(biography);
        faytextView.setText(patients);

        String imageUri=null;
        imageUri= image;
        Picasso.get().load(imageUri).into(imaggge);

    }
    private void startSupportChat() {

        try {
            String headerReceiver = "";// Replace with your message.
            String bodyMessageFormal = "";// Replace with your message.
            String whatsappContain = headerReceiver + bodyMessageFormal;
            String trimToNumner ="+254740569496"; //10 digit number
            Intent intent = new Intent ( Intent.ACTION_VIEW );
            intent.setData ( Uri.parse ( "https://wa.me/" + trimToNumner + "/?text=" + "" ) );
            startActivity ( intent );
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }
}