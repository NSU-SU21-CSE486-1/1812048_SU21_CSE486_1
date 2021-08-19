package com.example.project02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UniversitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UniversitiesFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_universities, container, false);

        ListView listView = view.findViewById(R.id.list_view);
        ArrayList<UniAffiliation> uniAffiliations = new ArrayList<>();

        UserInfo userInfo = new UserInfo(getContext());
        Boolean first = userInfo.getfirst();

        if(first)
        {

            uniAffiliations.add(new UniAffiliation("NSU","123456789","CSE","BS"));
            uniAffiliations.add(new UniAffiliation("BRAC","34567898","EEE","MS"));
            uniAffiliations.add(new UniAffiliation("NSU","178239200","Law","PHD"));

            SerializableManager.saveSerializable(getContext(),uniAffiliations,"unis.txt");

        }
        else {

            uniAffiliations = SerializableManager.readSerializable(getContext(), "unis.txt");
        }

        UniArrayAdapter adapter = new UniArrayAdapter(getActivity().getBaseContext(),R.layout.fragment_universities,uniAffiliations);
        adapter.addAll(uniAffiliations);
        listView.setAdapter(adapter);

        return view;
    }
}