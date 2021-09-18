package com.example.cse486.uniclubz.Model.DAO;


import android.app.Activity;

import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Contact;
import com.example.cse486.uniclubz.Model.entity.Student;
import com.example.cse486.uniclubz.Model.entity.University;

import java.util.ArrayList;

public interface StudentDAO {

    void newStudent(String sname, String sbg, String sphone, String snid, String email, String sdob, String password, Activity activity);

    ArrayList<University> getAllUni(String uid);

    ArrayList<Contact> getAllcontacts();

    Student getbasicinfo(String uid);


}