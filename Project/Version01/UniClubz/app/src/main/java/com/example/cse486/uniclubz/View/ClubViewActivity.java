package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.ClubViewModel;
import com.example.cse486.uniclubz.ViewModel.UserPref;
import com.example.cse486.uniclubz.databinding.ActivityClubViewBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class ClubViewActivity extends AppCompatActivity {

    TextView uni,cname, status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_view);

        ActivityClubViewBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_club_view);
        ClubViewModel clubViewModel = new ViewModelProvider(this).get(ClubViewModel.class);


        Club club = (Club) getIntent().getSerializableExtra("club");
        ArrayList<String> admins = club.getAdmins();
        ArrayList<String> members = club.getMembers();
        String uid = FirebaseAuth.getInstance().getUid();
        if(admins.contains(uid))
        {

        }
        else if(members.contains(uid))
        {
            binding.addadmin.setVisibility(View.GONE);
            binding.addmem.setVisibility(View.GONE);
            binding.addevntbtn.setVisibility(View.GONE);
            binding.addbd.setVisibility(View.GONE);
            binding.status.setText("You are a member of this Club");
        }
        else
        {
            binding.addadmin.setVisibility(View.GONE);
            binding.addmem.setVisibility(View.GONE);
            binding.addevntbtn.setVisibility(View.GONE);
            binding.addbd.setVisibility(View.GONE);
            binding.status.setText("You are not a member of this Club");
            binding.join.setVisibility(View.VISIBLE);

            binding.join.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    members.add(uid);
                    club.setMemberlist(members);
                    clubViewModel.addmember(club,uid);
                    onRestart();
                }
            });
        }
        uni = findViewById(R.id.uniname);
        cname = findViewById(R.id.clubname);
        status = findViewById(R.id.status);

        uni.setText(club.getUni());
        cname.setText(club.getCname());






    }

    public void toevents(View view) {
        Intent intent = new Intent(getApplicationContext(),EventListActivity.class);
        startActivity(intent);
    }

    public void tobd(View view) {
        Intent intent = new Intent(getApplicationContext(),BloodDonationListActivity.class);
        startActivity(intent);
    }

    public void addevents(View view) {
        Intent intent = new Intent(getApplicationContext(),AddEvent.class);
        startActivity(intent);
    }

    public void adddonation(View view) {
        Intent intent = new Intent(getApplicationContext(),AddDonationActivity.class);
        startActivity(intent);
    }

    public void addmem(View view) {
        Intent intent = new Intent(getApplicationContext(),AddMemberActivity.class);
        startActivity(intent);
    }

    public void addadmin(View view) {
        Intent intent = new Intent(getApplicationContext(),AddMemberActivity.class);
        startActivity(intent);
    }
}