package com.example.cse486.uniclubz.Model.DAO;




import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.University;

public interface DonationDAO {

    void createDonation(Club club);

    void getAllDonations(University university);


}