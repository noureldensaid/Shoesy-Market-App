package com.example.mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class openphoto extends AppCompatActivity {
ImageView imagepreview;
ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openphoto);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imagepreview=findViewById(R.id.imagepreview);
        imagepreview.setImageURI(Uri.parse(getIntent().getStringExtra("pic")));
    }
}