package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.EventViewModel;
import com.example.cse486.uniclubz.databinding.ActivityAddEventBinding;

public class AddEvent extends AppCompatActivity {
    String ename,eclub,euni,edate,estatus,edesc;
    ActivityAddEventBinding eventBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

       eventBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_event);



        EventViewModel eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);


    }

    public void post(View view) {
        ename=eventBinding.name.getText().toString().trim();
        edate=eventBinding.dob.getText().toString().trim();
        edesc=eventBinding.desc.getText().toString().trim();
        eclub=eventBinding.cname.getText().toString().trim();


        if(eventBinding.uni.getSelectedItem()!=null) {
            euni = eventBinding.uni.getSelectedItem().toString();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            return;
        }
        if(eventBinding.status.getSelectedItem()!=null) {
            estatus = eventBinding.status.getSelectedItem().toString();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            return;
        }

        Event event = new Event(ename,eclub,estatus,euni,edesc,edate);
        EventViewModel eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);
        eventViewModel.createvent(event);
        finish();
    }
}