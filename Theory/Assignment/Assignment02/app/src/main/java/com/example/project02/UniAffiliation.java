package com.example.project02;

import java.io.Serializable;

public class UniAffiliation implements Serializable {

    private String uniname;
    private String unisid;
    private String unidept;
    private String unilevel;
    private String email;


    public UniAffiliation(){

    }

    public UniAffiliation(String uniname, String unisid, String unidept, String unilevel) {
        this.uniname = uniname;
        this.unisid = unisid;
        this.unidept = unidept;
        this.unilevel = unilevel;
        this.email = "N/A";
    }
    public UniAffiliation(String uniname, String unisid, String unidept, String unilevel,String email) {
        this.uniname = uniname;
        this.unisid = unisid;
        this.unidept = unidept;
        this.unilevel = unilevel;
        if(email.length()==0) email ="N/A";
        this.email = email;
    }

    public String getUniname() {
        return uniname;
    }

    public String getUnisid() {
        return unisid;
    }

    public String getUnidept() {
        return unidept;
    }

    public String getUnilevel() {
        return unilevel;
    }

    public String getEmail() {
        return email;
    }
}
