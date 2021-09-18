package com.example.cse486.uniclubz.Model.DAO;




import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Donation;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;

public interface DonationDAO {

    void createDonation(Donation donation);

    //Get donations with user's bg
    ArrayList<Donation> getAllDonations(String bg);

    void adddonor(String uid,Donation donation);


}