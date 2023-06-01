package com.shaoyu.backend.service;

import com.shaoyu.backend.model.Order;

import java.util.List;

public interface IOrderService {

    List<Order> getAllOrders();

    Order getOrderById(int orderId);

    void addOrder(int userId,int amount);


}
