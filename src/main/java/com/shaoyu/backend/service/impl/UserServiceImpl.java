package com.shaoyu.backend.service.impl;

import com.shaoyu.backend.connection.MyBatisConnection;
import com.shaoyu.backend.mapper.OrderMapper;
import com.shaoyu.backend.mapper.UserMapper;
import com.shaoyu.backend.model.User;
import com.shaoyu.backend.service.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    UserMapper userMapper;

    public UserServiceImpl()  {
        SqlSession ss = MyBatisConnection.getConnection();
        userMapper = ss.getMapper(UserMapper.class);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserInfo(String username) {
        return null;
    }

    @Override
    public void registerUser(User user){userMapper.insertUser(user);
    }

    @Override
    public int validateLogin(String username, String password) {
        int a = userMapper.validateUserInfo(username,password);
        System.out.println("user login a "+a);
        return a;
    }

    @Override
    public String getUserRole(String username) {
        return  userMapper.selectUserRole(username);
    }
    @Override
    public void updateUserInfo(User user) {
         userMapper.updateUserInfo(user);
    }

}
