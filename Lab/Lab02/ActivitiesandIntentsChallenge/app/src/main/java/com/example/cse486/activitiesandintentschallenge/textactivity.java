package com.example.cse486.activitiesandintentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class textactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textactivity);

        TextView textView = findViewById(R.id.textView);
        Integer id = getIntent().getIntExtra("which_button",R.id.button);
        switch(id)
        {
            case R.id.button:
                textView.setText(getString(R.string.textone));
                break;

            case R.id.button2:
                textView.setText(getString(R.string.texttwo));
                break;

            default:
                textView.setText(getString(R.string.textthree));
                break;
        }



    }
}