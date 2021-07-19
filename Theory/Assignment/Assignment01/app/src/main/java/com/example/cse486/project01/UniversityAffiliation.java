package com.example.cse486.project01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cse486.project01.databinding.ActivityMainBinding;
import com.example.cse486.project01.databinding.ActivityUniversityAffiliationBinding;

public class UniversityAffiliation extends AppCompatActivity {
    private String uni;
    private String dept;
    private String sid;
    private String study;
    private boolean dobisset = true;
    private boolean bgroupisset = false;
    final String[] studies = {
            "BS", "MS", "Post-Doc", "PhD"};
    private boolean studyisset = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_affiliation);
        ActivityUniversityAffiliationBinding bindingUtil = DataBindingUtil.setContentView(this,R.layout.activity_university_affiliation);
        UserInfo userInfo = new UserInfo(getApplicationContext());

        bindingUtil.prevInfo.setText("Name: "+userInfo.getName()+"\nDOB: "+userInfo.getDOB()+"\nNID: "+userInfo.getNID()+"\nBlood Group: "+userInfo.getBloodGroup());

        bindingUtil.uniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uni = bindingUtil.uninameEdittextview.getText().toString();
                dept = bindingUtil.deptEdittextview.getText().toString();
                sid = bindingUtil.sidEdittextview.getText().toString();
                study = bindingUtil.study.getText().toString();

                if(uni.trim().length()>2 & sid.trim().length()>3 & dept.trim().length()>0 & studyisset)
                {

                    userInfo.setUni(uni);
                    userInfo.setDept(dept);
                    userInfo.setStudy(study);
                    userInfo.setSID(sid);

                    Intent intent = new Intent(getApplicationContext(),DisplayInfoActivity.class);
                    startActivity(intent);


                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Please fill up all Fields",Toast.LENGTH_LONG).show();
                }
            }
        });


        bindingUtil.study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UniversityAffiliation.this);
                builder.setTitle("Select Study Level");
                builder.setItems(studies, new DialogInterface.OnClickListener() {@
                        Override
                public void onClick(DialogInterface dialog, int which) {
                    study = studies[which];
                    bindingUtil.study.setText(study);
                    studyisset= true;

                }
                });
                builder.show();
            }
        });
    }
}