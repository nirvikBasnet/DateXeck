package com.example.datexheck.database;

public class ItemsTable {
    public static final String TABLE_ITEMS = "items";
    public static final String COLUMN_ID = "itemsId";
    public static final String COLUMN_NAME = "itemsName";
    public static final String COLUMN_EXPDATE= "itemsExpDate";
    public static final String COLUMN_BARCODE = "itemsBarcode";
    public static final String COLUMN_POSITION = "itemsPosition";


    public static final String[] ALL_COLUMNS = {COLUMN_ID,COLUMN_ID,COLUMN_NAME,COLUMN_EXPDATE,COLUMN_BARCODE,COLUMN_POSITION,};

    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_ITEMS + "(" + COLUMN_ID + " TEXT PRIMARY KEY," + COLUMN_NAME + " TEXT," + COLUMN_EXPDATE + " TEXT," +
    COLUMN_BARCODE + " INTEGER," + COLUMN_POSITION + " INTEGER" + ");";

    public static final String SQL_DELETE = "DROP TABLE " + TABLE_ITEMS;

}
