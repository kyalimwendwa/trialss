package com.example.medica;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
 EditText userMail,userPassword;
 Button btnLogin;
 ProgressBar loginProgress;
 private FirebaseAuth mAuth;
 TextView btnIntegral;
 TextView createaccount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        userMail=findViewById(R.id.login_mail);
        btnIntegral=findViewById(R.id.integrallogin);
        userPassword=findViewById(R.id.login_password);
        loginProgress=findViewById(R.id.login_progress);
        mAuth=FirebaseAuth.getInstance();
        btnLogin=findViewById(R.id.button);
        loginProgress.setVisibility(View.INVISIBLE);
        createaccount=findViewById(R.id.createaccount);
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnIntegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,IntegralLogin.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogin.setVisibility(View.INVISIBLE);
                loginProgress.setVisibility(View.VISIBLE);
                final String mail=userMail.getText().toString();
                final String password=userPassword.getText().toString();
                if (mail.isEmpty()||password.isEmpty()){
                    showMessage("Please fill in all fields");
                    btnLogin.setVisibility(View.VISIBLE);
                    loginProgress.setVisibility(View.INVISIBLE);
                }else {
                    signIn(mail,password);
                }
            }
        });
    }

    private void signIn(String mail, String password) {
        mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    btnLogin.setVisibility(View.VISIBLE);
                    loginProgress.setVisibility(View.INVISIBLE);
                    updateUI();
                }else {
                    showMessage(task.getException().getMessage());
                    btnLogin.setVisibility(View.INVISIBLE);
                    loginProgress.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    private void updateUI() {
        Intent intent=new Intent(HomeActivity.this,Startpage.class);
        startActivity(intent);

    }

    private void showMessage(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

}