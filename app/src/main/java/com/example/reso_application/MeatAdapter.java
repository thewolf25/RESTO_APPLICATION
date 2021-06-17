package com.example.reso_application;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reso_application.model.Meat;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

//import android.support.;
//import android.support.v7.widget.RecyclerView;

public class MeatAdapter extends RecyclerView.Adapter<MeatAdapter.MyViewHolder>  {
    List<Meat> meatDataList;
    public MeatAdapter(List meatDataList, MainActivity mainActivity) {
        this.meatDataList = meatDataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.meat_list_row, viewGroup, false);
        return new MyViewHolder(itemView,meatDataList.get(i));
    }

    @Override
    public void onBindViewHolder(@NonNull MeatAdapter.MyViewHolder viewHolder, int position) {
        Meat data = meatDataList.get(position);
        viewHolder.name.setText(data.name);
        viewHolder.price.setText(String.valueOf(data.price));
        viewHolder.meat = data;
    }







    @Override
    public int getItemCount() {
        return meatDataList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,price;
        LinearLayout parent;
        Meat meat ;

        public MyViewHolder(View itemView,Meat meat) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            this.meat = meat;
            itemView.findViewById(R.id.buy).setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MainActivity a = new MainActivity();

                            Intent i =  new Intent(v.getContext(), singleMeat.class);

                            i.putExtra("meat", (Serializable) meat);
                            v.getContext().startActivity(i);
                        }
                    }
            );
        }



    }
}

