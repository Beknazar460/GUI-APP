package com.example.authguiapp.controllers;

import com.example.authguiapp.services.OpenSceneService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AppController implements OpenSceneService {
    @FXML
    private Button menuButtonApp;

    @FXML
    void initialize() {
        menuButtonApp.setOnAction(event -> {
            openNewScene(menuButtonApp, "/com/example/authguiapp/authorization.fxml");
        });
    }

}
