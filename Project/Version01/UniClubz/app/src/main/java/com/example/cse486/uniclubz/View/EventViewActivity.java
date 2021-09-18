package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.EventViewModel;
import com.example.cse486.uniclubz.ViewModel.UserPref;

import java.util.ArrayList;

public class EventViewActivity extends AppCompatActivity {

    TextView ename,cname,uname,date,edesc;
    Button btn;
    Event event;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);

         event = (Event) getIntent().getSerializableExtra("event");
        EventViewModel eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);

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
                UserPref userPref = new UserPref(getApplicationContext());
                String name = userPref.getName();
                ArrayList<String> arrayList = event.getAttendees();
                arrayList.add(name);
                event.setAttendees(arrayList);
                eventViewModel.addattendee(event);
                NotificationManagerClass.buildeventnotif(context, event.getEname(),event);
            }
        });

    }

    public void attendees(View view) {
        Intent intent = new Intent(getApplicationContext(),EventAttendees.class);
        intent.putExtra("event",event);
        startActivity(intent);

    }
}