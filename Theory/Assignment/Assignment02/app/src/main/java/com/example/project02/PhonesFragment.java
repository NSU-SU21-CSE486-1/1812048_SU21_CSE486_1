package com.example.project02;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.example.project02.databinding.FragmentPhonesBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhonesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhonesFragment extends Fragment {


    public PhonesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PhonesFragment newInstance(String param1, String param2) {
        PhonesFragment fragment = new PhonesFragment();
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
            Phone phone1 = new Phone("Home","123456789");
            Phone phone2 = new Phone("Office","987654211");
            Phone phone3 = new Phone("Work","333444555");
            ArrayList<Phone> woi=new ArrayList<>();
            woi.add(phone1);
            woi.add(phone2);
            woi.add(phone3);


            SerializableManager.saveSerializable(getContext(),woi,"phones.txt");

        }
        else {

           ArrayList<Phone> arrayList = SerializableManager.readSerializable(getContext(),"phones.txt");
           ArrayList<String> names = new ArrayList<String>();
           ArrayList<String> nid = new ArrayList<String>();
            for (Phone a:
                 arrayList) {
                names.add(a.getTag());
                nid.add(a.getNumber());

            }
            String[] tagsarr = new String[arrayList.size()];
            names.toArray(tagsarr);
            String[] numarr = new String[arrayList.size()];
            nid.toArray(numarr);
            List<Map<String, String>> data = new ArrayList<Map<String, String>>();
            for (int i=0;i<8;i++) {
                Map<String, String> datum = new HashMap<String, String>(2);
                datum.put("desc", tagsarr[i]);
                datum.put("txt", numarr[i]);
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