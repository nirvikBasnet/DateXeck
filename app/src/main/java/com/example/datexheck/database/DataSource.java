//package com.example.datexheck.database;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.DatabaseUtils;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import com.example.datexheck.entities.Product;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.example.datexheck.database.DatabaseHelper.TABLE_ITEMS;
//
//public class DataSource {
//
//    private Context mContext;
//    private SQLiteDatabase mDatabase;
//    SQLiteOpenHelper mDbHelper;
//
//
//
//
//    public DataSource(Context context) {
//        this.mContext = context;
//
//        mDbHelper = new DatabaseHelper(mContext);
//        mDatabase = mDbHelper.getWritableDatabase();
//
//    }
//
//    public void open(){
//        mDatabase = mDbHelper.getWritableDatabase();
//    }
//
//    public  void close(){
//        mDbHelper.close();
//    }
//
//    public Product createItem(Product item) {
//
//        ContentValues values = item.toValues();
//
//        mDatabase.insert(TABLE_ITEMS, null, values);
//        return item;
//
//    }
//
//    public long getDataItemsCount(){
//        return DatabaseUtils.queryNumEntries(mDatabase, TABLE_ITEMS);
//    }
////
//    public void seedDatabase(List<Product> dataItemList){
//        long numItems = getDataItemsCount();
//
//        if(numItems == 0){
//            for(Product item : dataItemList){
//                try{
//                    createItem(item);
//                }catch (SQLException e){
//                    e.printStackTrace();
//                }
//
//            }
//        }
//
//
//
//    }

//
//    public List<DataItem> getAllItems(){
//        List<DataItem> dataItems = new ArrayList<>();
//
//        Cursor cursor = mDatabase.query(ItemsTable.TABLE_ITEMS,ItemsTable.ALL_COLUMNS,null,null,null,null,null);
//
//
//        while(cursor.moveToNext()){
//            DataItem item = new DataItem();
//            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
//            item.setItemName(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_NAME)));
//            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_BARCODE)));
//            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
//            item.setItemId(cursor.getString(cursor.getColumnIndex(ItemsTable.COLUMN_ID)));
//        }
//        return dataItems;
//    }
//}
