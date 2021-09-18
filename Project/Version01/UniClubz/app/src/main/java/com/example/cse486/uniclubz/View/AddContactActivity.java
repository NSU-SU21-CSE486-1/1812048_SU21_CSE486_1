package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.UserPref;
import com.example.cse486.uniclubz.databinding.ActivityAddContactBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddContactActivity extends AppCompatActivity {

    private String phone;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private String email;
    private String eorp;
    private boolean dept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        UserPref userInfo = new UserPref(getApplicationContext());

        ActivityAddContactBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_contact);



        if(getCallingActivity()!=null) {


            binding.tagEdittextview.setHint("Tag: Home/Office/Custom");

            binding.addInfoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String pt = binding.contactEdittextview.getText().toString();
                    String tt = binding.tagEdittextview.getText().toString();
                    if(binding.emailorphone.getSelectedItem()!=null) {
                        eorp = binding.emailorphone.getSelectedItem().toString();
                        dept=true;
                    }
                    if(pt.length()>=10 && tt.length()>=1)
                    {
                        Intent data = new Intent();
                        data.putExtra("type",eorp);
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
                    phone = binding.phoneemailTextview.getText().toString();
                    email = binding.tagEdittextview.getText().toString();
                    if (phone.trim().length() == 11 & validate(email)) {

                        userInfo.setEmail(email);
                        userInfo.setPhone(phone);

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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