package com.example.helper;

public class User {
    private String login;
    private String password;
    private String phone;
    private String role;

    public User(String login, String password, String phone, String role) {
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public User() {

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


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

