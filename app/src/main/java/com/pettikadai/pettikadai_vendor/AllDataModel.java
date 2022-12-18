package com.pettikadai.pettikadai_vendor;

public class AllDataModel {
    String shopName;
    String shopLocation;
    long contactNumber;
    String productName;
    int price;
    int quantity;

    public AllDataModel() {
    }

    public AllDataModel(String shopName, String shopLocation, long contactNumber, String productName, int price, int quantity) {
        this.shopName = shopName;
        this.shopLocation = shopLocation;
        this.contactNumber = contactNumber;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
