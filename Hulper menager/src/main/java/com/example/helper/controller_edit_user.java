package com.example.helper;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class controller_edit_user {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker dilution_date_field;

    @FXML
    private Button edit_button;


    @FXML
    private TextField login_field;


    @FXML
    private TextField password_field;

    @FXML
    private TextField phone_field;


    @FXML
    void initialize() {
        login_field.setText(User_info.login);
        password_field.setText(User_info.password);
        phone_field.setText(User_info.phone);
        edit_button.setOnAction(event ->{
            editUser();
            edit_button.getScene().getWindow().hide();
            Const.scene.UpdateData();

        });

    }

     private void editUser() {
         DatebaseHendler dbHandler = new DatebaseHendler();

         String login=login_field.getText();
         String password=password_field.getText();
         String phone=phone_field.getText();
         String role=Const.rollers;

         User_info.login=login;
         User_info.password=password;
         User_info.phone=phone;

         dbHandler.editUser(login,password,phone, role);



     }

}
