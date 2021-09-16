package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cse486.uniclubz.Model.DAO.DonationDAO;
import com.example.cse486.uniclubz.Model.Repository.DonationRepository;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Donation;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.View.Adapter.ClubAdapter;
import com.example.cse486.uniclubz.View.Adapter.DonationAdapter;
import com.example.cse486.uniclubz.ViewModel.DonationViewModel;

import java.util.ArrayList;

public class BloodDonationListActivity extends AppCompatActivity {

    DonationAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donation_list);


        DonationViewModel donationViewModel = new ViewModelProvider(this).get(DonationViewModel.class);
        ArrayList<Donation> donations = donationViewModel.getsampledonations();

        adapter= new DonationAdapter(donations,getApplicationContext());
        RecyclerView recyclerView = findViewById(R.id.drv);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}