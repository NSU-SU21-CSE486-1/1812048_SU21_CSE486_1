package com.example.cse486.uniclubz.Model.DAO;




import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.University;

public interface EventDAO {

    void createEvent(Club club);

    void getAllEvents(University university);


}