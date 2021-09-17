package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.R;

public class EventViewActivity extends AppCompatActivity {

    TextView ename,cname,uname,date,edesc;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);

        Event event = (Event) getIntent().getSerializableExtra("event");

        ename = findViewById(R.id.evname);
        cname = findViewById(R.id.cname);
        date = findViewById(R.id.date);
        edesc = findViewById(R.id.edesc);
        uname = findViewById(R.id.uniname);
       btn = findViewById(R.id.attnd);

        ename.setText(event.getEname());
        cname.setText(event.getEclub());
        uname.setText(event.getEuni());
        edesc.setText(event.getEdesc());

        Context context = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManagerClass.buildeventnotif(context, event.getEname(),event);
            }
        });

    }
}