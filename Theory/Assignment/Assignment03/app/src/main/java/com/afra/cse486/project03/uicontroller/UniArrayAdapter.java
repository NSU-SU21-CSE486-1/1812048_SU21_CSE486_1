package com.afra.cse486.project03.uicontroller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.afra.cse486.project03.R;
import com.afra.cse486.project03.datasource.local.room.entity.UniAffiliation;

import java.util.ArrayList;

public class UniArrayAdapter extends ArrayAdapter<UniAffiliation> {

    ArrayList<UniAffiliation> uniAffiliations;
    Context mcontext;

    public UniArrayAdapter(@NonNull Context context, int resource, ArrayList<UniAffiliation> objects) {
        super(context, resource);
         mcontext= context;
         uniAffiliations =  objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.unicard, parent, false);

        TextView uname = (TextView) rowView.findViewById(R.id.uniname);
        TextView udept = (TextView) rowView.findViewById(R.id.dept);
        TextView sid = (TextView) rowView.findViewById(R.id.sid);
        TextView study = (TextView) rowView.findViewById(R.id.study);
        TextView email = (TextView) rowView.findViewById(R.id.email);


        uname.setText("Uni: "+uniAffiliations.get(position).getUniname());
        udept.setText("Department: "+uniAffiliations.get(position).getDept());
        sid.setText("ID: "+uniAffiliations.get(position).getSid());
        study.setText("Study Level: "+uniAffiliations.get(position).getLevel());
        email.setText("Email: "+uniAffiliations.get(position).getUniemail());

        return rowView;
    }



}
