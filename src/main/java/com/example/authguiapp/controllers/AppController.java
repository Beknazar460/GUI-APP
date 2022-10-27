package com.example.authguiapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button menuButtonApp;

    @FXML
    private ImageView neobisImageButton;

    @FXML
    void initialize() {
        menuButtonApp.setOnAction(event -> {
            menuButtonApp.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/authguiapp/authorization.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

}
