package com.afra.cse486.project03.uicontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.afra.cse486.project03.R;
import com.afra.cse486.project03.UserInfo;
import com.afra.cse486.project03.databinding.ActivityMemberInfoBinding;
import com.afra.cse486.project03.datasource.local.room.entity.Phone;
import com.afra.cse486.project03.datasource.local.room.entity.Student;
import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.viewmodel.PhoneViewModel;
import com.afra.cse486.project03.viewmodel.StudentInfoViewModel;

import java.util.ArrayList;
import java.util.List;

public class MemberInfoActivity extends AppCompatActivity {

    private StudentInfoViewModel studentInfoViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);

        UserInfo userInfo = new UserInfo(getApplicationContext());
        ActivityMemberInfoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_member_info);
        ArrayList<StudentInfo> arrayList = new ArrayList<>();
        studentInfoViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentInfoViewModel.class);
    //    arrayList = SerializableManager.readSerializable(getApplicationContext(), "students.txt");


        List<StudentInfo> studentInfos = studentInfoViewModel.getAllStudents().getValue();
        if(studentInfos!=null) arrayList.addAll(studentInfos);

        if(arrayList==null || arrayList.size()<=1)
        {
            arrayList = new ArrayList<StudentInfo>();
            StudentInfo student1 = new StudentInfo("Arif Hossain", "123456789");
            StudentInfo student2 = new StudentInfo("Sarah Khan", "987654211");
            StudentInfo student3 = new StudentInfo("Dalia Saif", "333444555");
            StudentInfo student4 = new StudentInfo("Sanam Saif", "333444555");
            StudentInfo student5 = new StudentInfo("Rakif Ahmed", "333444555");
            arrayList.add(student1);
            arrayList.add(student2);
            arrayList.add(student3);
            arrayList.add(student4);
            arrayList.add(student5);

            studentInfoViewModel.insertAll(student1,student2,student3,student4,student5);
         //  SerializableManager.saveSerializable(getApplicationContext(), arrayList, "students.txt");

        }
//        else {
//
//            ArrayList<Student> woi = SerializableManager.readSerializable(getApplicationContext(), "students.txt");
//            arrayList.addAll(woi);
////            ArrayList<String> names = new ArrayList<String>();
////            ArrayList<String> nid = new ArrayList<String>();
////            for (Student a :
////                    arrayList) {
////                names.add(a.getStdname());
////                nid.add(a.getStdnid());
////
////            }
//        }

        String sname = userInfo.getName();
        String snid = userInfo.getNID();
        StudentInfo student = new StudentInfo(sname,snid);
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

