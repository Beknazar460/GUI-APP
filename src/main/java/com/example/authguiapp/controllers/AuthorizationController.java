package com.example.authguiapp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AuthorizationController {

    @FXML
    private TextField emailFieldAuth;

    @FXML
    private PasswordField passwordFieldAuth;

    @FXML
    private Button registerButtonAuth;

    @FXML
    private Button signInButtonAuth;

    @FXML
    void initialize() {
        signInButtonAuth.setOnAction(event -> {
            System.out.println("Hello beka");
        });
    }
}
