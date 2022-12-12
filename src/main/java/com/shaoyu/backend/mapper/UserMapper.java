package com.shaoyu.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.ItemQuantity;
import com.shaoyu.backend.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<Item> {


    List<User> selectAllUsers();
    User selectUserInfo(String username);
    User insertUser(User user);
    String selectLoginInfo(String username,String password);
    String selectUserRole(String username);
    String deleteUser(String username);
}
