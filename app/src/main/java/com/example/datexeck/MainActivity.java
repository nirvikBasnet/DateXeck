package com.example.datexeck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView totalItems;
    Button listButton;
    Button notificationButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listButton= (Button) findViewById(R.id.listButton);
        notificationButton=findViewById(R.id.notificationButton);

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListActivity();
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNotificationActivity();
            }
        });



    }

    private void openNotificationActivity() {
        Intent intent = new Intent(this,NotificationActivity.class);
        startActivity(intent);
    }

    private void openListActivity() {
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }




}
