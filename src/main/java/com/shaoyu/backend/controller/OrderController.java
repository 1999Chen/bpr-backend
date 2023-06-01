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

    @GetMapping("/getOrderById")
    public Order getOrderById(int orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/generateAnOrder")
    public void addOrder(int cartId,int amount) {
         orderService.addOrder(cartId,amount);
    }



}
