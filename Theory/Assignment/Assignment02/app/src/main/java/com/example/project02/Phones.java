package com.example.project02;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02.databinding.FragmentBasicInfoBinding;
import com.example.project02.databinding.FragmentPhonesBinding;

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
        return inflater.inflate(R.layout.fragment_phones, container, false);
    }
}