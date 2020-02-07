package com.example.datexheck.entities;

import com.example.datexheck.AddProductActivity;

import java.io.Serializable;

public class Product implements Serializable {
    public long id;
    public String name;
    public String expDate;
    public Integer barcode;





    public Product(long id, String name, String expDate, Integer barcode) {
        this.id = id;
        this.name = name;
        this.expDate = expDate;
        this.barcode = barcode;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expDate='" + expDate + '\'' +
                ", barcode=" + barcode +
                '}';
    }
}
