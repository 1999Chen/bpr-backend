package com.shaoyu.backend.service;

import com.shaoyu.backend.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserInfo(String username);
    void registerUser(User user);
    int validateLogin(String username,String password);
    String getUserRole(String username);

    void updateUserInfo(User user);

}
