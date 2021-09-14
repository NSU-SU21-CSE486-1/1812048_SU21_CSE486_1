package com.example.cse486.uniclubz.Model.Repository;

import com.example.cse486.uniclubz.Model.DAO.ClubDao;
import com.example.cse486.uniclubz.Model.DAO.EventDAO;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;

public class EventRepository implements EventDAO {

    private String uid = "QFGmMdADhIMSYpb4BVwwt2zB8XG2";


   public ArrayList<Event> getSampleEvents(){
        ArrayList<Event> events = new ArrayList<>();
        String[] admins1 = {uid};
        String[] admins2 = {"12431241421"};
        Event event = new Event();

        return events;
    }

    @Override
    public void createEvent(Club club) {

    }

    @Override
    public void getAllEvents(University university) {

    }
}
