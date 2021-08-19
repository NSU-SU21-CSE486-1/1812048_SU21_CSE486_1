package com.example.project02;

import java.io.Serializable;

public class UniAffiliation implements Serializable {

    private String uniname;
    private String unisid;
    private String unidept;
    private String unilevel;


    public UniAffiliation(){

    }

    public UniAffiliation(String uniname, String unisid, String unidept, String unilevel) {
        this.uniname = uniname;
        this.unisid = unisid;
        this.unidept = unidept;
        this.unilevel = unilevel;
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
}
