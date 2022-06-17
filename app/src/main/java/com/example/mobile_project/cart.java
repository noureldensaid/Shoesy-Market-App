package com.example.mobile_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import java.util.ArrayList;

public class cart extends AppCompatActivity {

    RecyclerView recyclerView;
    shareprefrance shareprefrance;
    ArrayList<Itemdata> items;
    cartadapt cartadapt;
    ImageView back;
    ImageView clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView=findViewById(R.id.cartitems);
        clear=findViewById(R.id.clear);
        shareprefrance=new shareprefrance(this);
        items=shareprefrance.getitem();
back=findViewById(R.id.back);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        onBackPressed();
    }
});
        cartadapt=new cartadapt(items,this);
        recyclerView.setAdapter(cartadapt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartadapt.notifyDataSetChanged();
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.clear();
                cartadapt.notifyDataSetChanged();
                shareprefrance.clearcart();
            }
        });

    }
}