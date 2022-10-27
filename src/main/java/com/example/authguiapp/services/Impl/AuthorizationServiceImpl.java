package com.example.authguiapp.services.Impl;

import com.example.authguiapp.entities.UserEntity;
import com.example.authguiapp.services.AuthorizationService;
import com.example.authguiapp.sql.Const;
import com.example.authguiapp.sql.DataBaseHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorizationServiceImpl implements AuthorizationService {
    private DataBaseHandler dataBaseHandler;

    @Override
    public boolean loginUser(String requestEmail, String requestPassword) throws SQLException {
            dataBaseHandler = new DataBaseHandler();
            UserEntity user = new UserEntity();
            user.setEmail(requestEmail);
            user.setPass(requestPassword);
            ResultSet resultSet = getUser(user);

            boolean isFound = false;

            if (resultSet != null) {
                while (resultSet.next()) {
                    isFound = resultSet.getString("email").equals(user.getEmail()) && resultSet.getString("user_pass").equals(user.getPass());
                }
                if (isFound) {
                    return true;
                }
                else {
                    System.out.println("invalid email address or password");
                    return false;
                }
            }
            else {
                System.out.println("fields should not be empty");
                return false;
            }
    }

    @Override
    public ResultSet getUser(UserEntity user) {
        if (!user.getEmail().isEmpty() && !user.getPass().isEmpty()) {
            ResultSet resultSet;
            dataBaseHandler = new DataBaseHandler();

            String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_EMAIL + "=? AND " + Const.USERS_PASS + "=?";

            try {
                PreparedStatement statement = dataBaseHandler.getDbConnection().prepareStatement(select);
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPass());
                resultSet = statement.executeQuery();

            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
            return resultSet;
        }
        else return null;
    }
}
