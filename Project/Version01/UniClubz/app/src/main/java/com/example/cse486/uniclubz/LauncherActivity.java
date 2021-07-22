package com.example.cse486.uniclubz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cse486.uniclubz.databinding.ActivityLauncherBinding;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        UserPref userPref = new UserPref(getApplicationContext());

        if(userPref.isLoggedIn())
        {
            //Go to Main Activity if User already logged in
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        }
        else
        {
            ActivityLauncherBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_launcher);
            binding.launchSignup.setVisibility(View.VISIBLE);
            binding.launchLogin.setVisibility(View.VISIBLE);
        }

    }

    // Go to Sign Up Screen
    public void signup(View view) {

        Intent intent = new Intent(getApplicationContext(),Signup.class);
        startActivity(intent);
    }

    // Go to Login Screen
    public void login(View view) {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
}