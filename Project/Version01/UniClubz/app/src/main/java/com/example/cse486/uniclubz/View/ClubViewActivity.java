package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cse486.uniclubz.R;

public class ClubViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_view);
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