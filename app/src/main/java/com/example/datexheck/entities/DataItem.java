package com.example.datexheck.entities;

import android.content.ContentValues;

import com.example.datexheck.database.ItemsTable;

import java.util.UUID;

public class DataItem {
    private String itemId;
    private String itemName;
    private String itemExpDate;
    private int itemBarcode;
    private int sortPosition;

    public DataItem() {
    }

    public DataItem(String itemId, String itemName, String itemExpDate, int itemBarcode, int sortPosition) {
        if (itemId == null) {
            itemId = UUID.randomUUID().toString();
        }


        this.itemId = itemId;
        this.itemName = itemName;
        this.itemExpDate = itemExpDate;
        this.itemBarcode = itemBarcode;
        this.sortPosition = sortPosition;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemExpDate() {
        return itemExpDate;
    }

    public void setItemExpDate(String itemExpDate) {
        this.itemExpDate = itemExpDate;
    }

    public int getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(int itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public int getSortPosition() {
        return sortPosition;
    }

    public void setSortPosition(int sortPosition) {
        this.sortPosition = sortPosition;
    }


    public ContentValues toValues(){
        ContentValues values = new ContentValues();

        values.put(ItemsTable.COLUMN_ID, itemId);
        values.put(ItemsTable.COLUMN_NAME, itemName);
        values.put(ItemsTable.COLUMN_EXPDATE, itemExpDate);
        values.put(ItemsTable.COLUMN_BARCODE, itemBarcode);
        values.put(ItemsTable.COLUMN_POSITION, sortPosition);

        return values;
    }




    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemExpDate='" + itemExpDate + '\'' +
                ", itemBarcode=" + itemBarcode +
                ", sortPosition=" + sortPosition +
                '}';
    }


}
