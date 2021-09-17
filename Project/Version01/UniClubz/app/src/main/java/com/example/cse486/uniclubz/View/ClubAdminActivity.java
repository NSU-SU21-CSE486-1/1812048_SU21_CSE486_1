package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.View.Adapter.ClubAdapter;
import com.example.cse486.uniclubz.ViewModel.ClubViewModel;
import com.example.cse486.uniclubz.databinding.ActivityClubAdminBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ClubAdminActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button createclub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_admin);

        ActivityClubAdminBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_club_admin);
        ClubViewModel clubViewModel = new ViewModelProvider(this).get(ClubViewModel.class);
        clubViewModel.setContext(getApplicationContext());

        createclub = binding.crtclubbtn;
        recyclerView = binding.clubadminrv;

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        ClubAdapter adapter = new ClubAdapter(new ArrayList<Club>(),getApplicationContext());
//
//
//      //  ClubAdapter adapter = new ClubAdapter(clubs,getApplicationContext());
//        recyclerView.setAdapter(adapter);
        ArrayList<Club> clubs = clubViewModel.getadminclubs(FirebaseAuth.getInstance().getUid());
      //  adapter.notifyDataSetChanged();
      //  Toast.makeText(getApplicationContext(), clubs.get(0).getCname(), Toast.LENGTH_SHORT).show();

      //  recyclerView.setAdapter(adapter);


        try {

           Runnable runnable = new Runnable() {
               @Override
               public void run() {
                   ClubAdapter adapter = new ClubAdapter(clubs,getApplicationContext());
                   recyclerView.setAdapter(adapter);
               }
           };
            Handler handler = new Handler();
            handler.postDelayed(runnable,1200);
        } catch (Exception e) {
            e.printStackTrace();
        }




        createclub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateClub.class);
                startActivity(intent);
            }
        });



    }


}
