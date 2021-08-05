package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.project02.databinding.ActivityAddPhoneEmailBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddPhoneEmail extends AppCompatActivity {

    private String phone;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone_email);
        UserInfo userInfo = new UserInfo(getApplicationContext());

        ActivityAddPhoneEmailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_phone_email);


        binding.addInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = binding.phoneEdittextview.getText().toString();
                email = binding.emailEdittextview.getText().toString();
                if(phone.trim().length()==11 & validate(email))
                {

                    userInfo.setEmail(email);
                    userInfo.setPhone(phone);

                    Intent intent = new Intent(getApplicationContext(),FinalActivity.class);
                    startActivity(intent);


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please fill up all Fields Properly",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}