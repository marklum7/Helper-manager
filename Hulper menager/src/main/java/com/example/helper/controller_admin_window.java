package com.example.helper;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class controller_admin_window {

    @FXML
    private Button del_1;


    @FXML
    private TableColumn<Table_order, String> address_2;

    @FXML
    private Button back_button;

    @FXML
    private TableColumn<Table_order, String> date_2;

    @FXML
    private TableColumn<Table_users, String> login_1;

    @FXML
    private AnchorPane main1;

    @FXML
    private TableColumn<Table_order, String> name_2;

    @FXML
    private TableColumn<Table_order, String> nomer_2;

    @FXML
    private TableColumn<Table_users, String> pass_1;

    @FXML
    private TableColumn<Table_users, String> phone_1;
    @FXML
    private TableColumn<Table_users, String> nom1;

    @FXML
    private TabPane table_info;

    @FXML
    private TableColumn<Table_order, String> polz_2;

    @FXML
    private TableColumn<Table_order, String> price_2;


    @FXML
    private TableColumn<Table_order, String> shop_2;

    @FXML
    private TableView<Table_users> user_table;

    @FXML
    private TableView<Table_order> worker_table;

    private boolean status = false;

    @FXML
    void initialize() {
        table_info.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            status = !status;
        });
        addtable();
        back_button.setOnAction(event -> {
            back_button.getScene().getWindow().hide();

            try {
                Perehod.TransitionWindows(main1, "view_authorization", 300, 400, false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        del_1.setOnAction(event -> {
            if (status== false){
                DatebaseHendler dbHandler = new DatebaseHendler();
                Table_users selectedProduct = user_table.getSelectionModel().getSelectedItem();
                dbHandler.delet_user(selectedProduct.getId_user());
                addtable();


            }
            else{
                DatebaseHendler dbHandler = new DatebaseHendler();
                Table_order selectedProduct = worker_table.getSelectionModel().getSelectedItem();
                dbHandler.delet_order(selectedProduct.getId_orders());
                addtable();

                }
        });
    }
        private void addtable(){
            DatebaseHendler dbHandler = new DatebaseHendler();
            ObservableList<Table_users> tables1 = dbHandler.completeTable3();
            nom1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("id_user"));
            login_1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("login"));
            pass_1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("password"));
            phone_1.setCellValueFactory(new PropertyValueFactory<Table_users, String>("phone"));
            user_table.refresh();
            user_table.setItems(tables1);

            ObservableList<Table_order> tables3 = dbHandler.completeTable1();
            nomer_2.setCellValueFactory(new PropertyValueFactory<Table_order, String>("id_orders"));
            polz_2.setCellValueFactory(new PropertyValueFactory<Table_order, String>("id_user"));
            shop_2.setCellValueFactory(new PropertyValueFactory<Table_order, String>("shop"));
            name_2.setCellValueFactory(new PropertyValueFactory<Table_order, String>("name"));
            price_2.setCellValueFactory(new PropertyValueFactory<Table_order, String>("price"));
            date_2.setCellValueFactory(new PropertyValueFactory<Table_order, String>("data"));
            address_2.setCellValueFactory(new PropertyValueFactory<Table_order, String>("address"));
            worker_table.refresh();
            worker_table.setItems(tables3);

    }
}
