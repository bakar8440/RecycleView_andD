package com.example.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    Context context;
    private String[] fruits;
    public MyAdapter(recycleview emptyActivity){
        context = emptyActivity;
        fruits = context.getResources().getStringArray(R.array.fruits);
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_1,parent,false);
        return new  ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.fruit.setText(fruits[position]);

    }

    @Override
    public int getItemCount() {
        return fruits.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout relativeLayout;
        TextView fruit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            fruit = itemView.findViewById(R.id.fruit);
            itemView.setOnClickListener( this);

        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Toast.makeText(v.getContext(),position+": " + fruits[position], Toast.LENGTH_SHORT).show();
        }
    }
}
