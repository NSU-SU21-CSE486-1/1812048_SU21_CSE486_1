package com.example.cse486.uniclubz.Model.DAO;




import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Donation;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;

public interface DonationDAO {

    void createDonation(Donation donation);

    ArrayList<Event> getAllDonations(University university);


}