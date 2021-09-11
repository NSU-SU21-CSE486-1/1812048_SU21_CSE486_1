package com.example.cse486.uniclubz.Model.entity;

public class Student {
    private String nid;
    private String name;
    private String phone;
    private String dob;
    private String bgroup;
    private String email;
    private boolean isSet;
    public Student() {
    }



    public Student(String nid, String name, String contact, String dob, String bgroup, String email) {
        this.nid = nid;
        this.name = name;
        this.phone = contact;
        this.dob = dob;
        this.bgroup = bgroup;
        this.email = email;
        setSet(true);
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

    public boolean isSet() {
        return isSet;
    }

    public void setSet(boolean set) {
        isSet = set;
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
