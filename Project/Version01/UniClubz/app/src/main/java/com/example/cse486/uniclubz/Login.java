package com.example.cse486.uniclubz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signup(View view) {
        Intent intent = new Intent(getApplicationContext(),Signup.class);
        startActivity(intent);
    }

    public void loginfunc(View view) {

        //Validate info check against DB/ firebase
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}