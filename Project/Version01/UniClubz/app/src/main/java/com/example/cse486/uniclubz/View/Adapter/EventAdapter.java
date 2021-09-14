package com.example.cse486.uniclubz.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {
    private ArrayList<Event> events;
    private Context context;

    public EventAdapter(ArrayList<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventitem, parent, false);

        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Event event = events.get(position);
        holder.eclub.setText(event.getEclub());
        holder.estatus.setText(event.getEstatus());
        holder.edate.setText(event.getEdate());
        holder.ename.setText(event.getEname());
        holder.euname.setText(event.getEuni());


    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ename,euname,estatus,edate,eclub;

        public MyViewHolder(View v) {
            super(v);
            ename = (TextView) itemView.findViewById(R.id.ename);
            euname = (TextView) itemView.findViewById(R.id.euname);
            edate = (TextView) itemView.findViewById(R.id.edate);
            estatus = (TextView) itemView.findViewById(R.id.estatus);
            eclub = (TextView) itemView.findViewById(R.id.ecname);

        }
    }
}
