package com.shaoyu.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.ItemQuantity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Item> {


    void generateNewCart(int userId);
    int selectCartByUserId(int userId);

    int selectUserByCartId(int cartId);

    List<ItemQuantity> selectAllItemsByCart(int cartId);

    void insertIntoCart(int cartId, String itemName, int quantity, int itemId);

    void deleteItemsByCart(int cartId, List<String> itemNames);


    void checkOutFromCart(int cartId); //remove all items in the cart

    void checkOutFromItems(int quantity,int itemId);  //update stock after purchase

    void checkOutCart(int cartId) ;//turn is_checked to 1, then the cart is inactive, user get a new cart

}
