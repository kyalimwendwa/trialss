package com.example.medica;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class RegisterActivity extends AppCompatActivity {
    ImageView ImgUserPhoto;
    static int PReqCode=1;
    static int REQUESCODE=1;
    Uri pickedImageUri;
    EditText userEmail,userPassword,userName,userPassword2;
    ProgressBar loadingprogressBar;
    Button regBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        userEmail=findViewById(R.id.regMail);
        userPassword=findViewById(R.id.regPassword);
        userName=findViewById(R.id.regName);
        userPassword2=findViewById(R.id.regPassword2);
        loadingprogressBar=findViewById(R.id.progressBar);
        mAuth=FirebaseAuth.getInstance();


        ImgUserPhoto=findViewById(R.id.regUserPhoto);
        regBtn=findViewById(R.id.regBtn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regBtn.setVisibility(View.INVISIBLE);
                loadingprogressBar.setVisibility(View.VISIBLE);


                final String email=userEmail.getText().toString();
                final String name=userName.getText().toString();
                final String password=userPassword.getText().toString();
                final String password2=userPassword2.getText().toString();

                if (email.isEmpty()||name.isEmpty()||password.isEmpty()||!password.equals(password2)){
               showMessage("Please enter all empty fields to procceed");
               regBtn.setVisibility(View.VISIBLE);
               loadingprogressBar.setVisibility(View.INVISIBLE);
                }else {
                    createUserAccount(email,name,password);
                }
            }
        });

        loadingprogressBar.setVisibility(View.INVISIBLE);


        ImgUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if (Build.VERSION.SDK_INT>=21){
                checkAndRequestForPermission();
            }else {
                openGallery();
            }


            }
        });


    }

    private void createUserAccount(String email, String name, String password) {
      mAuth.createUserWithEmailAndPassword(email,password)
              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()){
                          showMessage("Account created");
                          updateUserInfo(name,pickedImageUri,mAuth.getCurrentUser());
                      }else {
                          showMessage("Account creation failed"+task.getException().getMessage());
                          regBtn.setVisibility(View.VISIBLE);
                          loadingprogressBar.setVisibility(View.INVISIBLE);
                      }
                  }
              });
    }

    private void updateUserInfo(String name, Uri pickedImageUri, FirebaseUser currentUser) {
      StorageReference mStorage= FirebaseStorage.getInstance().getReference().child("users_photos");
      StorageReference imageFilePath=mStorage.child(pickedImageUri.getLastPathSegment());
      imageFilePath.putFile(pickedImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
          @Override
          public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
              imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                  @Override
                  public void onSuccess(Uri uri) {
                      UserProfileChangeRequest profileUpdate= new UserProfileChangeRequest.Builder()
                              .setDisplayName(name)
                              .setPhotoUri(uri)
                              .build();
                      currentUser.updateProfile(profileUpdate)
                              .addOnCompleteListener(new OnCompleteListener<Void>() {
                                  @Override
                                  public void onComplete(@NonNull Task<Void> task) {
                                  if (task.isSuccessful()){
                                      showMessage("Update complete");
                                      updateUI();
                                  }
                                  }
                              });
                  }
              });
          }
      });
    }

    private void updateUI() {
         Intent intent=new Intent(RegisterActivity.this,Startpage.class);
         startActivity(intent);

    }

    private void showMessage(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }


    private void openGallery() {
        Intent galleryIntent=new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESCODE);
    }

    private void checkAndRequestForPermission() {
        if (ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            if (ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                Toast.makeText(RegisterActivity.this,"Permission to access file location  is not granted",Toast.LENGTH_LONG).show();
            }
            else {
                ActivityCompat.requestPermissions(RegisterActivity.this,new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE
                },PReqCode);
            }
        }
        else {
            openGallery();
        }
        
        
        
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK&&requestCode==REQUESCODE&&data !=null){
            pickedImageUri=data.getData();
            ImgUserPhoto.setImageURI(pickedImageUri);

        }
    }
}
