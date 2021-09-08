package com.afra.cse486.project03.datasource.local.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "uni_affiliation")
public class UniAffiliation implements Serializable {

    @ColumnInfo(name = "uniname")
    private String uniname;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "sid")
    private String unisid;

    @ColumnInfo(name = "dept")
    private String unidept;

    @ColumnInfo(name = "level")
    private String unilevel;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uniemail")
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

    public void setUniname(String uniname) {
        this.uniname = uniname;
    }

    public void setUnisid(@NonNull String unisid) {
        this.unisid = unisid;
    }

    public void setUnidept(String unidept) {
        this.unidept = unidept;
    }

    public void setUnilevel(String unilevel) {
        this.unilevel = unilevel;
    }

    public void setEmail(@NonNull String email) {
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
