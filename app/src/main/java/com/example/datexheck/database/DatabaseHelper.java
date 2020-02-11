package com.example.datexheck.database;


import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;




public class DatabaseHelper extends SQLiteOpenHelper{


    //creating instance of SQLiteDatabse
     SQLiteDatabase db;


     //naming column and table names

    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "itemsId";
    public static final String COLUMN_NAME = "itemsName";
    public static final String COLUMN_EXPDATE= "itemsExpDate";
    public static final String COLUMN_BARCODE = "itemsBarcode";

 //setting database name
    public static final String DB_FILE_NAME = "items.db";
    public static final int DB_VERSION = 1; //setting database version


    public static final String[] ALL_COLUMNS = {COLUMN_ID,COLUMN_ID,COLUMN_NAME,COLUMN_EXPDATE,COLUMN_BARCODE};


    //sql statement to call create method

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_ITEMS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT," + COLUMN_EXPDATE + " TEXT," +
            COLUMN_BARCODE + " LONG"  + ");";

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

        db.execSQL(SQL_DELETE); //calling delete statement
        onCreate(db);


    }

    //insert Data to the databse

    public boolean insertData(String name,String expDate,Long barcode){

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
    //getting all data to show in list view
    public Cursor getAllData(){
        db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+ TABLE_ITEMS ,null);

        return res;

    }
    //updating data in database
    public Boolean updateData(String id, String name, String expDate, String barcode){

        SQLiteDatabase db = this.getWritableDatabase(); //getting writableDatabase
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID,id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EXPDATE, expDate);
        values.put(COLUMN_BARCODE, barcode);

        db.update(TABLE_ITEMS, values, "itemsId = ?", new String[]{id} );// updating data with id


        return true;
    }
  //deleting data in database
    public Integer deleteData(String id){

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_ITEMS,"itemsId = ?",new String[]{id}); // deleting database with id


    }

    public Cursor viewData(){

        SQLiteDatabase db = this.getReadableDatabase();
        String query= "Select * From "+ TABLE_ITEMS;
        Cursor cursor =db.rawQuery(query,null);
        return cursor;

    }




}
