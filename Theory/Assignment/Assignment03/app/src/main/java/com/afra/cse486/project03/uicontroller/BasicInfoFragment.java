package com.afra.cse486.project03.uicontroller;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.afra.cse486.project03.R;
import com.afra.cse486.project03.UserInfo;
import com.afra.cse486.project03.databinding.FragmentBasicInfoBinding;

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
    private static Context mcontext;
    private String[] headers = new String[]{"Name", "Date of Birth", "NID", "Blood Group"};

    public BasicInfoFragment() {
        // Required empty public constructor
    }

    public static BasicInfoFragment newInstance(Context context) {
        BasicInfoFragment fragment = new BasicInfoFragment();
        mcontext = context;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        assert container != null;
        UserInfo userInfo = new UserInfo(getContext());

        FragmentBasicInfoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_basic_info, container, false);

        String[] userarr = new String[]{userInfo.getName(),userInfo.getDOB(),userInfo.getNID(), userInfo.getBloodGroup()};
       // Toast.makeText(mcontext, userarr[1], Toast.LENGTH_SHORT).show();

        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i=0;i<4;i++) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("desc", headers[i]);
            datum.put("txt", userarr[i]);
            data.add(datum);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), data,
                android.R.layout.simple_list_item_2,
                new String[] {"desc", "txt"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});
        View view = inflater.inflate(R.layout.fragment_basic_info, container, false);

        ListView listView = view.findViewById(R.id.display_list2);
        listView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return view;
    }
}