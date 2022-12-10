package com.shaoyu.backend.service.impl;

import com.shaoyu.backend.connection.MyBatisConnection;
import com.shaoyu.backend.mapper.CartMapper;
import com.shaoyu.backend.mapper.ItemMapper;
import com.shaoyu.backend.model.ItemQuantity;
import com.shaoyu.backend.service.ICartService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    CartMapper cartMapper;

    public CartServiceImpl() {
        SqlSession ss = MyBatisConnection.getConnection();
        cartMapper = ss.getMapper(CartMapper.class);
    }

    @Override
    public int getTotalAmount(int cartId) {
        return 0;
    }

    @Override
    public int getItemQuantity() {
        return 0;
    }

    @Override
    public List<ItemQuantity> getAllItemsByCart(int cartId) {
       return cartMapper.selectAllItemsByCart(cartId);
    }

    @Override
    public int addToCart(ItemQuantity itemQuantity) {
        cartMapper.insertIntoCart(itemQuantity.getCartId(), itemQuantity.getItemName(), itemQuantity.getQuantity(),itemQuantity.getId());
        return 0;
    }

    @Override
    public String removeItemsFromCart(int cartId, List<String> itemNames) {
        cartMapper.deleteItemsByCart(cartId,itemNames);
        return null;
    }




}
