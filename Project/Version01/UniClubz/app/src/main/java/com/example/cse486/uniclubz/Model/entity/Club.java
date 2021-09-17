package com.example.cse486.uniclubz.Model.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Club implements Serializable {
    private String cname;
    private String uni;
    private ArrayList<String> admins;
    private ArrayList<String> memberlist;
    private String cdesc;
    private String cuid;



    public Club(String cname, String uni, String cdesc, ArrayList<String> admins, ArrayList<String> members) {
        this.cname = cname;
        this.uni = uni;
        this.admins = admins;
        this.memberlist = members;
        this.cdesc = cdesc;

    }

    public Club(String cname, String uni, ArrayList<String> admins, ArrayList<String> memberlist, String cdesc, String cuid) {
        this.cname = cname;
        this.uni = uni;
        this.admins = admins;
        this.memberlist = memberlist;
        this.cdesc = cdesc;
        this.cuid = cuid;
    }

    public ArrayList<String> getMemberlist() {
        return memberlist;
    }

    public void setMemberlist(ArrayList<String> memberlist) {
        this.memberlist = memberlist;
    }

    public String getCuid() {
        return cuid;
    }

    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public Club()
    {

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

    public ArrayList<String> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<String> admins) {
        this.admins = admins;
    }

    public ArrayList<String> getMembers() {
        return memberlist;
    }

    public void setMembers(ArrayList<String> members) {
        this.memberlist = members;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }
}
