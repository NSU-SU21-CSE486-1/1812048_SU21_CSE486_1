package com.example.cse486.uniclubz.ViewModel;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.cse486.uniclubz.Model.Repository.StudentRepository;
import com.example.cse486.uniclubz.Model.entity.Student;

public class StudentViewModel extends AndroidViewModel {

    StudentRepository repository;
    public StudentViewModel(@NonNull Application application) {
        super(application);
        repository = new StudentRepository();
    }

    public void newStudent(String sname, String sbg, String sphone, String snid, String email, String sdob, String password, Activity activity)
    {
         repository.newStudent(sname,sbg,sphone,snid,email,sdob,password,activity);

    }

    public Student getBasicinfo(String uid)
    {

        return repository.getbasicinfo(uid);
    }

    public void addstudentinfo(String uid,Student student)
    {
        repository.addstudentinfo(uid,student);
    }
}
