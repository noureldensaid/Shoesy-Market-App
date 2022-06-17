package com.example.mobile_project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recylerviewadapt1 extends RecyclerView.Adapter<recylerviewadapt1.Holder> {
    ArrayList<item> items;
    Context context;
    shareprefrance shareprefrance;
String size="";

    public recylerviewadapt1(ArrayList<item> items, Context context) {
        this.items = items;
        this.context = context;
        shareprefrance=new shareprefrance(context);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.price.setText(items.get(position).getPrice());
        holder.name.setText(items.get(position).getName());
        holder.description.setText(items.get(position).getDesc());
        holder.photo.setImageURI(Uri.parse(items.get(position).getImg()));
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,openphoto.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                ActivityOptionsCompat optionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,holder.photo, ViewCompat.getTransitionName(holder.photo));
                intent.putExtra("pic",items.get(position).getImg());
                context.startActivity(intent,optionsCompat.toBundle());
            }
        });
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=holder.number.getText().toString();
                holder.price.setText(Integer.toString(Integer.parseInt(items.get(position).getPrice())*(Integer.parseInt(number)+1)));
                number=Integer.toString(Integer.parseInt(number)+1);

                holder.number.setText(number);

            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=holder.number.getText().toString();
                if (Integer.parseInt(number)>1){
                    holder.price.setText(Integer.toString(Integer.parseInt(items.get(position).getPrice())*(Integer.parseInt(number)-1)));
                    number=Integer.toString(Integer.parseInt(number)-1);

                }
                holder.number.setText(number);

            }
        });
        holder.size1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.size1.setBackground(ContextCompat.getDrawable(context, R.drawable.roundblue));
                holder.size2.setBackground(ContextCompat.getDrawable(context, R.drawable.round));
                holder.size3.setBackground(ContextCompat.getDrawable(context, R.drawable.round));
                holder.size4.setBackground(ContextCompat.getDrawable(context, R.drawable.round));


            }
        });
        holder.size2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.size2.setBackground(ContextCompat.getDrawable(context, R.drawable.roundblue));
                holder.size1.setBackground(ContextCompat.getDrawable(context, R.drawable.round));
                holder.size3.setBackground(ContextCompat.getDrawable(context, R.drawable.round));
                holder.size4.setBackground(ContextCompat.getDrawable(context, R.drawable.round));


            }
        });
        holder.size3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.size3.setBackground(ContextCompat.getDrawable(context, R.drawable.roundblue));
                holder.size2.setBackground(ContextCompat.getDrawable(context, R.drawable.round));
                holder.size1.setBackground(ContextCompat.getDrawable(context, R.drawable.round));
                holder.size4.setBackground(ContextCompat.getDrawable(context, R.drawable.round));


            }
        });
        holder.size4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.size4.setBackground(ContextCompat.getDrawable(context, R.drawable.roundblue));
                holder.size2.setBackground(ContextCompat.getDrawable(context, R.drawable.round));
                holder.size3.setBackground(ContextCompat.getDrawable(context, R.drawable.round));
                holder.size1.setBackground(ContextCompat.getDrawable(context, R.drawable.round));


            }
        });

        holder.addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getsize(holder)){
                    Itemdata itemdata=new Itemdata(items.get(position).getImg(),items.get(position).getName(),items.get(position).desc,holder.price.getText().toString(),holder.number.getText().toString(),size);

                    shareprefrance.additemtocart(itemdata);
                    MainActivity mainActivity=new MainActivity();
                    mainActivity.notifyadding();
                    Toast.makeText(context, "item has been added", Toast.LENGTH_SHORT).show();


                }
                else {
                    Toast.makeText(context, "please choose size", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private Boolean getsize(Holder holder) {

        if (holder.size1.getBackground().getConstantState()== context.getResources().getDrawable(R.drawable.roundblue).getConstantState()){
            size=holder.size1.getText().toString();
            return true;

        }
        else if (holder.size2.getBackground().getConstantState()== context.getResources().getDrawable(R.drawable.roundblue).getConstantState()){
            size=holder.size2.getText().toString();
            return true;
        }
        else if (holder.size3.getBackground().getConstantState()== context.getResources().getDrawable(R.drawable.roundblue).getConstantState()){
            size=holder.size3.getText().toString();
            return true;
        }
        else if (holder.size4.getBackground().getConstantState()== context.getResources().getDrawable(R.drawable.roundblue).getConstantState()){
            size=holder.size4.getText().toString();
            return true;
        }
        return false;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView photo,plus,minus;
        TextView name,description,price,number,size1,size2,size3,size4;
        Button addtocart;
        public Holder(@NonNull View itemView) {
            super(itemView);
            photo=itemView.findViewById(R.id.photo);
            name=itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.desc);
            price=itemView.findViewById(R.id.price);
            addtocart=itemView.findViewById(R.id.addtocart);
            plus=itemView.findViewById(R.id.plus);
            minus=itemView.findViewById(R.id.minus);
            number=itemView.findViewById(R.id.number);
            size1=itemView.findViewById(R.id.size1);
            size2=itemView.findViewById(R.id.size2);
            size3=itemView.findViewById(R.id.size3);
            size4=itemView.findViewById(R.id.size4);



        }
    }
}
