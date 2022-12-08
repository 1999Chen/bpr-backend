package com.shaoyu.backend.service;


import com.shaoyu.backend.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface IItemService {
    Item getItemByName(String name);
    List<Item> getItemsByName(String keyword);
    Item getItemById(int id) throws SQLException, ClassNotFoundException;
    List<Item> getAllItems() throws ClassNotFoundException, SQLException;

    String uploadItem(Item item);


    /*    String get(String id);*/

}
