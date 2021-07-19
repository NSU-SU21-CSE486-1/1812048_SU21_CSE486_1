package com.example.cse486.project01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cse486.project01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private String name;
    private String bgroup;
    private String nid;
    private String dob;
    private boolean dobisset = true;
    private boolean bgroupisset = false;
    final String[] bgroups = {
            "A+", "A-", "B+", "B-","O+","O-","AB+","AB-" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding bindingUtil = DataBindingUtil.setContentView(this,R.layout.activity_main);

        bindingUtil.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = bindingUtil.nameEdittextview.getText().toString();
                bgroup = bindingUtil.bloodGroup.getText().toString();
                dob = bindingUtil.dobEdittextview.getText().toString();
                nid = bindingUtil.nidEdittextview.getText().toString();

                if(name.trim().length()>2 & nid.trim().length()>3 & dob.trim().length()>0 & bgroupisset)
                {
                    UserInfo userInfo = new UserInfo(getApplicationContext());
                    userInfo.setBloodGroup(bgroup);
                    userInfo.setDOB(dob);
                    userInfo.setNID(nid);
                    userInfo.setName(name);

                    Intent intent = new Intent(getApplicationContext(),UniversityAffiliation.class);
                    startActivity(intent);


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please fill up all Fields",Toast.LENGTH_LONG).show();
                }
            }
        });


        bindingUtil.bloodGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select Blood Group");
                builder.setItems(bgroups, new DialogInterface.OnClickListener() {@
                        Override
                public void onClick(DialogInterface dialog, int which) {
                    bgroup = bgroups[which];
                    bindingUtil.bloodGroup.setText(bgroup);
                    bgroupisset= true;

                }
                });
                builder.show();
            }
        });

    }


}