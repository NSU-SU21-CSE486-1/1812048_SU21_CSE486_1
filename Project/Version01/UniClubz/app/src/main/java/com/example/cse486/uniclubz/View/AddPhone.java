package com.example.cse486.uniclubz.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.databinding.ActivityAddPhoneBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddPhone extends AppCompatActivity {

    private String phone;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone);


        ActivityAddPhoneBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_phone);

        if(getCallingActivity()!=null) {
            binding.addInfoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   String pt = binding.phoneEdittextview.getText().toString();
                    if(pt.length()>=10)
                    {
                        Intent data = new Intent();
                        data.putExtra("phone",pt);

                        setResult(RESULT_OK,data);
                        finish();
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