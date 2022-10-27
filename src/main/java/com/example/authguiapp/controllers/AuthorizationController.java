package com.example.authguiapp.controllers;

import com.example.authguiapp.services.Impl.AuthorizationServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthorizationController {

    private final AuthorizationServiceImpl authorizationService = new AuthorizationServiceImpl();

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
        
        //There is button for authorization
        signInButtonAuth.setOnAction(event -> {
            String email = emailFieldAuth.getText();
            String password = passwordFieldAuth.getText();
            boolean isFound = authorizationService.loginUser(email, password);

            if (isFound) {

                signInButtonAuth.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/com/example/authguiapp/app.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            else System.out.println("Error");
        });

        //There is button for registration
        registerButtonAuth.setOnAction(event -> {
            registerButtonAuth.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/authguiapp/register.fxml"));

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
