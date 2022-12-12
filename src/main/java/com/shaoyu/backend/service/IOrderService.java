package com.shaoyu.backend.service;

import com.shaoyu.backend.model.Order;

import java.util.List;

public interface IOrderService {

    List<Order> getAllOrders();
    List<Order> getAllOrdersByUser(String username);
    Order getOrderInfo(String orderId);
    Order addOrder(Order order);
    Order removeOrders(List<Order> orders);

}
