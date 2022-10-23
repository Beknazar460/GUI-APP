module com.example.authguiapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.authguiapp to javafx.fxml;
    exports com.example.authguiapp;
}