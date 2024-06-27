package com.example.helper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class controller_registration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink entry_button;


    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField phone_field;
    @FXML
    private AnchorPane main1;

    @FXML
    private Button registration_button;

    @FXML
    void initialize() {

        registration_button.setOnAction(event ->{
            
            singUpNewUser();

            registration_button.getScene().getWindow().hide();

            try {
                Perehod.TransitionWindows(main1,"view_authorization",300,300,false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        entry_button.setOnAction(event -> {
            entry_button.getScene().getWindow().hide();

           try {
               Perehod.TransitionWindows(main1,"view_authorization",300,300,false);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       });
    }

    private void singUpNewUser() {

        DatebaseHendler dbHandler = new DatebaseHendler();

        String login=login_field.getText();
        String password=password_field.getText();
        String phone=phone_field.getText();
        String role="client";

        User user = new User(login,password,phone,role);
                dbHandler.singUpUser(user);


    }

}
