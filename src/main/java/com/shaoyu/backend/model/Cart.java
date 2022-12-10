package com.shaoyu.backend.model;

import java.util.Map;

public class Cart {
    private int id;
    private String username;
    private int itemQuantity;
    private int totalAmount;

    public Cart() {
    }

    public Cart(int id, String username, int itemQuantity, int totalAmount) {
        this.id = id;
        this.username = username;
        this.itemQuantity = itemQuantity;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }


    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
