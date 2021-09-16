package com.example.cse486.uniclubz.Model.DAO;




import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;

public interface EventDAO {

    void createEvent(Event event);

    ArrayList<Event> getAllEvents(University university);


}