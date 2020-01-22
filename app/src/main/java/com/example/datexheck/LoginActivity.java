package com.example.datexheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datexheck.R;

public class LoginActivity extends AppCompatActivity {

    Button loginButton ;
    EditText nameText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.logInButton);
        nameText = findViewById(R.id.nameEditText);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                welcomeUser();
                openMainActivity();
            }
        });



    }

    private void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void welcomeUser() {
        String welcome = "Welcome" + " " + nameText.getText().toString();

        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }


}
