package com.shaoyu.backend.service;

import com.shaoyu.backend.model.ItemQuantity;

import java.util.List;

public interface ICartService {
    int getTotalAmount(int cartId);

    List<ItemQuantity>  getAllItemsByCart(int cartId);
    int addToCart(ItemQuantity itemQuantity);
    int getCartByUser(String username);
    String removeItemsFromCart(int cartId, List<String> itemNames);
}
