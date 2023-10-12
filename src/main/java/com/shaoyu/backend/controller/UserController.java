package com.shaoyu.backend.controller;

import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.User;
import com.shaoyu.backend.service.IUserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
        System.out.println("get user info");
        User user = userService.getUserInfo(username);
        System.out.println("userid"+user.getUserId());
        System.out.println("user name"+user.getUsername());
        System.out.println("user age"+user.getAge());
        System.out.println("user region"+user.getRegion());
        System.out.println("user phone"+user.getPhoneNumber());
        return user;
    }

    @PostMapping("/registerUser")
    public int registerUser(@RequestBody User user) throws SQLException, ClassNotFoundException {
        int validateCode = userService.validateSignUp(user.getUsername());
        System.out.println("validate code is "+validateCode);
        if (validateCode == 0) {
            //0 means username can be used
            userService.registerUser(user);
            return 1;
        } else {
            //1 means username already exists
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

    @GetMapping("/getPrediction")
    public List<Item> getPrediction(int age,int gender,String region) throws SQLException, ClassNotFoundException, JSONException, IOException {
        System.out.println("getting in prediction  with paras"+age+gender+region);
        List<Item> list = userService.getPrediction(age,gender,region);
        return list;
    }





}
