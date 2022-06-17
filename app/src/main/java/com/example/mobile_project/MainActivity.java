package com.example.mobile_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
ArrayList<Uri> images;
RecyclerView recyclerView;
    RecyclerView topdeals;
recylerviewadapt recylerviewadapt;
    recylerviewadapt1 recylerviewadapt1;
ArrayList<item> items;
Timer timer;
RecyclerView Tranding;
ImageView cart;
ImageView login;
static TextView addnotifcation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
cart=findViewById(R.id.cart);
login=findViewById(R.id.login);
addnotifcation=findViewById(R.id.addnotfication);
cart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,cart.class));
        addnotifcation.setVisibility(View.GONE);
        addnotifcation.setText("0");
    }
});
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,signin.class));
            }
        });
        viewPager =findViewById(R.id.pager);
        images=new ArrayList<>();
        items=new ArrayList<>();
        recyclerView=findViewById(R.id.recy);
        recylerviewadapt=new recylerviewadapt(items,this);
        recylerviewadapt1=new recylerviewadapt1(items,this);
        recyclerView.setAdapter(recylerviewadapt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setNestedScrollingEnabled(false);

        topdeals=findViewById(R.id.topdeals);
        topdeals.setAdapter(recylerviewadapt1);
        topdeals.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        Tranding=findViewById(R.id.Tranding);
        Tranding.setAdapter(recylerviewadapt1);
        Tranding.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.banner1);
        Uri uri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.banner2);
        Uri uri2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.banner3);
        images.add(uri);
        images.add(uri1);
        images.add(uri2);
        TabLayout tabLayout =findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
        setUpAdapter setUpAdapter=new setUpAdapter(images,this);
        setUpAdapter.instantiateItem(viewPager,0);
        setUpAdapter.instantiateItem(viewPager,1);
        setUpAdapter.instantiateItem(viewPager,2);
        viewPager.setAdapter(setUpAdapter);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewPager.post(new Runnable(){

                    @Override
                    public void run() {
                        viewPager.setCurrentItem((viewPager.getCurrentItem()+1)%images.size());
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 8000, 8000);


        Uri uri5 = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.shoes);
        Uri uri6 = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.shoes2);
        Uri uri7 = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.shoes3);


        items.add(new item(uri5.toString(),"Nike React Infinity Run FlyKnit","Nike","2000"));
        items.add(new item(uri6.toString(),"Nike React Infinity Run FlyKnit","Nike","2000"));
        items.add(new item(uri7.toString(),"Nike React Infinity Run FlyKnit","Nike","2000"));
        items.add(new item(uri5.toString(),"Nike React Infinity Run FlyKnit","Nike","2000"));
        items.add(new item(uri6.toString(),"Nike React Infinity Run FlyKnit","Nike","2000"));
        items.add(new item(uri7.toString(),"Nike React Infinity Run FlyKnit","Nike","2000"));
        recylerviewadapt.notifyDataSetChanged();
        recylerviewadapt1.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    public static void notifyadding(){
        String number=addnotifcation.getText().toString();
        addnotifcation.setText(Integer.toString(Integer.parseInt(number)+1));
addnotifcation.setVisibility(View.VISIBLE);

    }
}