package com.example.cse486.uniclubz.Model.Repository;

import androidx.annotation.NonNull;

import com.example.cse486.uniclubz.Model.DAO.DonationDAO;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Donation;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.Model.entity.University;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DonationRepository implements DonationDAO {

DatabaseReference databaseReference;
    private static Set<Donation> alevents = new HashSet<>();

    @Override
    public void createDonation(Donation donation) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("donations");
        String buid = databaseReference.push().getKey();
        donation.setBuid(buid);
        databaseReference.child(buid).setValue(donation);
    }

    @Override
    public ArrayList<Event> getAllDonations(University university) {

        final ArrayList<String>[] eventsid = new ArrayList[]{new ArrayList<>()};

        databaseReference = FirebaseDatabase.getInstance().getReference().child("donations");

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                alevents.clear();
                for (DataSnapshot dsp : snapshot.getChildren()) {
                    alevents.add(dsp.getValue(Event.class)); //add result into array list


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ArrayList<Event> events = new ArrayList<>();
        events.addAll(alevents);
        return events;

        return null;
    }

    public static ArrayList<Donation> getSampleDonations()
    {
        ArrayList<Donation> donations = new ArrayList<>();
        Donation donation = new Donation("Mr.XYZ", "City Hospital", "Banani, Dhaka", "Mr.PQRS", "4324334","14/7/2022","O+");

        Donation donation1 = new Donation(donation.getPatient(),donation.getHospital(),donation.getAddress(),donation.getContactname(),donation.getContact(),donation.getDate(),donation.getBgroup());
        Donation donation2 = new Donation(donation.getPatient(),donation.getHospital(),donation.getAddress(),donation.getContactname(),donation.getContact(),donation.getDate(),donation.getBgroup());
        Donation donation3 = new Donation(donation.getPatient(),donation.getHospital(),donation.getAddress(),donation.getContactname(),donation.getContact(),donation.getDate(),donation.getBgroup());
        Donation donation4 = new Donation(donation.getPatient(),donation.getHospital(),donation.getAddress(),donation.getContactname(),donation.getContact(),donation.getDate(),donation.getBgroup());



        donation1.setHospital("XYZ Clinic");
        donation3.setHospital("Hello Hospital");
        donations.add(donation);
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
        return donations;
    }
}
