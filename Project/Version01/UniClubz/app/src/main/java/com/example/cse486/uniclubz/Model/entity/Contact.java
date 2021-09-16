package com.example.cse486.uniclubz.Model.entity;

import java.io.Serializable;

public class Contact implements Serializable {

    String type;
    String contact;
    String tag;

    public Contact(String type, String contact, String tag) {
        this.type = type;
        this.contact = contact;
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
