package com.shaoyu.backend.controller;

import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.User;
import com.shaoyu.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> list = userService.getAllUsers();
        return list;
    }

    @GetMapping("/getUserInfo")
    public User getUserInfo(String username) throws SQLException, ClassNotFoundException {
        User user = userService.getUserInfo(username);
        return user;
    }

    @PostMapping("/registerUser")
    public User registerUser(User user) throws SQLException, ClassNotFoundException {
        User newUser = userService.registerUser(user);
        return newUser;
    }



    @GetMapping("/removeUser")
    public String removeUser(String usernames) throws SQLException, ClassNotFoundException {
        String a = userService.removeUser(usernames);
        return a;
    }

    @GetMapping("/getUserRole")
    public String getUserRole(String username) throws SQLException, ClassNotFoundException {
        String a = userService.getUserRole(username);
        return a;
    }

    @GetMapping("/validateLogin")
    public String  validateLogin(String username,String password) throws SQLException, ClassNotFoundException {
        String a = userService.validateLogin(username,password);
        return a;
    }



}
