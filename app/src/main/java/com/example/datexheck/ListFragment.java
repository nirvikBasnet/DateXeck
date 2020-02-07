package com.example.datexheck;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;




/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    Button toListButton;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);


        toListButton = view.findViewById(R.id.toListButton);


        toListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }

}
