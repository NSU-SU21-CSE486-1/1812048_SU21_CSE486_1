package com.afra.cse486.project03;

import java.io.Serializable;

public class Student implements Serializable {
    private String stdname;
    private String stdnid;


    public Student(){

    }
    public Student(String name, String nid)
    {
        stdname=name;
        stdnid=nid;
    }

    public String getStdname() {
        return stdname;
    }

    public String getStdnid() {
        return stdnid;
    }


}
