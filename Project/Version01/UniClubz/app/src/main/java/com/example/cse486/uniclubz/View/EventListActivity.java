package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.cse486.uniclubz.Model.Repository.EventRepository;
import com.example.cse486.uniclubz.View.Adapter.ClubAdapter;
import com.example.cse486.uniclubz.View.Adapter.EventAdapter;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.EventViewModel;
import com.example.cse486.uniclubz.ViewModel.UserPref;

import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {
    EventAdapter eventAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);



        EventViewModel eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);
        ArrayList<Event> events =  eventViewModel.getallevents();
        if(events==null || events.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "No Events", Toast.LENGTH_SHORT).show();
        }

        else {

            RecyclerView recyclerView = findViewById(R.id.elrv);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            try {

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        eventAdapter = new EventAdapter(events, getApplicationContext());
                        recyclerView.setAdapter(eventAdapter);
                    }
                };
                Handler handler = new Handler();
                handler.postDelayed(runnable, 1200);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}