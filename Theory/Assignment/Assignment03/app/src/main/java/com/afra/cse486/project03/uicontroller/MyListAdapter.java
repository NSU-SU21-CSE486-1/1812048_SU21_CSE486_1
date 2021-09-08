package com.afra.cse486.project03.uicontroller;


import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.afra.cse486.project03.R;
import com.afra.cse486.project03.datasource.local.room.entity.Student;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
        private Student[] listdata;

        // RecyclerView recyclerView;
        public MyListAdapter(Student[] listdata) {
            this.listdata = listdata;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
            return new ViewHolder(listItem);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Student myListData = listdata[position];
            holder.name.setText(listdata[position].getStdname());
            holder.nid.setText(listdata[position].getStdnid());
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Toast.makeText(view.getContext(), "click on item: " + myListData.getStdnid(), Toast.LENGTH_LONG).show();
                    AlertDialog.Builder alertDialogBuilder =
                            new AlertDialog.Builder(view.getContext())
                                    .setTitle("Student Information")
                                    .setMessage("Name: "+myListData.getStdname()+"\nNID: "+myListData.getStdnid())
                                    .setPositiveButton("Close", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });

                    alertDialogBuilder.show();


                }
            });
        }


        @Override
        public int getItemCount() {
            return listdata.length;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView name;
            public TextView nid;
            public LinearLayout layout;
            public ViewHolder(View itemView) {
                super(itemView);
                this.name = (TextView) itemView.findViewById(R.id.list_tv);
                this.nid = (TextView) itemView.findViewById(R.id.user_info_text);
                layout = (LinearLayout)itemView.findViewById(R.id.listlinearlayout);
            }
        }


    }

