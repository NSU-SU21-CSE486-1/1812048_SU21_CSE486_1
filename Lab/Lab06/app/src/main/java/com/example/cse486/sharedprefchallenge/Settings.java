package com.example.cse486.sharedprefchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.MotionLabel;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    private int mCount = 0;
    private EditText countEdittext;
    private Spinner colorspinner;
    private int mColor;
    private SharedPreferences mPreferences;
    private final String COUNT_KEY = "count";
    private final String COLOR_KEY = "color";
    private static final String PREF_NAME = "UserInfoPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mColor = ContextCompat.getColor(this,
                android.R.color.darker_gray);
        mPreferences = this.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        countEdittext = findViewById(R.id.countedit);
        colorspinner = findViewById(R.id.colorspinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,getResources().getStringArray(R.array.array_name));
        // Restore preferences
        colorspinner.setAdapter(adapter);

        mCount = mPreferences.getInt(COUNT_KEY, 0);
        countEdittext.setText(String.format("%s", mCount));
        mColor = mPreferences.getInt(COLOR_KEY, mColor);


    }


    public void reset(View view) {
        // Reset count
        mCount = 0;
        countEdittext.setText(String.format("%s", mCount));

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.clear();
        preferencesEditor.apply();
        Intent data = new Intent();
        data.putExtra("ok","ok");
        setResult(RESULT_OK,data);
        finish();
    }


    public void save(View view) {
        if(countEdittext.getText().toString().trim().length()>=1)
        {
            mCount = Integer.parseInt(countEdittext.getText().toString().trim());
        }

        String color = "";
        if(colorspinner.getSelectedItem()!=null) {
            color = colorspinner.getSelectedItem().toString();
        }

        switch (color)
        {
            case "Black" :
                mColor = getColor(R.color.black);
            break;
            case "Red" :
                mColor = getColor(R.color.red_background);
                break;
            case "Blue" :
                mColor = getColor(R.color.blue_background);
                break;
            case "Green" :
                mColor = getColor(R.color.green_background);
                break;
            default: mColor = ContextCompat.getColor(this,
                    android.R.color.darker_gray);
                Toast.makeText(getApplicationContext(), "hellohere", Toast.LENGTH_SHORT).show();


        }

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(COUNT_KEY, mCount);
        preferencesEditor.putInt(COLOR_KEY, mColor);
        preferencesEditor.commit();



        Intent data = new Intent();
        data.putExtra("ok","ok");
        setResult(RESULT_OK,data);
        finish();
    }
}