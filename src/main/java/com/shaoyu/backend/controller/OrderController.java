package com.shaoyu.backend.controller;

import com.shaoyu.backend.model.Order;
import com.shaoyu.backend.service.ICartService;
import com.shaoyu.backend.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }


    @GetMapping("/getOrdersByUser")
    public List<Order> getOrdersByUser(String username){
        return orderService.getAllOrdersByUser(username);
    }

    @GetMapping("/getOrdersByUser")
    public Order  getOrderInfo(String username){
        return orderService.getOrderInfo(username);
    }


    @DeleteMapping("/removeOrders")
    public Order removeOrders(String orders) {
        return null;
    }

    @GetMapping
    public Order addOrder(Order order) {
        return null;
    }



}
