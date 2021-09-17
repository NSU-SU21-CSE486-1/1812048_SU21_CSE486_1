package com.example.cse486.uniclubz.Model.Repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cse486.uniclubz.Model.DAO.ClubDao;
import com.example.cse486.uniclubz.Model.entity.Club;
import com.example.cse486.uniclubz.Model.entity.University;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.View.CreateClub;
import com.example.cse486.uniclubz.ViewModel.UserPref;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ClubRepository implements ClubDao {

    private String uid = "QFGmMdADhIMSYpb4BVwwt2zB8XG2";
    private static Set<Club> adminclubs = new HashSet<>();
    private static Set<Club> allclubs = new HashSet<>();
    private static Set<Club> myclubs = new HashSet<>();
    private DatabaseReference databaseReference;
    private Context context;

//  //  public ClubRepository(Context context)
//    {
//        this.context =context;
//    }

    @Override
    public void createClub(Club club,String uid) {
        databaseReference = FirebaseDatabase.getInstance().getReference();

        String clubid = databaseReference.push().getKey();
        assert clubid != null;
        databaseReference.child("clubs").child(clubid).setValue(club);
        databaseReference.child("admins").child(clubid).setValue(club.getAdmins());
        databaseReference.child("memberslist").child(clubid).setValue(club.getMembers());
        databaseReference.child("users").child(uid).child("clubs").push().setValue(clubid);
        databaseReference.child("users").child(uid).child("adminclubs").push().setValue(clubid);




    }

    @Override
    public void getAllclubs(University university) {

    }

    @Override
    public ArrayList<Club> getAllclubs() {

        final ArrayList<String>[] clubsid = new ArrayList[]{new ArrayList<>()};

        databaseReference = FirebaseDatabase.getInstance().getReference().child("clubs");

        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                allclubs.clear();
                for (DataSnapshot dsp : snapshot.getChildren()) {
                    allclubs.add(dsp.getValue(Club.class)); //add result into array list


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ArrayList<Club> clubs1 = new ArrayList<>();
        clubs1.addAll(allclubs);
        return clubs1;
    }

    @Override
    public ArrayList<Club> getMyClubs(String uid) {


        final ArrayList<String>[] clubsid = new ArrayList[]{new ArrayList<>()};
        ArrayList<Club>[] clubs =  new ArrayList[]{new ArrayList<>()};
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(uid).child("clubs");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myclubs.clear();
                GenericTypeIndicator<ArrayList<String>> t = new GenericTypeIndicator<ArrayList<String>>() {};
                ArrayList<String> clubss = new ArrayList<>();
                // clubss = (ArrayList<String>) snapshot.getValue();
                for (DataSnapshot dsp : snapshot.getChildren()) {
                    clubss.add(String.valueOf(dsp.getValue())); //add result into array list

                }
                clubsid[0] = clubss;

                Log.d("hello", clubsid[0].get(0));

                for (String s: clubsid[0]
                ) {
                    Log.d("hello","heree");

                    databaseReference = FirebaseDatabase.getInstance().getReference().child("clubs").child(s);

                    databaseReference.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Log.d("hello","hereetoo");
                            GenericTypeIndicator<Club> t = new GenericTypeIndicator<Club>() {};
                            Club clubss;
                            clubss = (Club) snapshot.getValue(Club.class);
                            myclubs.add(clubss);
                            //  Log.d("adnm",adminclubs.get(0).getUni());
                            // Log.d("hello",clubss.getCdesc());

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ArrayList<Club> clubs1 = new ArrayList<>();
        clubs1.addAll(myclubs);
       // UserPref userPref = new UserPref(context);
        return clubs1;
    }

    @Override
    public ArrayList<Club> getAdminClubs(String uid) {


        final ArrayList<String>[] clubsid = new ArrayList[]{new ArrayList<>()};
        ArrayList<Club>[] clubs =  new ArrayList[]{new ArrayList<>()};
        databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(uid).child("adminclubs");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<ArrayList<String>> t = new GenericTypeIndicator<ArrayList<String>>() {};
                ArrayList<String> clubss = new ArrayList<>();
               // clubss = (ArrayList<String>) snapshot.getValue();
                for (DataSnapshot dsp : snapshot.getChildren()) {
                    clubss.add(String.valueOf(dsp.getValue())); //add result into array list

                }
                clubsid[0] = clubss;
                Log.d("hello", clubsid[0].get(0));
//                UserPref userPref = new UserPref(context);
//                userPref.setadmin(new HashSet<>(clubsid[0]));
                adminclubs.clear();
                for (String s: clubsid[0]
                ) {
                    Log.d("hello","heree");

                    databaseReference = FirebaseDatabase.getInstance().getReference().child("clubs").child(s);
                    databaseReference.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Log.d("hello","hereetoo");
                            GenericTypeIndicator<Club> t = new GenericTypeIndicator<Club>() {};
                            Club clubss;
                            clubss = (Club) snapshot.getValue(Club.class);
                           adminclubs.add(clubss);
                         //  Log.d("adnm",adminclubs.get(0).getUni());
                           // Log.d("hello",clubss.getCdesc());

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ArrayList<Club> clubs1 = new ArrayList<>();
        clubs1.addAll(adminclubs);
        return clubs1;



    }

   public ArrayList<Club> getSampleClubs(){
        ArrayList<Club> clubs = new ArrayList<>();
        String[] admins1 = {uid};
        String[] admins2 = {"12431241421"};
       ArrayList<String> adm = new ArrayList<>();
       ArrayList<String> mem = new ArrayList<>();
        adm.add(admins1[0]);
        mem.add(admins2[0]);
       String desc ="Welcome to our club";
        Club club = new Club("NSU YES!","NSU",desc,adm,mem);
       Club club1 = new Club("BRAC Debate Club","BRAC",desc,adm,mem);
       Club club2= new Club("NSU ACM-W","NSU",desc,adm,mem);
       Club club3 = new Club("BRAC CSE Club","BRAC",desc,adm,mem);
       Club club4 = new Club("NSUSS","NSU",desc,adm,mem);
       clubs.add(club);
       clubs.add(club1);
       clubs.add(club2);
       clubs.add(club3);
       clubs.add(club4);

        return clubs;
    }


}
