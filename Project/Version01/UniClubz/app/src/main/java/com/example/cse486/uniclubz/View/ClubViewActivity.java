package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.R;

import java.io.Serializable;

public class ClubViewActivity extends AppCompatActivity {

    TextView uni,cname, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_view);

        Club club = (Club) getIntent().getSerializableExtra("club");
        uni = findViewById(R.id.uniname);
        cname = findViewById(R.id.clubname);
        status = findViewById(R.id.status);

        uni.setText(club.getUni());
        cname.setText(club.getCname());




    }

    public void toevents(View view) {
        Intent intent = new Intent(getApplicationContext(),EventListActivity.class);
        startActivity(intent);
    }

    public void tobd(View view) {
        Intent intent = new Intent(getApplicationContext(),BloodDonationListActivity.class);
        startActivity(intent);
    }

    public void addevents(View view) {
        Intent intent = new Intent(getApplicationContext(),AddEvent.class);
        startActivity(intent);
    }

    public void adddonation(View view) {
        Intent intent = new Intent(getApplicationContext(),AddDonationActivity.class);
        startActivity(intent);
    }

    public void addmem(View view) {
        Intent intent = new Intent(getApplicationContext(),AddMemberActivity.class);
        startActivity(intent);
    }

    public void addadmin(View view) {
        Intent intent = new Intent(getApplicationContext(),AddMemberActivity.class);
        startActivity(intent);
    }
}