package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.databinding.ActivityClubAdminBinding;

public class ClubAdminActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button createclub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_admin);

        ActivityClubAdminBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_club_admin);


        createclub = binding.crtclubbtn;
        recyclerView = binding.clubadminrv;


        createclub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreateClub.class);
                startActivity(intent);
            }
        });

    }
}