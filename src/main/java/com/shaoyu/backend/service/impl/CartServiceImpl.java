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
    ItemMapper itemMapper;

    public CartServiceImpl() {
        SqlSession ss = MyBatisConnection.getConnection();
        cartMapper = ss.getMapper(CartMapper.class);
    }



    @Override
    public List<ItemQuantity> getAllItemsByCart(int cartId) {
        List<ItemQuantity>list = cartMapper.selectAllItemsByCart(cartId);
        for (ItemQuantity i:list
             ) {
            System.out.println(i.toString());
        }
       return list;
    }

    @Override
    public int addToCart(ItemQuantity itemQuantity) {
        cartMapper.insertIntoCart(itemQuantity.getCartId(), itemQuantity.getItemName(), itemQuantity.getQuantity(),itemQuantity.getItemId());
        return 0;
    }

    @Override
    public int generateNewCart(int userId) {

        cartMapper.generateNewCart(userId);
        return cartMapper.selectCartByUserId(userId);

    }



    @Override
    public int getCartByUser(int userId) {
        return cartMapper.selectCartByUserId(userId);
    }

    @Override
    public String removeItemsFromCart(int cartId, List<String> itemNames) {
        cartMapper.deleteItemsByCart(cartId,itemNames);
        return null;
    }

    @Override
    public String checkOutFromCart(int cartId) {
        //
        cartMapper.checkOutFromCart(cartId);

        return null;
    }


    @Override
    public String checkOutFromItems(int quantity, int itemId) {
       cartMapper.checkOutFromItems(quantity,itemId);
        System.out.println("checking out items ---- "+quantity+"---"+itemId);
        return null;
    }


}
