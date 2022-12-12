package com.shaoyu.backend.service.impl;

import com.shaoyu.backend.connection.MyBatisConnection;
import com.shaoyu.backend.mapper.ItemMapper;
import com.shaoyu.backend.mapper.OrderMapper;
import com.shaoyu.backend.model.Order;
import com.shaoyu.backend.service.IOrderService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    OrderMapper orderMapper;

    public OrderServiceImpl()  {
        SqlSession ss = MyBatisConnection.getConnection();
        orderMapper = ss.getMapper(OrderMapper.class);
    }


    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Order> getAllOrdersByUser(String username) {
        return null;
    }

    @Override
    public Order getOrderInfo(String orderId) {
        return null;
    }

    @Override
    public Order addOrder(Order order) {
        return null;
    }

    @Override
    public Order removeOrders(List<Order> orders) {
        return null;
    }
}
