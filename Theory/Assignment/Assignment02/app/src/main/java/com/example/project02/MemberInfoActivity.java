package com.example.project02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList = SerializableManager.readSerializable(getApplicationContext(), "students.txt");

        if(arrayList==null || arrayList.size()<=1)
        {
            arrayList = new ArrayList<Student>();
            Student student1 = new Student("Arif Hossain", "123456789");
            Student student2 = new Student("Sarah Khan", "987654211");
            Student student3 = new Student("Dalia Saif", "333444555");
            Student student4 = new Student("Sanam Saif", "333444555");
            Student student5 = new Student("Rakif Ahmed", "333444555");
            arrayList.add(student1);
            arrayList.add(student2);
            arrayList.add(student3);
            arrayList.add(student4);
            arrayList.add(student5);

            SerializableManager.saveSerializable(getApplicationContext(), arrayList, "students.txt");

        } else {

            ArrayList<Student> woi = SerializableManager.readSerializable(getApplicationContext(), "student.txt");
            arrayList.addAll(woi);
//            ArrayList<String> names = new ArrayList<String>();
//            ArrayList<String> nid = new ArrayList<String>();
//            for (Student a :
//                    arrayList) {
//                names.add(a.getStdname());
//                nid.add(a.getStdnid());
//
//            }
        }

        String sname = userInfo.getName();
        String snid = userInfo.getNID();
        Student student = new Student(sname,snid);
        arrayList.add(student);
        Student[] students = new Student[arrayList.size()];

        MyListAdapter adapter = new MyListAdapter(arrayList.toArray(students));
        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        //get Submitted NID and student name
        // put to recycler view


    }

}

