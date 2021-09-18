package com.example.cse486.uniclubz.Model.DAO;


import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;

public interface ClubDao {

    void createClub(Club club,String uid);

    void getAllclubs(University university);

    ArrayList<Club> getAllclubs();

    ArrayList<Club> getMyClubs(String uid);
    
    ArrayList<Club> getAdminClubs(String uid);


    void addmember(String cuid, Club club, String uid);

    void addadmin(String cuid, Club club, String uid);


}