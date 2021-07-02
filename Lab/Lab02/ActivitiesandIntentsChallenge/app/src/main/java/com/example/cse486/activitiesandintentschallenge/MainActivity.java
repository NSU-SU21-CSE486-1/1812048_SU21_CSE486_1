package com.example.cse486.activitiesandintentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonclick(View view) {

        Integer id = view.getId();
        Intent in = new Intent(getApplicationContext(),textactivity.class);

        String which_button = "which_button";
                in.putExtra(which_button,id);
                startActivity(in);


    }
}