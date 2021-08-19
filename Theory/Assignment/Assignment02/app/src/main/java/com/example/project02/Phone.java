package com.example.project02;

import java.io.Serializable;

public class Phone implements Serializable {

    private String tag;
    private String number;


    public Phone(){

    }
    public Phone(String tg, String num)
    {
        tag=tg;
        number= num;
    }

    public String getTag() {
        return tag;
    }

    public String getNumber() {
        return number;
    }


}
