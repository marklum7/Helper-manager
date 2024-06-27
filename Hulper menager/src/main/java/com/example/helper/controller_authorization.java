package com.example.helper;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class controller_authorization {

    @FXML
    private ResourceBundle resources;
    @FXML
    private Text erorr;

    @FXML
    private URL location;
    @FXML
    private AnchorPane main;

    @FXML
    private Button entry_button;

    @FXML
    private Hyperlink registration_button;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {
        Const.scene3=this;
        entry_button.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String passwordText = password_field.getText().trim();

            erorr.setText("Введите некорректные данные");
            if (!loginText.equals("") && !passwordText.equals(""))
                loginUser(loginText, passwordText);
        });


        registration_button.setOnAction(event -> {
            registration_button.getScene().getWindow().hide();

            try {
                Perehod.TransitionWindows(main,"view_registration",300,300,false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

       });
    }
    private void loginUser(String loginText, String passwordText) {
        DatebaseHendler dbHandler = new DatebaseHendler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passwordText);
        ResultSet result = dbHandler.getUser(user);

        int counter=0;

        try {
            while (result.next()){
                erorr.setText("");
                User_info.id=result.getString(Const.USER_ID);
                User_info.login=result.getString(Const.USER_LOGIN);
                User_info.password=result.getString(Const.USER_PASSWORD);
                User_info.phone=result.getString(Const.USER_PHONE);
                User_info.role=result.getString(Const.USER_ROLE);

                counter++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        if(counter>=1){
            if (User_info.role.equals("client")){
                registration_button.getScene().getWindow().hide();

                try {
                    Perehod.TransitionWindows(main,"view_client_window",300,400,true);
                } catch (IOException e) {
                    throw new RuntimeException(e);

                }
            }
            if (User_info.role.equals("admin")){
                registration_button.getScene().getWindow().hide();

                try {
                    Perehod.TransitionWindows(main,"view_admin_window",300,400,true);
                } catch (IOException e) {
                    throw new RuntimeException(e);

                }
            }
            }

        }
    }



