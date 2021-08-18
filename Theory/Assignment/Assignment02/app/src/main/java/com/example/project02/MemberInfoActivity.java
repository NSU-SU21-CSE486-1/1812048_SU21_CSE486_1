package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.project02.databinding.ActivityMemberInfoBinding;
import com.example.project02.databinding.FragmentPhonesBinding;

import java.util.ArrayList;

public class MemberInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);

        UserInfo userInfo = new UserInfo(getApplicationContext());
        ActivityMemberInfoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_member_info);

        Boolean first = userInfo.getfirst();
        if (first) {
            Student student1 = new Student("Arif Hossain", "123456789");
            Student student2 = new Student("Sarah Khan", "987654211");
            Student student3 = new Student("Dalia Saif", "333444555");
            Student student4 = new Student("Sanam Saif", "333444555");
            Student student5 = new Student("Rakif Ahmed", "333444555");
            ArrayList<Student> woi = new ArrayList<>();
            woi.add(student1);
            woi.add(student2);
            woi.add(student3);
            woi.add(student4);
            woi.add(student5);

            SerializableManager.saveSerializable(getApplicationContext(), woi, "students.txt");

        } else {

            ArrayList<Student> arrayList = SerializableManager.readSerializable(getApplicationContext(), "student.txt");
            ArrayList<String> names = new ArrayList<String>();
            ArrayList<String> nid = new ArrayList<String>();
            for (Student a :
                    arrayList) {
                names.add(a.getStdname());
                nid.add(a.getStdnid());

            }
        }


        //get Submitted NID and student name
        // put to recycler view


    }

}

