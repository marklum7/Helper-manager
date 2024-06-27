package com.example.helper;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatebaseHendler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPost + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser,
                dbPass);
        return dbConnection;
    }

    public void singUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_LOGIN + "," + Const.USER_PASSWORD + "," +
                Const.USER_PHONE + "," + Const.USER_ROLE + ")" +
                "VALUES(?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            prSt.setString(3, user.getPhone());
            prSt.setString(4, user.getRole());
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void delet_order(String login) {
        String qwery = "DELETE FROM " + Const.ORDERS_TABLE + " WHERE " + Const.ORDERS_ID + " = '" + login + "';";
        System.out.println(qwery);
        try {
            Statement prSt = getDbConnection().createStatement();
            prSt.execute(qwery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void delet_user(String login) {
        String qwery = "DELETE FROM " + Const.USER_TABLE + " WHERE " + Const.USER_ID + "='" + login + "';";
        System.out.println(qwery);
        try {
            Statement prSt = getDbConnection().createStatement();
            prSt.execute(qwery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE +
                " WHERE " + Const.USER_LOGIN + "=? AND " +
                Const.USER_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }

    public Integer summOrders(String id_user) {
        String inserts = "SELECT COUNT(*) FROM orders WHERE id_user = " + id_user + ";";
        try {

            Statement prSt = getDbConnection().createStatement();
            ResultSet result = prSt.executeQuery(inserts);
            while (result.next()) {
                return result.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    public Integer priceOrders(String id_user) {
        String inserts = "SELECT SUM(price) FROM orders WHERE id_user = " + id_user + ";";
        try {

            Statement prSt = getDbConnection().createStatement();
            ResultSet result = prSt.executeQuery(inserts);
            while (result.next()) {
                return result.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }



     public void singOrders(Orders orders) {
         String inserts = "INSERT INTO " + Const.ORDERS_TABLE+"("+
                 Const.ORDERS_USER_ID+","+Const.ORDERS_SHOP+","+Const.ORDERS_NAME+","+
                 Const.ORDERS_PRICE+","+Const.ORDERS_DATE+","+Const.ORDERS_ADDRESS+")"+
                 "VALUES(?,?,?,?,?,?)";


         try {
             PreparedStatement prSt=getDbConnection().prepareStatement(inserts);
             prSt.setString(1, orders.getId_user());
             prSt.setString(2, orders.getShop());
             prSt.setString(3, orders.getName());
             prSt.setString(4, orders.getPrice());
             prSt.setString(5, orders.getDate());
             prSt.setString(6, orders.getAddress());
             prSt.executeUpdate();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         }
     }
     public void editUser(String login, String password,String phone, String role) {
         String inserts = "UPDATE "+Const.USER_TABLE+" SET "+Const.USER_LOGIN+ "='"+login+"', "+Const.USER_PASSWORD+ "='"+password+"', "+
                 Const.USER_PHONE+ "='"+phone+
                 "' WHERE ("+Const.USER_ID+" = "+User_info.id+");";


         try {
             Statement prSt=getDbConnection().createStatement();
             prSt.execute(inserts);
         } catch (SQLException e) {
             throw new RuntimeException(e);
         } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         }
     }

    public ObservableList<Table_order> completeTable2(){
        ObservableList<Table_order>  table2 = FXCollections.observableArrayList();
        String inserts = "SELECT id_orders, id_user, shop, name, price, date, address FROM orders where id_user = "+User_info.id;
        try {

            Statement prSt=getDbConnection().createStatement();
            ResultSet result = prSt.executeQuery(inserts);
            while (result.next()){

                table2.add(new Table_order(result.getString("id_orders"),result.getString("id_user"),
                        result.getString("shop"),result.getString("name"),result.getString("price")
                        ,result.getString("date") ,result.getString("address")));


            }
            return table2;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
      public ObservableList<Table_users> completeTable3(){
          ObservableList<Table_users>  table3 = FXCollections.observableArrayList();
          String inserts = "SELECT * FROM user WHERE role = 'client'";
          try {

              Statement prSt=getDbConnection().createStatement();
              ResultSet result = prSt.executeQuery(inserts);
              while (result.next()){
                  table3.add(new Table_users(result.getString("id_user"),result.getString("login"),
                          result.getString("password"),result.getString("phone"),
                          result.getString("role")));

              }
              return table3;

          } catch (SQLException e) {
              throw new RuntimeException(e);
          } catch (ClassNotFoundException e) {
              throw new RuntimeException(e);
          }

      }
    public ObservableList<Table_order> completeTable1(){
        ObservableList<Table_order>  table2 = FXCollections.observableArrayList();
        String inserts = "SELECT * FROM orders";
        try {

            Statement prSt=getDbConnection().createStatement();
            ResultSet result = prSt.executeQuery(inserts);
            while (result.next()){

                table2.add(new Table_order(result.getString("id_orders"),result.getString("id_user"),
                        result.getString("shop"),result.getString("name"),result.getString("price")
                        ,result.getString("date") ,result.getString("address")));


            }
            return table2;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
