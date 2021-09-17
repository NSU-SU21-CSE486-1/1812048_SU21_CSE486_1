package com.example.cse486.uniclubz.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.StudentViewModel;
import com.example.cse486.uniclubz.ViewModel.UserPref;
import com.example.cse486.uniclubz.databinding.ActivitySignupBinding;
import com.example.cse486.uniclubz.Model.entity.Student;


public class Signup extends AppCompatActivity {

    private String email,password,sname,snid,sbg,sphone;
    private Student student;
    private UserPref userPref;
    private String sdob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ActivitySignupBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        StudentViewModel studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = binding.email.getText().toString().trim();
                password = binding.email.getText().toString().trim();
                sname = binding.name.getText().toString().trim();
                snid = binding.nid.getText().toString().trim();
                sphone = binding.phone.getText().toString().trim();
                sbg = binding.bgroup.getSelectedItem().toString();
                sdob = binding.dob.getText().toString();


                Context context = getApplicationContext();
                if (!email.isEmpty() && !password.isEmpty()) {

                    boolean flag = studentViewModel.newStudent( sname,  sbg,  sphone,  snid,  email,  sdob,  password, Signup.this);

                    if(flag) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // clears all previous activities task
                        finish();
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText( getApplicationContext(),"Authentication failed.",Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(getApplicationContext(), "Please fill up the fields", Toast.LENGTH_LONG).show();

                }


            }
        });
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