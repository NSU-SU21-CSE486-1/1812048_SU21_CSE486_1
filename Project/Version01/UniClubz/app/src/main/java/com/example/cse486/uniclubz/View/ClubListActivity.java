package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cse486.uniclubz.Model.Repository.ClubRepository;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.View.Adapter.ClubAdapter;
import com.example.cse486.uniclubz.ViewModel.ClubViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class ClubListActivity extends AppCompatActivity {


    private ClubRepository repository = new ClubRepository();
    private ClubAdapter clubAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_list);

        boolean flag = getIntent().getBooleanExtra("all",false);

        if(flag)
        {
            TextView textView = findViewById(R.id.ctv);
            textView.setText("All Clubs");
        }

        String uid = FirebaseAuth.getInstance().getUid();

        ClubViewModel clubViewModel = new ViewModelProvider(this).get(ClubViewModel.class);

     //   Toast.makeText(getApplicationContext(), repository.getSampleClubs().get(0).getCname(), Toast.LENGTH_SHORT).show();

     // ArrayList<Club> clubs = (!flag)? clubViewModel.getmyclubs(uid) : clubViewModel.getallclubs();

        ArrayList<Club> clubs = new ClubRepository().getSampleClubs();
       RecyclerView recyclerView = findViewById(R.id.crv);
       recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    clubAdapter = new ClubAdapter(clubs,getApplicationContext());
                    recyclerView.setAdapter(clubAdapter);
                }
            };
            Handler handler = new Handler();
            handler.postDelayed(runnable,1200);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}