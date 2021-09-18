package com.example.cse486.uniclubz.Model.entity;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.ArrayList;

@IgnoreExtraProperties
public class Student implements Serializable {
    private String nid;
    private String name;
    private String phone;
    private String dob;
    private String bgroup;
    private String email;
    private ArrayList<University> universities;
    private ArrayList<Contact> contacts;

    public Student() {
    }



    public Student(String nid, String name, String contact, String dob, String bgroup, String email) {
        this.nid = nid;
        this.name = name;
        this.phone = contact;
        this.dob = dob;
        this.bgroup = bgroup;
        this.email = email;

    }

    public Student(String nid, String name, String phone, String dob, String bgroup, String email, ArrayList<University> universities, ArrayList<Contact> contacts) {
        this.nid = nid;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.bgroup = bgroup;
        this.email = email;
        this.universities = universities;
        this.contacts = contacts;
    }

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public void setUniversities(ArrayList<University> universities) {
        this.universities = universities;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBgroup() {
        return bgroup;
    }

    public void setBgroup(String bgroup) {
        this.bgroup = bgroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
