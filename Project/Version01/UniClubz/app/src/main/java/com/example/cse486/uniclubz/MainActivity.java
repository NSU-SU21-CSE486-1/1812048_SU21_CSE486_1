package com.example.cse486.uniclubz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserPref userPref = new UserPref(getApplicationContext());

        if(!userPref.isLoggedIn())
        {

        }
        else
        {

        }
    }

    public void tolauncher(View view) {
            //Firebase Logout
            Intent intent = new Intent(getApplicationContext(),LauncherActivity.class);
            startActivity(intent);

    }

    public void allclubs(View view) {
        Intent intent = new Intent(getApplicationContext(),ClubListActivity.class);
        startActivity(intent);
    }

    public void events(View view) {
    }

    public void bd(View view) {
    }

    public void profile(View view) {
    }

    public void clubadmin(View view) {
    }

    public void myclubs(View view) {
        Intent intent = new Intent(getApplicationContext(),ClubListActivity.class);
        startActivity(intent);
    }
}