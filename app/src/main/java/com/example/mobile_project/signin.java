package com.example.mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class signin extends AppCompatActivity {
ImageView back;
Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
   back=findViewById(R.id.back);
   login=findViewById(R.id.login);
   login.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           startActivity(new Intent(signin.this,MainActivity.class));
           finish();
       }
   });
   back.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           onBackPressed();
       }
   });

    }
}