package com.example.authguiapp.services;

import com.example.authguiapp.entities.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AuthorizationService {
    boolean loginUser(String email, String password) throws SQLException;
    ResultSet getUser(UserEntity user);
}
