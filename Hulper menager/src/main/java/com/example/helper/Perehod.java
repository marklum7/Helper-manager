package com.example.helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Perehod {
    public static void TransitionWindows(AnchorPane AnchorPane, String name, double width, double height, boolean variability) throws IOException {
        AnchorPane.getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(Perehod.class.getResource(name+".fxml"));

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("");
        if(variability){
            stage.setMinWidth(610);
            stage.setMinHeight(400);
        }
        stage.setResizable(variability);
        stage.show();
    }
}
