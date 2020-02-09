package com.example.datexheck.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.datexheck.entities.DataItem;


public class DatabaseHelper extends SQLiteOpenHelper{

     SQLiteDatabase db;

     ItemsTable items;

    public static final String DB_FILE_NAME = "items.db";
    public static final int DB_VERSION = 1;



    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemsTable.SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(ItemsTable.SQL_DELETE);
        onCreate(db);


    }

    public boolean insertData(String name,String expDate,Integer barcode){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(ItemsTable.COLUMN_NAME, name);
        values.put(ItemsTable.COLUMN_EXPDATE, expDate);
        values.put(ItemsTable.COLUMN_BARCODE, barcode);

        long result = db.insert(items.TABLE_ITEMS,null,values);
        if(result== -1){
            return false;
        }else
            return true;



    }


}
