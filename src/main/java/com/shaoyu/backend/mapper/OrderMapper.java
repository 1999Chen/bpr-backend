package com.shaoyu.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Item> {

    List<Order> selectAllOrders();
    List<Order> selectAllOrdersByUser(String username);
    Order selectOrderInfo(String orderId);
    Order insertOrder(Order order);
    Order deleteOrders(List<Order> orders);

}
