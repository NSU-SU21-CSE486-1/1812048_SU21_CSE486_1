package com.example.cse486.uniclubz.Model.Repository;

import androidx.annotation.NonNull;

import com.example.cse486.uniclubz.Model.DAO.EventDAO;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Event;
import com.example.cse486.uniclubz.Model.entity.University;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EventRepository implements EventDAO {

    private static String uid = "QFGmMdADhIMSYpb4BVwwt2zB8XG2";
    DatabaseReference databaseReference;
    private static Set<Event> alevents = new HashSet<>();


    @Override
    public void createEvent(Event event) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("events");
        String euid = databaseReference.push().getKey();
        event.setEuid(euid);
        databaseReference.child(euid).setValue(event);

    }

    @Override
    public ArrayList<Event> getAllEvents(University university) {

        final ArrayList<String>[] eventsid = new ArrayList[]{new ArrayList<>()};

        databaseReference = FirebaseDatabase.getInstance().getReference().child("events");

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                alevents.clear();
                for (DataSnapshot dsp : snapshot.getChildren()) {
                    alevents.add(dsp.getValue(Event.class)); //add result into array list


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ArrayList<Event> events = new ArrayList<>();
        events.addAll(alevents);
        return events;
    }

    public static ArrayList<Event> getSampleEvents(){
        ArrayList<Event> events = new ArrayList<>();
        String[] admins1 = {uid};
        String[] admins2 = {"12431241421"};
        String[] attnds = {"Arif Rahman","Rana Dey","Sania Akhter"};
        Event event = new Event("Boiskhakh Mela", "NSUSS", "Public", "NSU", "Join us at the fair for Boishakhi, Bengali New Year.","14/4/2022");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(attnds[0]);
        arrayList.add(attnds[1]);
        arrayList.add(attnds[2]);
        event.setAttendees(arrayList);
        Event event1 = new Event("Concert Fest", "NSUCC", "Public", "NSU", "Join us at the concert","05/04/2022");

        Event event2 = new Event(event.getEname(),event.getEclub(),event.getEstatus(),event.getEuni(),event.getEdesc(),event.getEdate());
        Event event3 = event;
        Event event4 = event;

        event2.setEname("Pohela Falgun");
        event2.setEdate("5/2/2022");

        events.add(event);
        events.add(event1);
        events.add(event2);
        events.add(event3);
        return events;
    }
}
