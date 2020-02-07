package com.example.datexheck;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.datexheck.entities.Product;

import java.util.Calendar;

public class AddProductActivity extends AppCompatActivity {


    Product product = new Product();




    public static final String TAG = "AddProductActivity";
    public Button selectDate;
    public DatePickerDialog.OnDateSetListener dateSetListener;
    TextView showDate;
    String date;

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


        selectDate = findViewById(R.id.selectDateButton);
        showDate = findViewById(R.id.showDate);

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
}
