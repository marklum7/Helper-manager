package com.example.helper;

public class Table_users {
    private String id_user;
    private String login;
    private String password;
    private String phone;
    private String role;

    public String getId() {
        return id_user;
    }

    public void setId(String id_user) {
        this.id_user = id_user;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_orders) {
        this.id_user = id_orders;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Table_users(String id_user,String login, String password, String phone, String role) {
        this.id_user = id_user;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }
}
