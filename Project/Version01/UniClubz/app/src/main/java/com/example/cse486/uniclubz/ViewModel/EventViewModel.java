package com.example.cse486.uniclubz.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.cse486.uniclubz.Model.Repository.EventRepository;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;


public class EventViewModel extends AndroidViewModel {

    EventRepository repository;
    public EventViewModel(@NonNull Application application) {
        super(application);
        repository = new EventRepository();
    }

    public ArrayList<Event> getallevents(University university)
    {
        return repository.getAllEvents(university);
    }

    public ArrayList<Event> getsampleevents()
    {
        return EventRepository.getSampleEvents();
    }

    public void createvent(Event event){
        repository.createEvent(event);
    }
}
