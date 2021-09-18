package com.example.cse486.uniclubz.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.cse486.uniclubz.Model.Repository.DonationRepository;
import com.example.cse486.uniclubz.Model.Repository.EventRepository;
import com.example.cse486.uniclubz.Model.entity.Donation;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;


public class DonationViewModel extends AndroidViewModel {

    DonationRepository repository;
    public DonationViewModel(@NonNull Application application) {
        super(application);
        repository = new DonationRepository();
    }

    public ArrayList<Donation> getallevents(String bg)
    {
        return repository.getAllDonations(bg);
    }

    public ArrayList<Donation> getsampledonations()
    {
        return DonationRepository.getSampleDonations();
    }

    public void createdonation(Donation donation){
        repository.createDonation(donation);
    }
}
