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
        Event event = new Event("Boiskhakh Mela", "NSUSS", "Public", "NSU", "Join us at the fair for Boishakhi, Bengali New Year.","14/4/2022");
        Event event1,event2,event3,event4 = event;
        return events;
    }

    @Override
    public void createEvent(Club club) {

    }

    @Override
    public void getAllEvents(University university) {

    }
}
