package com.example.datexheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity {

    ProgressBar progressBar; //progressbar for signup


    EditText emailText,passwordText;
    Button signupButton,loginButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        emailText = findViewById(R.id.editTextEmailSignUp);
        passwordText = findViewById(R.id.editTextPasswordSignUp);
        progressBar= findViewById(R.id.progressBar);

        signupButton= findViewById(R.id.signUpButtonSignUp);
        loginButton= findViewById(R.id.loginButtonSignUp);

        mAuth = FirebaseAuth.getInstance();//instance of firebase


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });


    }


    //register user with firebase


    private void registerUser(){

        String email = emailText.getText().toString().trim();
        final String password = passwordText.getText().toString().trim();
        //validating datafields
        if(email.isEmpty()){
            emailText.setError("Email is required");
            emailText.requestFocus();
            return;

        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailText.setError("Please enter a valid email");
            emailText.requestFocus();
            return;
        }

        if(password.isEmpty()){
            passwordText.setError("Password is required");
            passwordText.requestFocus();
            return;
        }

        if(password.length()<6){
            passwordText.setError("Mimimum length of password should be 6");
        }

        progressBar.setVisibility(View.VISIBLE);//setting progressbar to visible until the action is sucessful
        
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                
                if(task.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


                    progressBar.setVisibility(View.INVISIBLE);//setting progressbar invisible


                    Toast.makeText(SignUpActivity.this, "Your Account Created!!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);


                } else{
                    
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){

                        Toast.makeText(SignUpActivity.this, "User Already Registered!", Toast.LENGTH_SHORT).show();
                    }else{

                        Toast.makeText(SignUpActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                
            }
        });


    }
}
