package com.example.cse486.uniclubz.modelclasses;

public class Student {
    private String nid;
    private String name;
    private String contact;
    private String dob;
    private String bgroup;
    private String email;
    public Student() {
    }


    public Student(String nid, String name, String contact, String dob, String bgroup, String email) {
        this.nid = nid;
        this.name = name;
        this.contact = contact;
        this.dob = dob;
        this.bgroup = bgroup;
        this.email = email;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
