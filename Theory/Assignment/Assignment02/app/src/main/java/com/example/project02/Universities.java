package com.example.project02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Universities#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Universities extends Fragment {

    public Universities() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Universities newInstance(String param1, String param2) {
        Universities fragment = new Universities();
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
        return inflater.inflate(R.layout.fragment_universities, container, false);
    }
}