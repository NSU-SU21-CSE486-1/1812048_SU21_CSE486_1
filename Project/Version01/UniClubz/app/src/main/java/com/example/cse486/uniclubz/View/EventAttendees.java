package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventAttendees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_attendees);

        Event event = (Event) getIntent().getSerializableExtra("event");
        ArrayList<String> woi = event.getAttendees();

        ListView listView = findViewById(R.id.attndlist);

        if(woi==null || woi.size()<=0)
        {
            Toast.makeText(getApplicationContext(),"No Attendees yet",Toast.LENGTH_SHORT).show();
        }
        else {

            String[] numarr = new String[woi.size()];
            woi.toArray(numarr);
            List<Map<String, String>> data = new ArrayList<Map<String, String>>();
            for (int i = 0; i < woi.size(); i++) {
                Map<String, String> datum = new HashMap<String, String>(2);
                datum.put("desc","Name");
                datum.put("txt", numarr[i]);
                data.add(datum);
            }
            SimpleAdapter adapter = new SimpleAdapter(this, data,
                    android.R.layout.simple_list_item_2,
                    new String[]{"desc", "txt"},
                    new int[]{android.R.id.text1,
                            android.R.id.text2});

            listView.setAdapter(adapter);

        }
    }
}