package com.example.cse486.uniclubz.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.ClubViewModel;
import com.example.cse486.uniclubz.databinding.ActivityCreateClubBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class CreateClub extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_club);

        ActivityCreateClubBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_create_club);



        ClubViewModel clubViewModel = new ViewModelProvider(this).get(ClubViewModel.class);
        binding.uniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cname, uname,cdesc;
                String uid = FirebaseAuth.getInstance().getUid();
                ArrayList<String> admin = new ArrayList<>();
                ArrayList<String> member = new ArrayList<>();
                admin.add(uid);
                admin.add(uid);
                cname = binding.cnameEdittextview.getText().toString().trim();
                cdesc = binding.cdesc.getText().toString().trim();
                if(binding.uninameDropdown.getSelectedItem()!=null)
                {
                    uname = binding.uninameDropdown.getSelectedItem().toString();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Choose a Uni",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(cname.length()<=0 || cdesc.length()<=0)
                {
                    Toast.makeText(getApplicationContext(),"Fill All Fields",Toast.LENGTH_SHORT).show();
                    return;
                }


                Club club = new Club(cname,uname,cdesc,admin,member);
                clubViewModel.createclub(club,uid);
                finish();
            }
        });
    }
}