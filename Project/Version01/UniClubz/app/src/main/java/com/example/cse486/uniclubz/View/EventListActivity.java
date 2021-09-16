package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cse486.uniclubz.Model.Repository.EventRepository;
import com.example.cse486.uniclubz.View.Adapter.EventAdapter;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.EventViewModel;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);



        EventViewModel eventViewModel = new ViewModelProvider(this).get(EventViewModel.class)
        ArrayList<Event> events =  eventViewModel.getsampleevents();


        RecyclerView recyclerView = findViewById(R.id.elrv);
        recyclerView.setHasFixedSize(true);
        EventAdapter eventAdapter = new EventAdapter(events,getApplicationContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(eventAdapter);

    }
}