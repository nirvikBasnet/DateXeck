package com.example.datexheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.datexheck.database.DataSource;
import com.example.datexheck.database.DatabaseHelper;
import com.example.datexheck.entities.DataItem;

import com.example.datexheck.recyclerview.DataItemAdapter;
import com.example.datexheck.sample.SampleDataProvider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class ListActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    TextView tvOut;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> itemNames = new ArrayList<>();

    FloatingActionButton addButton;

    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        addButton=findViewById(R.id.floatingActionButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddProductActivity.class);
                startActivity(intent);
            }
        });


        mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDatabase(dataItemList);

        Toast.makeText(this,"Database acquired!", Toast.LENGTH_SHORT).show();





//        Collections.sort(dataItemList, new Comparator<DataItem>() {
//            @Override
//            public int compare(DataItem o1, DataItem o2) {
//                return o1.getItemName().compareTo(o2.getItemName());
//            }
//        });

        List<DataItem> listFromDB = mDataSource.getAllItems();
        DataItemAdapter adapter = new DataItemAdapter(this, listFromDB);

        //binding

        RecyclerView recyclerView = findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
    }
}