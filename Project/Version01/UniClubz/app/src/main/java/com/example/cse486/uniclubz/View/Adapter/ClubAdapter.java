package com.example.cse486.uniclubz.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.R;

import java.util.ArrayList;

public class ClubAdapter extends RecyclerView.Adapter {
    ArrayList<Club> clubs;
    Context context;

    public ClubAdapter(ArrayList<Club> clubs,Context context) {
        this.clubs = clubs;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubitem, parent, false);

        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView clubname,cuniname;

        public MyViewHolder(View v) {
            super(v);
            clubname = (TextView) itemView.findViewById(R.id.cname);
            cuniname = (TextView) itemView.findViewById(R.id.cuniname);
        }
    }
}
