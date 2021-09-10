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

    @ColumnInfo(name = "sid")
    private String sid;

    @ColumnInfo(name = "dept")
    private String dept;

    @ColumnInfo(name = "level")
    private String level;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uniemail")
    private String uniemail;


    public UniAffiliation(){

    }

    public UniAffiliation(String uniname, String sid, String dept, String level) {
        this.uniname = uniname;
        this.sid = sid;
        this.dept = dept;
        this.level = level;
        this.uniemail = "N/A";
    }
    public UniAffiliation(String uniname, String sid, String dept, String level,String uniemail) {
        this.uniname = uniname;
        this.sid = sid;
        this.dept = dept;
        this.level = level;
        if(uniemail.length()==0) uniemail ="N/A";
        this.uniemail = uniemail;
    }

    public String getUniname() {
        return uniname;
    }

    public void setUniname(String uniname) {
        this.uniname = uniname;
    }

    @NonNull
    public String getSid() {
        return sid;
    }

    public void setSid(@NonNull String sid) {
        this.sid = sid;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @NonNull
    public String getUniemail() {
        return uniemail;
    }

    public void setUniemail(@NonNull String uniemail) {
        this.uniemail = uniemail;
    }
}
