package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;


import com.example.project02.databinding.ActivityFinalBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinalActivity extends AppCompatActivity {
    private String[] headers = new String[]{"Name", "Date of Birth", "NID", "Blood Group", "University", "Department", "Study Level", "Student ID","Phone","Email"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        UserInfo userInfo = new UserInfo(getApplicationContext());
        ActivityFinalBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_final);

        String[] userarr = new String[]{userInfo.getName(),userInfo.getDOB(),userInfo.getNID(), userInfo.getBloodGroup(),userInfo.getUni(),
                userInfo.getDept(),userInfo.getStudy(),userInfo.getSID(),userInfo.getPhone(),userInfo.getEmail()};

        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i=0;i<10;i++) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("desc", headers[i]);
            datum.put("txt", userarr[i]);
            data.add(datum);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] {"desc", "txt"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});
        binding.displayList2.setAdapter(adapter);

    }
}