package com.example.cse486.broadcastreceiverchallenge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cse486.broadcastreceiverchallenge.BuildConfig;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private BroadcastReceiver broadcastReceiver;
    private boolean Microphone_Plugged_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        // Define the IntentFilter.
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                final String action = intent.getAction();
                int iii;
                if (Intent.ACTION_HEADSET_PLUG.equals(action)) {
                    iii = intent.getIntExtra("state", -1);
                    if (iii == 0) {
                        Microphone_Plugged_in = false;
                        Toast.makeText(getApplicationContext(), "microphone not plugged in", Toast.LENGTH_LONG).show();
                        change_text(0);
                    }
                    if (iii == 1) {
                        Microphone_Plugged_in = true;
                        change_text(1);
                    }
                }
            }
        };
        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        
        this.registerReceiver(broadcastReceiver, filter);


    }

        @Override
        protected void onDestroy () {
            // Unregister the receivers.
            this.unregisterReceiver(broadcastReceiver);
            textView.setText(getString(R.string.hp_disconnected));
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
            super.onDestroy();
        }



    public void change_text ( int x)
    {
        if (x == 0) {
            textView.setText(getString(R.string.hp_connected));
        } else {
            textView.setText(getString(R.string.hp_disconnected));
        }
    }
}