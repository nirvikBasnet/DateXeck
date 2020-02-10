package com.example.datexheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;



import com.example.datexheck.database.DatabaseHelper;


import com.example.datexheck.entities.Product;

import com.example.datexheck.recyclerview.DataItemAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;



public class ListActivity extends AppCompatActivity {


    FloatingActionButton addButton;
    RecyclerView recyclerView;
    ArrayList<Product> objProductClass;
    String expDate,productName;
    Integer id,barcode;
    DatabaseHelper myDb;
    Cursor c;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);





        objProductClass = new ArrayList<>();












        addButton=findViewById(R.id.floatingActionButton);
        recyclerView = findViewById(R.id.rvItems);
        objProductClass = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((ListActivity.this));
        recyclerView.setLayoutManager(layoutManager);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddProductActivity.class);
                startActivity(intent);
            }
        });


        myDb = new DatabaseHelper(this);

        c=myDb.getAllData();

        if (c.getCount()>0){
            if (c.moveToNext()){
                do{

                    id=c.getInt(0);
                    productName=c.getString(1);
                    expDate=c.getString(2);
                    barcode=c.getInt(3);

                    Product pr= new Product(id,productName,expDate,barcode);
                    objProductClass.add(pr);


                }while(c.moveToNext());
            }
        }

        DataItemAdapter my = new DataItemAdapter(this,objProductClass);
        recyclerView.setAdapter(my);



    }



}