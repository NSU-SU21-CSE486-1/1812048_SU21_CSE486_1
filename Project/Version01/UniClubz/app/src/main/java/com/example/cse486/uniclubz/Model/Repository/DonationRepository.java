package com.example.cse486.uniclubz.Model.Repository;

import com.example.cse486.uniclubz.Model.DAO.DonationDAO;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Donation;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;

public class DonationRepository implements DonationDAO {



    @Override
    public void createDonation(Donation donation) {

    }

    @Override
    public ArrayList<Event> getAllDonations(University university) {

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


        donation1.setBgroup("AB+");
        donation1.setHospital("XYZ Clinic");
        donation2.setBgroup("B+");
        donation3.setHospital("Hello Hospital");
        donations.add(donation);
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
        return donations;
    }
}
