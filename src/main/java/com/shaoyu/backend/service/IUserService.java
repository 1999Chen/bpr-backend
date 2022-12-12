package com.shaoyu.backend.service;

import com.shaoyu.backend.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserInfo(String username);
    User registerUser(User user);
    String validateLogin(String username,String password);
    String getUserRole(String username);
    String removeUser(String username);

}
