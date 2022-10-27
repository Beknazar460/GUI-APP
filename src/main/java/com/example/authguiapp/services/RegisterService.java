package com.example.authguiapp.services;

import com.example.authguiapp.entities.UserEntity;

public interface RegisterService {
    boolean createUser(UserEntity user);
}
