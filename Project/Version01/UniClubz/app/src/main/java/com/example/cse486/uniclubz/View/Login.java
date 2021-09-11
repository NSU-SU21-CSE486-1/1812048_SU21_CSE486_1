package com.example.cse486.uniclubz.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.UserPref;
import com.example.cse486.uniclubz.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private String email, password;
    private FirebaseAuth mAuth;
    private UserPref userPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        userPref = new UserPref(getApplicationContext());
        ActivityLoginBinding binding  = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = binding.email.getText().toString().trim();
                password = binding.password.getText().toString().trim();

                if (!email.isEmpty() && !password.isEmpty()) {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        //  Log.d(TAG, "signInWithEmail:success");
                                        userPref.setLogin(true);
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // clears all previous activities task
                                        finish();
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w("firebase", "signInWithEmail:failure", task.getException());
                                        Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                                    }

                                }});
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(), "Please fill up the fields", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void signup(View view) {
        Intent intent = new Intent(getApplicationContext(),Signup.class);
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),LauncherActivity.class);
        startActivity(intent);
    }
}