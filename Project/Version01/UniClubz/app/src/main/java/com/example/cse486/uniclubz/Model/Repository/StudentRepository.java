package com.example.cse486.uniclubz.Model.Repository;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cse486.uniclubz.Model.DAO.StudentDAO;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.Contact;
import com.example.cse486.uniclubz.Model.entity.Student;
import com.example.cse486.uniclubz.Model.entity.University;
import com.example.cse486.uniclubz.View.MainActivity;
import com.example.cse486.uniclubz.View.Signup;
import com.example.cse486.uniclubz.ViewModel.UserPref;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentRepository implements StudentDAO {
    DatabaseReference databaseReference;
    private  static Student student;
    @Override
    public void newStudent(String sname, String sbg, String sphone, String snid, String email, String sdob, String password, Activity activity) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        String uid = databaseReference.push().getKey();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("firebase", "createUserWithEmail:success");


                            Log.d("hello","hereee");





                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("firebase", "createUserWithEmail:failure", task.getException());




                        }

                        // ...
                    }
                });

        Student student = new Student(snid, sname, sphone, sdob, sbg, email);
        databaseReference.child(uid).setValue(student).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()) Log.d("hello","User Added");
                else Log.d("hello","Could not add user");
            }
        });



    }

    public void addstudentinfo(String uid,Student student)
    {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        databaseReference.child(uid).setValue(student);
    }

    @Override
    public ArrayList<University> getAllUni(String uid) {
        return null;
    }

    @Override
    public ArrayList<Contact> getAllcontacts() {
        return null;
    }

    @Override
    public Student getbasicinfo(String uid) {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                student = (Student) snapshot.getValue(Student.class);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return student;
    }
}
