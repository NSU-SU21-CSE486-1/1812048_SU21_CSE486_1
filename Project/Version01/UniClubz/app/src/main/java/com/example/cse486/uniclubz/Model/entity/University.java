package com.example.cse486.uniclubz.Model.entity;

public class University {
    private String uniname;
    private String sid;
    private String dept;
    private String level;
    private String uniemail;


    public University(String uniname, String sid, String dept, String level, String uniemail) {
        this.uniname = uniname;
        this.sid = sid;
        this.dept = dept;
        this.level = level;
        this.uniemail = uniemail;
    }

    @Override
    public String toString() {
        return "University{" +
                "uniname='" + uniname + '\'' +
                ", sid='" + sid + '\'' +
                ", dept='" + dept + '\'' +
                ", level='" + level + '\'' +
                ", uniemail='" + uniemail + '\'' +
                '}';
    }

    public String getUniname() {
        return uniname;
    }

    public void setUniname(String uniname) {
        this.uniname = uniname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
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

    public String getUniemail() {
        return uniemail;
    }

    public void setUniemail(String uniemail) {
        this.uniemail = uniemail;
    }
}
