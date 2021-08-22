package com.example.cse486.uniclubz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cse486.uniclubz.databinding.ActivitySignupBinding;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ActivitySignupBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_signup);

    }

    public void Login(View view) {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),LauncherActivity.class);
        startActivity(intent);
    }
}