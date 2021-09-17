package com.example.cse486.uniclubz.Model.Repository;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.cse486.uniclubz.Model.DAO.StudentDAO;
import com.example.cse486.uniclubz.Model.entity.Contact;
import com.example.cse486.uniclubz.Model.entity.Student;
import com.example.cse486.uniclubz.Model.entity.University;
import com.example.cse486.uniclubz.View.MainActivity;
import com.example.cse486.uniclubz.View.Signup;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class StudentRepository implements StudentDAO {
    DatabaseReference databaseReference;
    @Override
    public boolean newStudent(String sname, String sbg, String sphone, String snid, String email, String sdob, String password, Activity activity) {
        final boolean[] flag = new boolean[1];
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("firebase", "createUserWithEmail:success");

                            FirebaseUser user = mAuth.getCurrentUser();

                            databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
                            Student student = new Student(snid, sname, sphone, sdob, sbg, email);
                            String uid = databaseReference.push().getKey();
                            databaseReference.child("users").child(uid).setValue(user);
                            flag[0] = true;




                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("firebase", "createUserWithEmail:failure", task.getException());

                            flag[0]=false;


                        }

                        // ...
                    }
                });


        return flag[0];
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
        return null;
    }
}
