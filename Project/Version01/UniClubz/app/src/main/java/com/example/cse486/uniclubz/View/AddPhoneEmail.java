package com.example.cse486.uniclubz.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.databinding.ActivityAddPhoneEmailBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddPhoneEmail extends AppCompatActivity {

    private String phone;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private String email;
    private String[] type ={"Phone","Email"};
    private String ctype;
    private boolean set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone_email);
    //    UserInfo userInfo = new UserInfo(getApplicationContext());

        ActivityAddPhoneEmailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_phone_email);

        ArrayAdapter spinnerAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,type);
        binding.ctypespinner.setAdapter(spinnerAdapter);

        if(getCallingActivity()!=null) {



            binding.addInfoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(binding.ctypespinner.getSelectedItem()!=null) {
                        ctype = binding.ctypespinner.getSelectedItem().toString();
                        set=true;
                    }
                    String tt = binding.emailEdittextview.getText().toString();
                    if(set && ctype.equals(type[1]))
                    {
                        if(validate(ctype)) {
                            Intent data = new Intent();
                            data.putExtra("contact", tt);
                            data.putExtra("tag", "phone");
                            setResult(RESULT_OK, data);
                            finish();
                        }
                        else  Toast.makeText(getApplicationContext(),"Please enter correct email",Toast.LENGTH_LONG).show();

                    }
                    else if (set &&  ctype.equals(type[0]) && tt.length()>=10)
                    {
                        Intent data = new Intent();
                        data.putExtra("contact",tt);
                        data.putExtra("tag","phone");
                        setResult(RESULT_OK,data);
                        finish();
                    }

                    else Toast.makeText(getApplicationContext(),"Please fill up all Fields",Toast.LENGTH_LONG).show();

                }
            });


        }

    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}