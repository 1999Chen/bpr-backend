package com.shaoyu.backend.service;

import com.shaoyu.backend.model.ItemQuantity;

import java.util.List;

public interface ICartService {
    int getTotalAmount(int cartId);
    int getItemQuantity();
    List<ItemQuantity>  getAllItemsByCart(int cartId);
    int addToCart(ItemQuantity itemQuantity);
    String removeItemsFromCart(int cartId, List<String> itemNames);
}
