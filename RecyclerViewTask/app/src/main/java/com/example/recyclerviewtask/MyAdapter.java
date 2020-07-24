package com.example.recyclerviewtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    int myimages[];
    String myNames[];
    String VersionNumbers[];
    String releasedate[];
    Context ct;


    public MyAdapter(MainActivity mainActivity, int[] images, String[] strings, String[] names, String[] releasedates) {
        myimages = images;
        myNames = names;
        VersionNumbers= strings;
        releasedate=releasedates;
        ct = mainActivity;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ct).inflate(R.layout.myitem,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        holder.iv.setImageResource(myimages[position]);
        holder.tv.setText(myNames[position]);
        holder.lv.setText(VersionNumbers[position]);
        holder.mv.setText(releasedate[position]);
    }

    @Override
    public int getItemCount() {

        return myimages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv,lv,mv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.poster);
            tv = itemView.findViewById(R.id.postername);
            lv=itemView.findViewById(R.id.api);
            mv=itemView.findViewById(R.id.releasedate);
        }
    }
}
