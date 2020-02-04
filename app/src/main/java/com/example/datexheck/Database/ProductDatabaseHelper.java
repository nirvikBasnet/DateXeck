package com.example.datexheck.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.example.datexheck.Entities.Products;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class ProductDatabaseHelper extends SQLiteOpenHelper {

    //create database constants
    private static final String DATABASE_NAME = "product.db";
    private static final Integer DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "products";

    //create constants for the table's column name
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_EXPDATE = "ExpDate";
    private static final String COL_BARCODE = "BARCODE";

    //create sql statements
    private static final String CREATE_TABLE_ST = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT, " +
            COL_EXPDATE+ " TEXT, " +
            COL_BARCODE + " INTEGER)" ;

    private static final String DROP_TABLE_ST = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String GET_ALL_ST = "SELECT * FROM " + TABLE_NAME;



    /**
     * create the database every time this constructor gets called.
     *
     * @param context provides access to the Activity resources
     */
    public ProductDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //this method gets executed every time getWritableDatabase or getReadableDatabase is called.
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE_ST);
        onCreate(sqLiteDatabase);
    }

    public boolean insert(String name, String expdate, Integer barcode) {
        //create an instance of SQLITE database
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_EXPDATE, expdate);
        contentValues.put(COL_BARCODE, barcode);
        //we store the image name, after using
        //long resId = parent.getResources().getIdentifier(arrayOfStrings[position], "drawable", mApplicationContext.getPackageName());
        //you get the Id of the image as drawable, so you can use it in an image view
        //                int resId = getResources().getIdentifier("bomb", "drawable", this.getPackageName());
        //                imageView.setImageResource(resId);


        long result = db.insert(TABLE_NAME, null, contentValues);
        //if result -1  insert was not performed, otherwise will have the row ID of the newly inserted row
        return result != -1;
    }

    public Cursor getAll() {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery(GET_ALL_ST, null);
    }

    public boolean update(Integer id, String name, String expdate, Integer barcode) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, id);
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_EXPDATE, expdate);
        contentValues.put(COL_BARCODE, barcode);

        int numRowsUpdated = db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id.toString()});

        return numRowsUpdated != 1;
    }

    public boolean delete(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int numOfAffectedRows = db.delete(TABLE_NAME, "ID = ?", new String[]{id.toString()});
        return numOfAffectedRows != -1;
    }

    private String getRandomImageName() {
        Random ran = new Random();

        int value = ran.nextInt(30) + 1;
        return "ic_monster_" + value;
    }

    public List<Products> getProducts(){
        List<Products> products = new ArrayList<>();
        Cursor cursor = getAll();

        if(cursor.getCount() > 0){

            Products product;

            while (cursor.moveToNext()) {
                Long id = cursor.getLong(0);
                String name = cursor.getString(1);
                String expdate = cursor.getString(2);
                Integer barcode = cursor.getInt(3);


                product = new Products(id, name,expdate,barcode);
                products.add(product);
            }
        }
        cursor.close();
        return products;

    }

}

