package com.example.project02;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.project02.ui.main.SectionsPagerAdapter;
import com.example.project02.databinding.ActivityMain2Binding;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserInfo userInfo = new UserInfo(getApplicationContext());
        if(userInfo.getfirst()) {
            ArrayList<UniAffiliation> uniAffiliations = new ArrayList<>();
            ArrayList<Phone> phones = new ArrayList<>();
            ArrayList<Student> students = new ArrayList<>();
            uniAffiliations.add(new UniAffiliation("BUET", "1234567890", "CSE", "BS"));
            phones.add(new Phone("Office", "1234567890"));
            students.add(new Student("Sarah Ansari", "1234567890"));

            SerializableManager.saveSerializable(getApplicationContext(),uniAffiliations, "unis.txt");
            SerializableManager.saveSerializable(getApplicationContext(), phones, "phones.txt");
            SerializableManager.saveSerializable(getApplicationContext(),students, "students.txt");
            userInfo.setfirst(false);
        }


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;





        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplicationContext(),MemberInfoActivity.class);
                startActivity(intent);

            }
        });
    }


}

