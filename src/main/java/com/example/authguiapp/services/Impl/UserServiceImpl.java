package com.example.authguiapp.services.Impl;

import com.example.authguiapp.entities.UserEntity;
import com.example.authguiapp.services.OpenScene;
import com.example.authguiapp.services.UserService;
import com.example.authguiapp.sql.Const;
import com.example.authguiapp.sql.DataBaseHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService, OpenScene {
    private final DataBaseHandler dataBaseHandler = new DataBaseHandler();

    @Override
    public boolean loginUser(String requestEmail, String requestPassword) throws SQLException {
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
                openNewAlertScene("Invalid email or password");
                return false;
            }
        }
        else {
            openNewAlertScene("Email and password should not be empty");
            return false;
        }
    }

    @Override
    public ResultSet getUser(UserEntity user) {
        if (!user.getEmail().isEmpty() && !user.getPass().isEmpty()) {
            ResultSet resultSet;

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
        else {
            return null;
        }
    }

    @Override
    public boolean createUser(UserEntity user) {
        try {
            boolean isFound = false;

            if (user.getEmail().isEmpty() || user.getPass().isEmpty()) {
                openNewAlertScene("Email and password should not be empty");
                return false;
            }
            else if (!user.getPass().equals(user.getConfirmPass())) {
                openNewAlertScene("The password confirmation and password fields do not match");
                return false;
            }
            else {
                ResultSet resultSet = getUser(user);
                if (resultSet != null) {
                    while (resultSet.next()) {
                        isFound = resultSet.getString("email").equals(user.getEmail());
                    }
                    if (!isFound) {
                        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_EMAIL + "," + Const.USERS_FIRST_NAME + "," +
                                Const.USERS_LAST_NAME + "," + Const.USERS_PHONE_NUMBER + "," + Const.USERS_PASS + ")" + "VALUES(?,?,?,?,?)";

                        PreparedStatement statement = dataBaseHandler.getDbConnection().prepareStatement(insert);
                        statement.setString(1, user.getEmail());
                        statement.setString(2, user.getFirstName());
                        statement.setString(3, user.getLastName());
                        statement.setString(4, user.getPhoneNumber());
                        statement.setString(5, user.getPass());

                        statement.executeUpdate();
                        return true;
                    }
                    else {
                        openNewAlertScene("This email is already exists");
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }

