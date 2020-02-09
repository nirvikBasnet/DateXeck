package com.example.datexheck.entities;

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
