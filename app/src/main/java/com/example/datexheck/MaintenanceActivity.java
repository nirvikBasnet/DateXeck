package com.example.datexheck;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datexheck.database.DatabaseHelper;

public class MaintenanceActivity extends AppCompatActivity {

    Button btnViewAll;
    Button btnUpdate;
    Button btnDelete;
    Button btnGoToInsert;

    DatabaseHelper myDb;

    EditText nameMaintain,expDateMaintain,barcodeMaintain,idMaintain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);

        myDb = new DatabaseHelper(this);

        nameMaintain=findViewById(R.id.maintainNameET);
        expDateMaintain=findViewById(R.id.expiryDateMaintainanceET);
        barcodeMaintain= findViewById(R.id.barcodeMaintainance);
        idMaintain=findViewById(R.id.idMaintainance);

        btnUpdate= findViewById(R.id.updateBtn);
        btnDelete= findViewById(R.id.btnDelete);
        btnGoToInsert= findViewById(R.id.btnGoToAddList);


        //going to scanner Activity
        btnGoToInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ScannerActivity.class);
                startActivity(intent);
            }
        });




        btnViewAll = findViewById(R.id.showDataButton);
        viewAll(); //viewing all data in buffer
        UpdateData(); //updating data
        DeleteData(); //deleting data




    }

    //method for viewing all data
    public void viewAll(){
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();

                if(res.getCount()==0){
                    // show message

                    showMessage("Error", "Nothing Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (res.moveToNext()){

                    buffer.append("Id: " + res.getString(0)+'\n');
                    buffer.append("Name: " + res.getString(1)+'\n');
                    buffer.append("Expiry Date: " + res.getString(2)+'\n');
                    buffer.append("Barcode: " + res.getString(3)+'\n');
                    buffer.append("\n");


                }


                //show data
                showMessage("Products",buffer.toString());



            }
        });
    }
        //class for buffer
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);

        builder.setMessage(Message);

        builder.show();
    }
//data update method to update data in database
    public void UpdateData(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = myDb.updateData(idMaintain.getText().toString(),nameMaintain.getText().toString(),
                        expDateMaintain.getText().toString(),barcodeMaintain.getText().toString());

                if(isUpdated== true){
                    Toast.makeText(MaintenanceActivity.this, "Data Updated!", Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(MaintenanceActivity.this, "Data not Updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void DeleteData(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(idMaintain.getText().toString());
                if(deletedRows > 0){
                    Toast.makeText(MaintenanceActivity.this, "Data Sucessfully Deleted!", Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(MaintenanceActivity.this, "Data Not Updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
