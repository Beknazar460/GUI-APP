package com.example.authguiapp.controllers;

import com.example.authguiapp.entities.UserEntity;
import com.example.authguiapp.services.Impl.UserServiceImpl;
import com.example.authguiapp.services.OpenScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController implements OpenScene {

    private final UserServiceImpl userService = new UserServiceImpl();

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
            boolean isCreated = userService.createUser(sendData());
            if (isCreated) {
                openNewScene(registerButtonRegister, "/com/example/authguiapp/authorization.fxml");
            }
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
