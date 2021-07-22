package com.example.cse486.uniclubz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        UserPref userPref = new UserPref(getApplicationContext());

        if(userPref.isLoggedIn())
        {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        }
        else
        {

        }

    }
}