package com.example.project02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.example.project02.databinding.FragmentBasicInfoBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BasicInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BasicInfoFragment extends Fragment {
    private String[] headers = new String[]{"Name", "Date of Birth", "NID", "Blood Group"};

    public BasicInfoFragment() {
        // Required empty public constructor
    }

    public static BasicInfoFragment newInstance() {
        BasicInfoFragment fragment = new BasicInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        UserInfo userInfo = new UserInfo(getContext());
        FragmentBasicInfoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_basic_info, container, false);

        String[] userarr = new String[]{userInfo.getName(),userInfo.getDOB(),userInfo.getNID(), userInfo.getBloodGroup()};

        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i=0;i<4;i++) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("desc", headers[i]);
            datum.put("txt", userarr[i]);
            data.add(datum);
        }
        SimpleAdapter adapter = new SimpleAdapter(this.getContext(), data,
                android.R.layout.simple_list_item_2,
                new String[] {"desc", "txt"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});
        binding.displayList2.setAdapter(adapter);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_info, container, false);
    }
}