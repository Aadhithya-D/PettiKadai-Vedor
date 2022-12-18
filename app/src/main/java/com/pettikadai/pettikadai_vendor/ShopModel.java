package com.pettikadai.pettikadai_vendor;

public class ShopModel {
    String shopName;
    String shopLocation;
    long contactNumber;

    public ShopModel() {
    }

    public ShopModel(String shopName, String shopLocation, long contactNumber) {
        this.shopName = shopName;
        this.shopLocation = shopLocation;
        this.contactNumber = contactNumber;
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
}
