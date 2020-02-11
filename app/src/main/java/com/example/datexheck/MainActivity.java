package com.example.datexheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.datexheck.database.DatabaseHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(itemSelectedListener);

        HomeFragment homeFragment = new HomeFragment();





    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,homeFragment).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {


//switching activities from buttom navigation bar
                    switch (item.getItemId()){
                        case R.id.nav_list:
                            Intent intent = new Intent(MainActivity.this,ListActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            break;
                        case R.id.nav_home:
                            Intent intent1 = new Intent(MainActivity.this,MainActivity.class);
                            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent1);

                            break;
                        case R.id.nav_camera:
                            Intent intent3 = new Intent(MainActivity.this,ScannerActivity.class);
                            intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent3);
                            break;


                    }



                    return true;

                }
            };


}
