package com.example.project02;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.example.project02.databinding.FragmentBasicInfoBinding;
import com.example.project02.databinding.FragmentPhonesBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Phones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Phones extends Fragment {


    public Phones() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Phones newInstance(String param1, String param2) {
        Phones fragment = new Phones();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UserInfo userInfo = new UserInfo(getContext());
        FragmentPhonesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_phones, container, false);

        Boolean first = userInfo.getfirst();
        if(first)
        {
            Student student1 = new Student("Arif Hossain","123456789");
            Student student2 = new Student("Sarah Khan","987654211");
            Student student3 = new Student("Dalia Saif","333444555");
            Student student4 = new Student("Sanam Saif","333444555");
            Student student5 = new Student("Rakif Ahmed","333444555");
            ArrayList<Student> woi=new ArrayList<>();
            woi.add(student1);
            woi.add(student2);
            woi.add(student3);
            woi.add(student4);
            woi.add(student5);

            SerializableManager.saveSerializable(getContext(),woi,"students.txt");

        }
        else {

           ArrayList<Student> arrayList = SerializableManager.readSerializable(getContext(),"student.txt");
            ArrayList<String> names = new ArrayList<String>();
            ArrayList<String> nid = new ArrayList<String>();
            for (Student a:
                 arrayList) {
                names.add(a.getStdname());
                nid.add(a.getStdnid());

            }
            String[] namesarr = new String[arrayList.size()];
            names.toArray(namesarr);
            String[] nidarr = new String[arrayList.size()];
            nid.toArray(nidarr);
            List<Map<String, String>> data = new ArrayList<Map<String, String>>();
            for (int i=0;i<8;i++) {
                Map<String, String> datum = new HashMap<String, String>(2);
                datum.put("desc", namesarr[i]);
                datum.put("txt", nidarr[i]);
                data.add(datum);
            }
            SimpleAdapter adapter = new SimpleAdapter(getContext(), data,
                    android.R.layout.simple_list_item_2,
                    new String[] {"desc", "txt"},
                    new int[] {android.R.id.text1,
                            android.R.id.text2});
            binding.displayList2.setAdapter(adapter);

            binding.addphonebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),AddPhoneEmail.class);
                    startActivity(intent);
                }
            });

        }
        return inflater.inflate(R.layout.fragment_phones, container, false);
    }
}