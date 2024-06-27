package com.example.helper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class controller_client_window {

    @FXML
    private Label Login;

    @FXML
    private Label Phone;

    @FXML
    private Button add_button;

    @FXML
    private TableColumn<Table_order, String> address;

    @FXML
    private TextField address_1;

    @FXML
    private Button back_button;

    @FXML
    private Hyperlink change_button;
    @FXML
    private Tab stata;

    @FXML
    private Label summa1;

    @FXML
    private Label zarab1;

    @FXML
    private TableColumn<Table_order, String> date;

    @FXML
    private DatePicker date_1;

    @FXML
    private TableView<Table_order> info_analysis;

    @FXML
    private AnchorPane main1;

    @FXML
    private TableColumn<Table_order, String> name;

    @FXML
    private TextField name_1;

    @FXML
    private TableColumn<Table_order, String> nomer;

    @FXML
    private TableColumn<Table_order, String> price;

    @FXML
    private TextField price_1;

    @FXML
    private TableColumn<Table_order, String> shop;

    @FXML
    private ComboBox<String> shop_1;


    @FXML
    void initialize() {
        addtable();

        Const.scene = this;
        change_button.setOnAction(event -> {
            Const.rollers="client";
            FXMLLoader fxmlLoader = new FXMLLoader(Perehod.class.getResource("view_edit_user.fxml"));

            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 300, 300);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("");
            stage.show();
                });

        shop_1.getItems().addAll("Вб","Яндекс","Озон",
        "Сбермаркет");

        Login.setText(User_info.login);
        Phone.setText(User_info.phone);
        DatebaseHendler dbHandler = new DatebaseHendler();
        String count = String.valueOf(dbHandler.summOrders(User_info.id));
        zarab1.setText(count);

        String count2 = String.valueOf(dbHandler.priceOrders(User_info.id));
        summa1.setText(count2);

        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();

            try {
                Perehod.TransitionWindows(main1,"view_authorization",300,400,false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        add_button.setOnAction(event ->{

            singUpOrder();
            addtable();
            UpdateData();

        });

    }

    void UpdateData(){
        Login.setText(User_info.login);
        Phone.setText(User_info.phone);
        DatebaseHendler dbHandler = new DatebaseHendler();
        String count = String.valueOf(dbHandler.summOrders(User_info.id));
        summa1.setText(count);

        String count2 = String.valueOf(dbHandler.priceOrders(User_info.id));
        zarab1.setText(count2);
    }

   private void singUpOrder() {
       DatebaseHendler dbHandler = new DatebaseHendler();
       String id_user=User_info.id;
       String shop=shop_1.getValue();
       String name=name_1.getText();
       String price=price_1.getText();
       String delivery=String.valueOf(date_1.getValue());
       String address=address_1.getText();
           Orders orders = new Orders(id_user,shop,name,price,delivery,address);
           dbHandler.singOrders(orders);
   }
    private void addtable(){DatebaseHendler dbHandler = new DatebaseHendler();
        ObservableList<Table_order> tables = dbHandler.completeTable2();
        nomer.setCellValueFactory(new PropertyValueFactory<Table_order, String>("id_orders"));
        shop.setCellValueFactory(new PropertyValueFactory<Table_order, String>("shop"));
        name.setCellValueFactory(new PropertyValueFactory<Table_order, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Table_order, String>("price"));
        date.setCellValueFactory(new PropertyValueFactory<Table_order, String>("data"));
        address.setCellValueFactory(new PropertyValueFactory<Table_order, String>("address"));
        info_analysis.refresh();
        info_analysis.setItems(tables);
    }

}
