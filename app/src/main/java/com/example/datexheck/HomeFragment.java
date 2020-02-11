package com.example.datexheck;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    TextView maintainItems, addItems;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_home, container, false);


        addItems= view.findViewById(R.id.addItemTextView);


        maintainItems= view.findViewById(R.id.maintainMeTextView);

        addItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ScannerActivity.class);
                startActivity(intent);
            }
        });



        maintainItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MaintenanceActivity.class);
                startActivity(intent);
            }
        });










        return view;
    }

}
