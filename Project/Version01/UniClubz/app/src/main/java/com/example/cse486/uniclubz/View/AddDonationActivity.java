package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cse486.uniclubz.Model.entity.Donation;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.DonationViewModel;
import com.example.cse486.uniclubz.ViewModel.EventViewModel;
import com.example.cse486.uniclubz.databinding.ActivityAddDonationBinding;
import com.example.cse486.uniclubz.databinding.ActivityAddEventBinding;

public class AddDonationActivity extends AppCompatActivity {
    String name,ec,ebg,edate,phone,address,hospial;
    ActivityAddDonationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_donation);




    }

    public void post(View view) {
        DonationViewModel donationViewModel = new ViewModelProvider(this).get(DonationViewModel.class);
        name=binding.name.getText().toString().trim();
        edate=binding.dob.getText().toString().trim();
        address=binding.address.getText().toString().trim();
        ec=binding.contactname.getText().toString().trim();
        phone=binding.phone.getText().toString().trim();
        hospial=binding.hospital.getText().toString().trim();


        if(binding.bgroup.getSelectedItem()!=null) {
            ebg = binding.bgroup.getSelectedItem().toString();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            return;
        }

        Donation donation = new Donation(name,hospial,address,ec,phone,edate,ebg);
        donationViewModel.createdonation(donation);
        finish();
    }
}