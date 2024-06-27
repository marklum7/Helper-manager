package com.example.helper;

public class Orders {
    public Orders(String id_user, String shop, String name, String price, String date, String address) {
        this.id_user = id_user;
        this.shop = shop;
        this.name = name;
        this.price = price;
        this.date = date;
        this.address = address;
    }



    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String id_order;
    private String id_user;
    private String shop;
    private String name;
    private String price;
    private String date;
    private String address;

}
