package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cse486.uniclubz.Model.Repository.ClubRepository;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.View.Adapter.ClubAdapter;
import com.example.cse486.uniclubz.ViewModel.ClubViewModel;


import java.util.ArrayList;

public class ClubListActivity extends AppCompatActivity {


    private ClubRepository repository = new ClubRepository();
    private ClubAdapter clubAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_list);

        ClubViewModel clubViewModel = new ViewModelProvider(this).get(ClubViewModel.class);

        Toast.makeText(getApplicationContext(), repository.getSampleClubs().get(0).getCname(), Toast.LENGTH_SHORT).show();

       ArrayList<Club> clubs = clubViewModel.getsampleclubs();

        clubAdapter = new ClubAdapter(clubs,getApplicationContext());
        RecyclerView recyclerView = findViewById(R.id.crv);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(clubAdapter);


    }
}