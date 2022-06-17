package com.example.mobile_project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class cartadapt extends RecyclerView.Adapter<cartadapt.Holder> {
    ArrayList<Itemdata> items;
    Context context;
    shareprefrance shareprefrance;


    public cartadapt(ArrayList<Itemdata> items, Context context) {
        this.items = items;
        this.context = context;
        shareprefrance=new shareprefrance(context);

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_checkout,parent,false);
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
        holder.number.setText(items.get(position).getNumber());
        holder.size1.setText(items.get(position).getSize());
holder.delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        items.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,items.size());

        shareprefrance.removeitem(position);

    }
});





    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView photo,delete;
        TextView name,description,price,number,size1;
        public Holder(@NonNull View itemView) {
            super(itemView);
            photo=itemView.findViewById(R.id.photo);
            name=itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.desc);
            price=itemView.findViewById(R.id.price);
delete=itemView.findViewById(R.id.delete);
            number=itemView.findViewById(R.id.number);
            size1=itemView.findViewById(R.id.size1);



        }
    }
}
