package com.example.helper;

public class Table_order {
    private String id_orders;
    private String id_user;
    private String shop;

    public String getId_orders() {
        return id_orders;
    }

    public void setId_orders(String id_orders) {
        this.id_orders = id_orders;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String name;
    private String price;
    private String data;
    private String address;

    public Table_order(String id_orders, String id_user, String shop, String name, String price, String data, String address) {
        this.id_orders = id_orders;
        this.id_user = id_user;
        this.shop = shop;
        this.name = name;
        this.price = price;
        this.data = data;
        this.address = address;
    }
}
