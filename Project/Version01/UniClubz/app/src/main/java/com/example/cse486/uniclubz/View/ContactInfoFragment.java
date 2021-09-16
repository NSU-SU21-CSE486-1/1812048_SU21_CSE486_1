package com.example.cse486.uniclubz.View;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.cse486.uniclubz.Model.entity.Contact;
import com.example.cse486.uniclubz.R;
import com.example.cse486.uniclubz.ViewModel.SerializableManager;
import com.example.cse486.uniclubz.ViewModel.UserPref;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ContactInfoFragment extends Fragment {
    ArrayList<Contact> woi=new ArrayList<>();
    View view;
    ListView listView;


    public ContactInfoFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ContactInfoFragment newInstance(String param1, String param2) {
        ContactInfoFragment fragment = new ContactInfoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UserPref userInfo = new UserPref(getContext());
      //  FragmentPhonesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_phones, container, false);
        view = inflater.inflate(R.layout.fragment_contact_info, container, false);
        listView = view.findViewById(R.id.display_list2);



        woi = SerializableManager.readSerializable(getContext(), "phones.txt");

        if(woi == null || woi.size()<=1)
        {
            woi = new ArrayList<Contact>();
            Contact phone1 = new Contact("Phone","123456789","Home");
            Contact phone2 = new Contact("Phone","987654211","Office");
            Contact phone3 = new Contact("Phone","333444555","Work");

            woi.add(phone1);
            woi.add(phone2);
            woi.add(phone3);


        //    SerializableManager.saveSerializable(getContext(),woi,"phones.txt");

        }

        setuplistview(woi);


        view.findViewById(R.id.addphonebtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),AddContactActivity.class);
                    startActivityForResult(intent,1);

                }
            });

            return view;

        }

        public void setuplistview(ArrayList<Contact> woi)
        {
            ArrayList<String> names = new ArrayList<String>();
            ArrayList<String> nid = new ArrayList<String>();
            for (Contact a:
                    woi) {
                names.add(a.getTag());
                nid.add(a.getContact());

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
         //  SerializableManager.removeSerializable(getActivity().getBaseContext(),"phones.txt");
            SerializableManager.saveSerializable(getActivity().getBaseContext(),woi,"phones.txt");
        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(data!=null && resultCode!= RESULT_OK) {
                Contact phone = new Contact(data.getStringExtra("type"), data.getStringExtra("phone"),data.getStringExtra("tag"));
                woi.add(phone);
                setuplistview(woi);
            }

          // Toast.makeText(getActivity().getBaseContext(), phone.getNumber(), Toast.LENGTH_SHORT).show();
        }
    }



}
