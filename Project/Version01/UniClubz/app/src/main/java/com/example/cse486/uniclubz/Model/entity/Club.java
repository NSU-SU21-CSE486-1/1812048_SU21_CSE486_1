package com.example.cse486.uniclubz.Model.entity;

public class Club {
    private String cname;
    private String uni;
    private String[] admins;
    private String[] members;

    public Club(String cname, String uni) {
        this.cname = cname;
        this.uni = uni;
    }

    public Club(String cname, String uni, String[] admins, String[] members) {
        this.cname = cname;
        this.uni = uni;
        this.admins = admins;
        this.members = members;
    }
}
