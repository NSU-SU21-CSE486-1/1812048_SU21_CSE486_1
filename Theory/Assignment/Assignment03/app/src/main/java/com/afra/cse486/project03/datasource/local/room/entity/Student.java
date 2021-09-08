package com.afra.cse486.project03.datasource.local.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "student")
public class Student implements Serializable {



    @ColumnInfo(name = "name")
    private String stdname;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String stdnid;


    public Student(){

    }
    public Student(@NonNull String name, @NonNull String nid)
    {
        stdname=name;
        stdnid=nid;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    public void setStdnid(@NonNull String stdnid) {
        this.stdnid = stdnid;
    }

    @NonNull
    public String getStdname() {
        return stdname;
    }
    @NonNull
    public String getStdnid() {
        return stdnid;
    }


}
