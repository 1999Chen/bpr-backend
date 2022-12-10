package com.shaoyu.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.ItemQuantity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Item> {


    List<ItemQuantity> selectAllItemsByCart(int cartId);

    void insertIntoCart(int cartId, String itemName, int quantity, int id);

    void deleteItemsByCart(int cartId, List<String> itemNames);
}
