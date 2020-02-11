package com.example.datexheck.entities;



public class Product {

    //attributes of product class
    private long id;
    private String productName;
    private String productExpDate;
    private Long productBarcode;


    //setting Constructor
    public Product(long id, String productName, String productExpDate, Long productBarcode) {
        this.id = id;
        this.productName = productName;
        this.productExpDate = productExpDate;
        this.productBarcode = productBarcode;
    }


    //setting setter and getter
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

    public Long getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(Long productBarcode) {
        this.productBarcode = productBarcode;
    }

    //setting toString

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productExpDate='" + productExpDate + '\'' +
                ", productBarcode=" + productBarcode +
                '}';
    }

}
