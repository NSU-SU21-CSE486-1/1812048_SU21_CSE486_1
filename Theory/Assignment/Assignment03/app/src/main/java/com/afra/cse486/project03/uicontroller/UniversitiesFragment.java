package com.afra.cse486.project03.uicontroller;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.afra.cse486.project03.R;
import com.afra.cse486.project03.datasource.local.room.entity.UniAffiliation;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UniversitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UniversitiesFragment extends Fragment {

    ArrayList<UniAffiliation> uniAffiliations = new ArrayList<>();
    View view;
    ListView listView;


    public UniversitiesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static UniversitiesFragment newInstance(String param1, String param2) {
        UniversitiesFragment fragment = new UniversitiesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_universities, container, false);

        listView = view.findViewById(R.id.list_view);



        uniAffiliations = SerializableManager.readSerializable(getContext(), "unis.txt");

        if(uniAffiliations==null || uniAffiliations.size()<=1)
        {
            uniAffiliations = new ArrayList<UniAffiliation>();
            uniAffiliations.add(new UniAffiliation("NSU","123456789","CSE","BS","afra@nsu.edu"));
            uniAffiliations.add(new UniAffiliation("BRAC","34567898","EEE","MS","afra@brac.edu"));
            uniAffiliations.add(new UniAffiliation("NSU","178239200","Law","PHD","afra05@nsu.edu"));



        }
        else {

            uniAffiliations = SerializableManager.readSerializable(getContext(), "unis.txt");
        }

        setlistview();

        view.findViewById(R.id.add_uni_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),UniversityAffiliation.class);
                startActivityForResult(intent,1);

            }
        });

        return view;
    }

    public void setlistview()
    {
        UniArrayAdapter adapter = new UniArrayAdapter(getActivity().getBaseContext(),R.layout.fragment_universities,uniAffiliations);
        adapter.addAll(uniAffiliations);
        listView.setAdapter(adapter);
        SerializableManager.saveSerializable(getContext(),uniAffiliations,"unis.txt");

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(data!=null && resultCode!=RESULT_OK) {
                UniAffiliation phone = new UniAffiliation(data.getStringExtra("name"), data.getStringExtra("sid"), data.getStringExtra("dept"), data.getStringExtra("lvl"), data.getStringExtra("email"));
                uniAffiliations.add(phone);
                setlistview();
            }

            // Toast.makeText(getActivity().getBaseContext(), phone.getNumber(), Toast.LENGTH_SHORT).show();
        }
    }

}