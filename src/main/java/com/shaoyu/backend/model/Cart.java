package com.shaoyu.backend.model;

import java.util.Map;

public class Cart {
    private int cartId;
    private int userId;
    private int orderId;

    public Cart() {
    }

    public Cart(int cartId, int userId, int orderId) {
        this.cartId = cartId;
        this.userId = userId;
        this.orderId = orderId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
