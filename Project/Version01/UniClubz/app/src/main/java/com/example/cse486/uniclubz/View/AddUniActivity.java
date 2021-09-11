package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.UserPref;
import com.example.cse486.uniclubz.databinding.ActivityAddUniBinding;

public class AddUniActivity extends AppCompatActivity {
    private boolean uni;
    private boolean dept;
    private String uni_name;
    private String dept_name;
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
        setContentView(R.layout.activity_add_uni);
        ActivityAddUniBinding bindingUtil = DataBindingUtil.setContentView(this,R.layout.activity_add_uni);
        UserPref userInfo = new UserPref(getApplicationContext());
        if(getCallingActivity()!=null)
        {
            bindingUtil.uniemail.setVisibility(View.VISIBLE);
        }


        bindingUtil.uninameDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int abc;
                uni_name = parent.getItemAtPosition(position).toString();
                if(uni_name.equals("NSU"))
                {
                    abc=R.array.NSUdept;
                }
                else if(uni_name.equals("BRAC"))
                {
                    abc=R.array.BRACdept;
                }
                else
                {
                    abc=R.array.BUETdept;
                }
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), abc, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bindingUtil.deptDropdown.setAdapter(adapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        bindingUtil.uniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bindingUtil.uninameDropdown.getSelectedItem()!=null) {
                    uni_name = bindingUtil.uninameDropdown.getSelectedItem().toString();
                    uni=true;
                }
                if(bindingUtil.deptDropdown.getSelectedItem()!=null) {
                    dept_name = bindingUtil.deptDropdown.getSelectedItem().toString();
                    dept=true;
                }

                sid = bindingUtil.sidEdittextview.getText().toString();
                study = bindingUtil.study.getText().toString();


                if(uni & sid.trim().length()>3 & dept & studyisset)
                {

                    userInfo.setUni(uni_name);
                    userInfo.setDept(dept_name);
                    userInfo.setStudy(study);
                    userInfo.setSID(sid);

                    if(getCallingActivity()!=null)
                    {
                        Intent data = new Intent();
                        data.putExtra("name",uni_name);
                        data.putExtra("dept",dept_name);
                        data.putExtra("sid",sid);
                        data.putExtra("lvl",study);
                        String email = bindingUtil.uniemail.getText().toString();
                        data.putExtra("email",email);
                        setResult(RESULT_OK,data);
                        finish();

                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), Profile.class);
                        startActivity(intent);
                    }


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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddUniActivity.this);
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