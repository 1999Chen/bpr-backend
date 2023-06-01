package com.shaoyu.backend.service;

import com.shaoyu.backend.model.ItemQuantity;

import java.util.List;

public interface ICartService {
   int generateNewCart(int userId);
    List<ItemQuantity>  getAllItemsByCart(int cartId);
    int addToCart(ItemQuantity itemQuantity);
    int getCartByUser(int userId);
    String removeItemsFromCart(int cartId, List<String> itemNames);

    String checkOutFromCart(int cartId);
    String checkOutFromItems(int quantity, int itemId);
}
