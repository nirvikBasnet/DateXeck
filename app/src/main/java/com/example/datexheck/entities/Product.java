package com.example.datexheck.entities;

import android.content.ContentValues;

import static com.example.datexheck.database.DatabaseHelper.COLUMN_BARCODE;
import static com.example.datexheck.database.DatabaseHelper.COLUMN_EXPDATE;
import static com.example.datexheck.database.DatabaseHelper.COLUMN_NAME;

public class Product {
    private long id;
    private String productName;
    private String productExpDate;
    private Integer productBarcode;



    public Product(long id, String productName, String productExpDate, Integer productBarcode) {
        this.id = id;
        this.productName = productName;
        this.productExpDate = productExpDate;
        this.productBarcode = productBarcode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductExpDate() {
        return productExpDate;
    }

    public void setProductExpDate(String productExpDate) {
        this.productExpDate = productExpDate;
    }

    public Integer getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(Integer productBarcode) {
        this.productBarcode = productBarcode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productExpDate='" + productExpDate + '\'' +
                ", productBarcode=" + productBarcode +
                '}';
    }
    public ContentValues toValues(){
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, productName);
        values.put(COLUMN_EXPDATE, productExpDate);
        values.put(COLUMN_BARCODE, productBarcode);

        return values;
    }
}
