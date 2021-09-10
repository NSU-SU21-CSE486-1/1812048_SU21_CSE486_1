package com.afra.cse486.project03.uicontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.afra.cse486.project03.R;
import com.afra.cse486.project03.UserInfo;
import com.afra.cse486.project03.databinding.ActivityAddPhoneEmailBinding;

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

        if(getCallingActivity()!=null) {

            binding.phoneemailTextview.setText("Add Phone");
            binding.emailEdittextview.setHint("Tag: Home/Office/Custom");

            binding.addInfoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   String pt = binding.phoneEdittextview.getText().toString();
                    String tt = binding.emailEdittextview.getText().toString();
                    if(pt.length()>=10 && tt.length()>=1)
                    {
                        Intent data = new Intent();
                        data.putExtra("phone",pt);
                        data.putExtra("tag",tt);
                        setResult(RESULT_OK,data);
                        finish();
                    }
                }
            });


        }
        else {


            binding.addInfoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    phone = binding.phoneEdittextview.getText().toString();
                    email = binding.emailEdittextview.getText().toString();
                    if (phone.trim().length() == 11 & validate(email)) {

                        userInfo.setEmail(email);
                        userInfo.setPhone(phone);

                        Intent intent = new Intent(getApplicationContext(), FinalActivity.class);
                        startActivity(intent);


                    } else {
                        Toast.makeText(getApplicationContext(), "Please fill up all Fields Properly", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}