package com.afra.cse486.project03.datasource.local.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "phone")
public class Phone implements Serializable {

    @ColumnInfo(name = "tag")
    private String tag;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "number")
    private String number;


    public Phone(){

    }
    public Phone(String tg, String num)
    {
        tag=tg;
        number= num;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setNumber(@NonNull String number) {
        this.number = number;
    }

    public String getTag() {
        return tag;
    }

    public String getNumber() {
        return number;
    }


}
