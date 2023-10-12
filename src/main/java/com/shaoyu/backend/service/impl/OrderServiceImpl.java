package com.shaoyu.backend.service.impl;

import com.shaoyu.backend.connection.MyBatisConnection;
import com.shaoyu.backend.mapper.CartMapper;
import com.shaoyu.backend.mapper.OrderMapper;
import com.shaoyu.backend.model.Order;
import com.shaoyu.backend.service.IOrderService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    OrderMapper orderMapper;
    CartMapper cartMapper;

    public OrderServiceImpl()  {
        SqlSession ss = MyBatisConnection.getConnection();
        orderMapper = ss.getMapper(OrderMapper.class);
        cartMapper = ss.getMapper(CartMapper.class);
    }


    @Override
    public List<Order> getAllOrders() {
        return orderMapper.selectAllOrders();
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderMapper.selectOrderInfo(orderId);
    }


    @Override
    public void addOrder(int cartId,int amount) {
        int userId = cartMapper.selectUserByCartId(cartId);

        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = tempDate.format(new java.util.Date());

        System.out.println(date);

        orderMapper.insertOrder(cartId,userId,amount,date);
    }



}
