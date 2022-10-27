package com.example.authguiapp.services.Impl;

import com.example.authguiapp.services.AuthorizationService;
import com.example.authguiapp.sql.Const;
import com.example.authguiapp.sql.DataBaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorizationServiceImpl implements AuthorizationService {

    private final DataBaseHandler dataBaseHandler = new DataBaseHandler();
    @Override
    public boolean loginUser(String requestEmail, String requestPassword) {
        if (!requestEmail.isEmpty() && !requestPassword.isEmpty()) {

            String select = "SELECT * FROM " + Const.USER_TABLE + ";";

            try {
                Statement statement = dataBaseHandler.getDbConnection().createStatement();

                ResultSet resultSet = statement.executeQuery(select);
                while (resultSet.next()) {
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("user_pass");

                    if (requestEmail.equals(email) && requestPassword.equals(password)) {
                        return true;
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
