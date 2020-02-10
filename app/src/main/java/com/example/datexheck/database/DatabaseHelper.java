package com.example.datexheck.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.datexheck.entities.Product;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper{

     SQLiteDatabase db;

    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "itemsId";
    public static final String COLUMN_NAME = "itemsName";
    public static final String COLUMN_EXPDATE= "itemsExpDate";
    public static final String COLUMN_BARCODE = "itemsBarcode";


    public static final String DB_FILE_NAME = "items.db";
    public static final int DB_VERSION = 1;


    public static final String[] ALL_COLUMNS = {COLUMN_ID,COLUMN_ID,COLUMN_NAME,COLUMN_EXPDATE,COLUMN_BARCODE};

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_ITEMS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT," + COLUMN_EXPDATE + " TEXT," +
            COLUMN_BARCODE + " INTEGER"  + ");";

    public static final String SQL_DELETE = "DROP TABLE " + TABLE_ITEMS;



    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE);
        onCreate(db);


    }

    public boolean insertData(String name,String expDate,Integer barcode){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EXPDATE, expDate);
        values.put(COLUMN_BARCODE, barcode);

        long result = db.insert(TABLE_ITEMS,null,values);
        if(result== -1){
            return false;
        }else
            return true;



    }

    public Cursor getAllData(){
        db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from " + TABLE_ITEMS ,null);

        return res;

    }




}
