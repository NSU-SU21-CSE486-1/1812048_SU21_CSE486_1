package com.afra.cse486.project03.uicontroller;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.afra.cse486.project03.R;
import com.afra.cse486.project03.UserInfo;
import com.afra.cse486.project03.databinding.FragmentPhonesBinding;
import com.afra.cse486.project03.datasource.local.room.entity.Phone;
import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.viewmodel.PhoneViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhonesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhonesFragment extends Fragment {
    ArrayList<Phone> woi=new ArrayList<>();
    View view;
    ListView listView;
    private PhoneViewModel phoneViewModel;


    public PhonesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PhonesFragment newInstance(String param1, String param2) {
        PhonesFragment fragment = new PhonesFragment();
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
        phoneViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication())).get(PhoneViewModel.class);

        FragmentPhonesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_phones, container, false);
        view = inflater.inflate(R.layout.fragment_phones, container, false);
        listView = view.findViewById(R.id.display_list2);

        List<Phone> phones = phoneViewModel.getAllPhone();

        if(phones!=null) woi.addAll(phones);



        if(woi == null || woi.size()<=1)
        {
            woi = new ArrayList<Phone>();
            Phone phone1 = new Phone("Home","123456789");
            Phone phone2 = new Phone("Office","987654211");
            Phone phone3 = new Phone("Work","333444555");

            woi.add(phone1);
            woi.add(phone2);
            woi.add(phone3);

            phoneViewModel.insertAll(phone1,phone2,phone3);



        }

        setuplistview(woi);


        view.findViewById(R.id.addphonebtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),AddPhoneEmail.class);
                    startActivityForResult(intent,1);

                }
            });

            return view;

        }

        public void setuplistview(ArrayList<Phone> woi)
        {
            ArrayList<String> names = new ArrayList<String>();
            ArrayList<String> nid = new ArrayList<String>();
            for (Phone a:
                    woi) {
                names.add(a.getTag());
                nid.add(a.getNumber());

            }
            String[] tagsarr = new String[woi.size()];
            names.toArray(tagsarr);
            String[] numarr = new String[woi.size()];
            nid.toArray(numarr);
            List<Map<String, String>> data = new ArrayList<Map<String, String>>();
            for (int i=0;i<woi.size();i++) {
                Map<String, String> datum = new HashMap<String, String>(2);
                datum.put("desc", tagsarr[i]);
                datum.put("txt", numarr[i]);
                data.add(datum);
            }
            SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), data,
                    android.R.layout.simple_list_item_2,
                    new String[] {"desc", "txt"},
                    new int[] {android.R.id.text1,
                            android.R.id.text2});

            listView.setAdapter(adapter);

        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(data!=null && resultCode== RESULT_OK) {
                Phone phone = new Phone(data.getStringExtra("tag"), data.getStringExtra("phone"));

                DBListenerInterface ref = new DBListenerInterface() {
                    @Override
                    public void passed() {
//                        Toast.makeText(view.getContext(),
//                                "Phones saved.",
//                                Toast.LENGTH_LONG).show();
                        Log.d("elomelo","saved");
                    }

                    @Override
                    public void failed() {
//                        Toast.makeText(view.getContext(),
//                                "Phones did not get saved.",
//                                Toast.LENGTH_LONG).show();
                        Log.d("elomelo","not saved");
                    }
                };
                phoneViewModel.insert1(phone,ref);
                woi.add(phone);
                setuplistview(woi);
            }

          // Toast.makeText(getActivity().getBaseContext(), phone.getNumber(), Toast.LENGTH_SHORT).show();
        }
    }



}
