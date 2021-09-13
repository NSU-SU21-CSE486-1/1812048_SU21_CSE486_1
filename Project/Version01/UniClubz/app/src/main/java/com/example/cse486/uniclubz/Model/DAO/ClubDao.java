package com.example.cse486.uniclubz.Model.DAO;


import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.University;

public interface ClubDao {

    void createClub(Club club);

    void getAllclubs(University university);

    void getAllclubs();

    void getMyClubs(String uid);
    
    void getAdminClubs(String uid);

}