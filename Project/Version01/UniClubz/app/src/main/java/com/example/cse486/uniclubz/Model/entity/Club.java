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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String[] getAdmins() {
        return admins;
    }

    public void setAdmins(String[] admins) {
        this.admins = admins;
    }

    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        this.members = members;
    }
}
