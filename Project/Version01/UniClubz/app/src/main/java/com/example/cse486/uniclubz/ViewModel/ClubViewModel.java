package com.example.cse486.uniclubz.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.cse486.uniclubz.Model.Repository.ClubRepository;
import com.example.cse486.uniclubz.Model.entity.Club;

import java.util.ArrayList;

public class ClubViewModel extends AndroidViewModel {
    ClubRepository clubRepository;
    public ClubViewModel(@NonNull Application application) {
        super(application);
        clubRepository = new ClubRepository();
    }

    public ArrayList<Club> getsampleclubs()
    {
        return clubRepository.getSampleClubs();
    }

    public ArrayList<Club> getallclubs()
    {
        return clubRepository.getAllclubs();
    }

    public ArrayList<Club> getmyclubs(String uid)
    {
        return clubRepository.getMyClubs(uid);
    }

    public ArrayList<Club> getadminclubs(String uid)
    {
        return clubRepository.getAdminClubs(uid);
    }
}
