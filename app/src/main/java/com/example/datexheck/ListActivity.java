package com.example.datexheck;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.datexheck.database.DatabaseHelper;
import com.example.datexheck.entities.Product;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {


    DatabaseHelper userDBhelper;
    ListView productList;


    ArrayList<String> listItem;
    ArrayAdapter adapter;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        productList = findViewById(R.id.display_listview);

        userDBhelper= new DatabaseHelper(this);


        listItem = new ArrayList<>();


        viewData();
        
        
        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = productList.getItemAtPosition(position).toString();
                Toast.makeText(ListActivity.this, "You Selected "+text, Toast.LENGTH_SHORT).show();//showing message when pressing list
            }
        });



    }

    //method to show data in listview

    private void viewData() {
        Cursor cursor = userDBhelper.viewData();
        
        
        if (cursor.getCount()==0){

            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();

            
        }else{

            while(cursor.moveToNext()){

                listItem.add(cursor.getString(1));

            }

            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
            productList.setAdapter(adapter);


        }
        
        
    }


}