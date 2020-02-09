package com.example.datexheck.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.datexheck.entities.DataItem;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;




    public DataSource(Context context) {
        this.mContext = context;

        mDbHelper = new DatabaseHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();

    }

    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public  void close(){
        mDbHelper.close();
    }

    public DataItem createItem(DataItem item) {

        ContentValues values = item.toValues();

        mDatabase.insert(ItemsTable.TABLE_ITEMS, null, values);
        return item;

    }

    public long getDataItemsCount(){
        return DatabaseUtils.queryNumEntries(mDatabase,ItemsTable.TABLE_ITEMS);
    }

    public void seedDatabase(List<DataItem> dataItemList){
        long numItems = getDataItemsCount();

        if(numItems == 0){
            for(DataItem item : dataItemList){
                try{
                    createItem(item);
                }catch (SQLException e){
                    e.printStackTrace();
                }

            }
        }



    }


    public List<DataItem> getAllItems(){
        List<DataItem> dataItems = new ArrayList<>();

        Cursor cursor = mDatabase.query(ItemsTable.TABLE_ITEMS,ItemsTable.ALL_COLUMNS,null,null,null,null,null);


        while(cursor.moveToNext()){
            DataItem item = new DataItem();
            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setItemName(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_NAME)));
            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_BARCODE)));
            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
        }
        return dataItems;
    }
}
