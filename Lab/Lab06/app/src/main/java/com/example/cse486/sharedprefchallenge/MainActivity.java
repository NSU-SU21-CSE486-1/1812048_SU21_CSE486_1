package com.example.cse486.sharedprefchallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    // Current background color
    private int mColor;
    // Text view to display both count and color
    private TextView mShowCountTextView;
    private SharedPreferences mPreferences;
    private final String COUNT_KEY = "count";
    private final String COLOR_KEY = "color";
    private static final String PREF_NAME = "UserInfoPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mColor = getColor(android.R.color.darker_gray);
        Button settings =findViewById(R.id.settingsbtn);
        mShowCountTextView = findViewById(R.id.count_textview);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Settings.class);
                startActivityForResult(intent,1);
            }
        });
        mPreferences = this.getSharedPreferences(PREF_NAME,MODE_PRIVATE);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null && resultCode==RESULT_OK)
        {
            mCount = mPreferences.getInt(COUNT_KEY,mCount);
            mShowCountTextView.setText(String.format("%s", mCount));
            mColor = mPreferences.getInt(COLOR_KEY,mColor);
            mShowCountTextView.setBackgroundColor(mColor);

        }

    }
}