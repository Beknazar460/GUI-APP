package com.example.authguiapp.controllers;

import com.example.authguiapp.entities.UserEntity;
import com.example.authguiapp.services.Impl.RegisterServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    private final RegisterServiceImpl registerService = new RegisterServiceImpl();

    @FXML
    private PasswordField confirmPasswordRegister;

    @FXML
    private TextField emailRegister;

    @FXML
    private TextField firstNameRegister;

    @FXML
    private TextField lastNameRegister;

    @FXML
    private PasswordField passwordRegister;

    @FXML
    private TextField phoneNumberRegister;

    @FXML
    private Button registerButtonRegister;

    @FXML
    void initialize() {
        registerButtonRegister.setOnAction(event -> {
            boolean isCreated = registerService.createUser(sendData());
            if (isCreated) {
                registerButtonRegister.getScene().getWindow().hide();

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
            }
            else System.out.println("The repeated password does not match the current password");
        });
    }

    UserEntity sendData() {
        String email = emailRegister.getText();
        String firstName = firstNameRegister.getText();
        String lastName = lastNameRegister.getText();
        String pass = passwordRegister.getText();
        String phoneNumber = phoneNumberRegister.getText();
        String confirmPass = confirmPasswordRegister.getText();

        return new UserEntity(email, firstName, lastName, pass, phoneNumber, confirmPass);
    }

}
