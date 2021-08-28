package com.example.cse486.staticfragmentlifecycle;


import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.app.Fragment;

import androidx.annotation.Nullable;

public class DisplayFragment extends Fragment {
    TextView text;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.display_fragment, container, false);
        text= (TextView) view.findViewById(R.id.count);



        return view;

    }
    public void change(String txt){
        text.setText(txt);


    }

    @Override
    public void onInflate(AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(attrs, savedInstanceState);
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }




    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onStart() {
        super.onStart();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onResume() {
        super.onResume();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onPause() {
        super.onPause();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onStop() {
        super.onStop();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        String str = new Object(){}.getClass().getEnclosingMethod().getName();
        Log.d("lc",getClass().getName()+" "+str);
    }
}