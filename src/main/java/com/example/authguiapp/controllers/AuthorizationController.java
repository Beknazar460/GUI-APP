package com.example.authguiapp.controllers;

import com.example.authguiapp.services.Impl.UserServiceImpl;
import com.example.authguiapp.services.OpenScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AuthorizationController implements OpenScene {

    private final UserServiceImpl userService = new UserServiceImpl();

    @FXML
    private TextField emailFieldAuth;

    @FXML
    private PasswordField passwordFieldAuth;

    @FXML
    private Button registerButtonAuth;

    @FXML
    private Button signInButtonAuth;

    @FXML
    private Button adminPanelButtonAuth;

    @FXML
    void initialize() {
        
        //There is button for authorization
        signInButtonAuth.setOnAction(event -> {
            String email = emailFieldAuth.getText();
            String password = passwordFieldAuth.getText();
            boolean authorize;
            try {
                authorize = userService.loginUser(email, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (authorize) {
                openNewScene(signInButtonAuth, "/com/example/authguiapp/app.fxml");
            }
        });

        //There is button for registration
        registerButtonAuth.setOnAction(event -> {
            openNewScene(registerButtonAuth, "/com/example/authguiapp/register.fxml");
        });

        //There is button for admin
        adminPanelButtonAuth.setOnAction(event -> {
            openNewScene(adminPanelButtonAuth, "");
        });
    }
}
