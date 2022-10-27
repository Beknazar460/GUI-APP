package com.example.authguiapp.services.Impl;

import com.example.authguiapp.entities.UserEntity;
import com.example.authguiapp.services.RegisterService;
import com.example.authguiapp.sql.Const;
import com.example.authguiapp.sql.DataBaseHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterServiceImpl implements RegisterService {

    private final DataBaseHandler dataBaseHandler = new DataBaseHandler();

    @Override
    public boolean createUser(UserEntity user) {
        if (user.getConfirmPass().equals(user.getPass())) {
            String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_EMAIL + "," + Const.USERS_FIRST_NAME + "," +
                    Const.USERS_LAST_NAME + "," + Const.USERS_PHONE_NUMBER + "," + Const.USERS_PASS + ")" + "VALUES(?,?,?,?,?)";
            try {
                PreparedStatement statement = dataBaseHandler.getDbConnection().prepareStatement(insert);
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getFirstName());
                statement.setString(3, user.getLastName());
                statement.setString(4, user.getPhoneNumber());
                statement.setString(5, user.getPass());

                statement.executeUpdate();
                return true;
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else return false;
    }
}
