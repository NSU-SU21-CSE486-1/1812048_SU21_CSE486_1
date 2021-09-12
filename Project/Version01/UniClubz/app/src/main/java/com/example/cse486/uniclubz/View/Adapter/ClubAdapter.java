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

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {
    private ArrayList<Club> clubs;
    private Context context;

    public ClubAdapter(ArrayList<Club> clubs,Context context) {
        this.clubs = clubs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.clubitem, parent, false);

        ViewHolder vh = new ViewHolder(v); // pass the view to View Holder
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.cuniname.setText(clubs.get(position).getUni());
        holder.clubname.setText(clubs.get(position).getCname());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        TextView clubname,cuniname;


        public ViewHolder(View v) {
            super(v);
            clubname = (TextView) itemView.findViewById(R.id.cname);
            cuniname = (TextView) itemView.findViewById(R.id.cuniname);
        }
    }
}
