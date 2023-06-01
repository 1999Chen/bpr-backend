package com.shaoyu.backend.model;

import jnr.constants.platform.PRIO;

import java.sql.Date;

public class Order {

    private int orderId;

   private int userId;

   private int cartId;

   private int amount;

   private String date;

    public Order(int orderId, int userId, int cartId, int amount, String date) {
        this.orderId = orderId;
        this.userId = userId;
        this.cartId = cartId;
        this.amount = amount;
        this.date =date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", cartId=" + cartId +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
