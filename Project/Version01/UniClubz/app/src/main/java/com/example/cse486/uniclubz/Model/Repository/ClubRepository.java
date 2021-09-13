package com.example.cse486.uniclubz.Model.Repository;

import com.example.cse486.uniclubz.Model.DAO.ClubDao;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;

public class ClubRepository implements ClubDao {

    private String uid = "QFGmMdADhIMSYpb4BVwwt2zB8XG2";

    @Override
    public void createClub(Club club) {

    }

    @Override
    public void getAllclubs(University university) {

    }

    @Override
    public void getAllclubs() {

    }

    @Override
    public void getMyClubs(String uid) {

    }

    @Override
    public void getAdminClubs(String uid) {

    }

   public ArrayList<Club> getSampleClubs(){
        ArrayList<Club> clubs = new ArrayList<>();
        String[] admins1 = {uid};
        String[] admins2 = {"12431241421"};
        Club club = new Club("NSU YES!","NSU",admins1,admins1);
       Club club1 = new Club("BRAC Debate Club","BRAC",admins1,admins1);
       Club club2= new Club("NSU ACM-W","NSU",admins2,admins2);
       Club club3 = new Club("BRAC CSE Club","BRAC",admins2,admins1);
       Club club4 = new Club("NSUSS","NSU",admins1,admins2);
       clubs.add(club);
       clubs.add(club1);
       clubs.add(club2);
       clubs.add(club3);
       clubs.add(club4);

        return clubs;
    }
}
