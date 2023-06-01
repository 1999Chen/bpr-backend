package com.shaoyu.backend.controller;

import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.User;
import com.shaoyu.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.IllegalFormatCodePointException;
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
    public int registerUser(@RequestBody User user) throws SQLException, ClassNotFoundException {
        int validateCode = userService.validateLogin(user.getUsername(), user.getPassword());
        if (validateCode == 0) {
            //1 means successfully registered
            userService.registerUser(user);
            return 1;
        } else {
            //0 means username already exists
            return 0;
        }
    }


    @GetMapping("/validateRole")
    public String getUserRole(String username) throws SQLException, ClassNotFoundException {
        return userService.getUserRole(username);
    }

    @PostMapping("/updateUserInfo")
    public void updateUserInfo(@RequestBody User user) throws SQLException, ClassNotFoundException {
        userService.updateUserInfo(user);
    }

    @GetMapping("/validateLogin")
    public int validateLogin(String username, String password) throws SQLException, ClassNotFoundException {
        return userService.validateLogin(username, password);
    }


}
