package com.example.datexheck;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.datexheck.database.DatabaseHelper;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class AddProductActivity extends AppCompatActivity {







    public static final String TAG = "AddProductActivity";
    EditText productName;
    EditText productBarcode;
    TextView expDate;
    public Button selectDate;
    public DatePickerDialog.OnDateSetListener dateSetListener;
    TextView showDate;
    String date;

    Button addButton;
    Button cancelButton;

    DatabaseHelper dbHelper;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        dbHelper = new DatabaseHelper(this);


        selectDate = findViewById(R.id.selectDateButton);
        showDate = findViewById(R.id.showDate);
        productName = findViewById(R.id.productNameEditText);
        productBarcode=findViewById(R.id.barcodeEditText);
        expDate=findViewById(R.id.showDate);
        addButton = findViewById(R.id.addProductButton);
        cancelButton=findViewById(R.id.cancelButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             dbHelper.insertData(productName.getText().toString(),expDate.getText().toString(),Integer.valueOf(productBarcode.getText().toString()));



            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel(v);
            }
        });

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog= new DatePickerDialog
                        (AddProductActivity.this,
                                android.R.style.Widget_Holo_Light,
                                dateSetListener,year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                 date = month + "/" + day + "/" + year;

                showDate.setText(date);

            }
        };
    }



    private void cancel(View v){
        finish();
    }

}
