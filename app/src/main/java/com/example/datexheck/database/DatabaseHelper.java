package com.example.datexheck.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getName();

    private static DatabaseHelper mInstance = null;

   //creating database constants
   private static final String DATABASE_NAME = "product.db";
    private static final Integer DATABASE_VERSION = 3;
    private static final String TABLE_NAME = "products";

    //create constants for the table's column name
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_EXPDATE = "EXPIRY";
    private static final String COL_BARCODE = "BARCODE";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
