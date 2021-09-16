package com.example.cse486.uniclubz.Model.Repository;

import com.example.cse486.uniclubz.Model.DAO.DonationDAO;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Donation;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;

public class DonationRepository implements DonationDAO {


    public ArrayList<Donation> getSampleDonations()
    {
        ArrayList<Donation> donations = new ArrayList<>();
        Donation donation = new Donation("Mr.XYZ", "City Hospital", "Banani, Dhaka", "Mr.PQRS", "4324334","14/7/2022","O+");

        Donation donation1 = donation;
        Donation donation2 = donation;
        Donation donation3 = donation;
        Donation donation4 = donation;

        donations.add(donation);
        donations.add(donation1);
        donations.add(donation2);
        donations.add(donation3);
        return donations;
    }
    @Override
    public void createDonation(Club club) {

    }

    @Override
    public void getAllDonations(University university) {

    }
}
