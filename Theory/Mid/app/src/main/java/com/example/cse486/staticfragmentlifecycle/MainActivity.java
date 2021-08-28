package com.example.cse486.staticfragmentlifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                DisplayFragment displayFragment = (DisplayFragment) getFragmentManager().findFragmentById(R.id.fragment);
                displayFragment.change(String.format("%d",count));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void finish() {
        super.finish();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }
}