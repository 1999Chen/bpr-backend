package com.shaoyu.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Item> {

    List<Order> selectAllOrders();

    Order selectOrderInfo(int orderId);
    void insertOrder(int cartId, int userId, int amount, String date);


}
