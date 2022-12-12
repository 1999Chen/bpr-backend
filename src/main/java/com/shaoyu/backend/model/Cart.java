package com.shaoyu.backend.model;

import java.util.Map;

public class Cart {
    private int id;
    private String username;
    private int totalAmount;

    public Cart() {
    }

    public Cart(int id, String username,  int totalAmount) {
        this.id = id;
        this.username = username;

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

                ", totalAmount=" + totalAmount +
                '}';
    }
}
