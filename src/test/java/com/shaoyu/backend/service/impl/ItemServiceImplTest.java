package com.shaoyu.backend.service.impl;

import com.shaoyu.backend.connection.MyBatisConnection;
import com.shaoyu.backend.mapper.ItemMapper;
import com.shaoyu.backend.model.Item;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Objects;

class ItemServiceImplTest {


    private static ItemMapper itemMapper;

    @BeforeAll
    static void init() {
        System.out.println("creating DB connection...");
        SqlSession ss = MyBatisConnection.getConnection();
        itemMapper = ss.getMapper(ItemMapper.class);
    }

    @Test
    void getItemByName() {
        List<Item> list = itemMapper.selectItemByName("cocacola");
        assert(Objects.equals(list.get(0).getName(), "cocacola"));
    }

    @Test
    void getItemsByFilters() {
    }

    @Test
    void getItemById() {
    }

    @Test
    void getAllItems() {
    }

    @Test
    void uploadItem() {
    }

    @Test
    void getItemsByFiltersTest() {
    }

    @Test
    void updateItemInfo() {
    }

    @Test
    void removeItemsFromCart() {
    }
}
