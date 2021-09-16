package com.example.cse486.uniclubz.Model.entity;

import java.io.Serializable;

public class Event implements Serializable {
    private String ename;
    private String eclub;
    private String estatus;
    private String euni;
    private String edesc;
    private String edate;

    public Event(String ename, String eclub, String estatus, String euni, String edesc, String edate) {
        this.ename = ename;
        this.eclub = eclub;
        this.estatus = estatus;
        this.euni = euni;
        this.edesc = edesc;
        this.edate = edate;

    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEclub() {
        return eclub;
    }

    public void setEclub(String eclub) {
        this.eclub = eclub;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getEuni() {
        return euni;
    }

    public void setEuni(String euni) {
        this.euni = euni;
    }

    public String getEdesc() {
        return edesc;
    }

    public void setEdesc(String edesc) {
        this.edesc = edesc;
    }
}
