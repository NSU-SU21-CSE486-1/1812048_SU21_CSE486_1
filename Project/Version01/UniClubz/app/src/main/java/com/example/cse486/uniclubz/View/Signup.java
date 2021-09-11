package com.example.cse486.uniclubz.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.UserPref;
import com.example.cse486.uniclubz.databinding.ActivitySignupBinding;
import com.example.cse486.uniclubz.Model.entity.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String email,password,sname,snid,sbg,sphone;
    private DatabaseReference mDatabase;
    private Student student;
    private UserPref userPref;
    private String sdob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ActivitySignupBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = binding.email.getText().toString().trim();
                password = binding.email.getText().toString().trim();
                sname = binding.name.getText().toString().trim();
                snid = binding.nid.getText().toString().trim();
                sphone = binding.phone.getText().toString().trim();
                sbg = binding.bgroup.getSelectedItem().toString();
                sdob = binding.dob.getText().toString();


                Context context = getApplicationContext();
                if (!email.isEmpty() && !password.isEmpty()) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("firebase", "createUserWithEmail:success");

                                        FirebaseUser user = mAuth.getCurrentUser();

                                        writeNewUser(user.getUid(),sname,sbg,sphone,snid,email,sdob);

                                         Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // clears all previous activities task
                                        finish();
                                         startActivity(intent);


                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("firebase", "createUserWithEmail:failure", task.getException());
                                        Toast.makeText( context,"Authentication failed.",Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });

                } else {

                    Toast.makeText(getApplicationContext(), "Please fill up the fields", Toast.LENGTH_LONG).show();

                }


            }
        });
    }


    public void Login(View view) {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),LauncherActivity.class);
        startActivity(intent);
    }


    public void writeNewUser(String userId, String sname, String sbg, String sphone, String snid, String email,String sdob) {
        Student user = new Student(snid, sname, sphone, sdob, sbg, email);

        mDatabase.child("users").child(userId).setValue(user);
    }

}