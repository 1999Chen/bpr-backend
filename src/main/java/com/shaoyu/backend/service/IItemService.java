package com.shaoyu.backend.service;


import com.shaoyu.backend.model.Item;

import java.sql.SQLException;
import java.util.List;

public interface IItemService {

    Item getItemByName(String name);
    List<Item> getItemsByFilters(String keyword,List<String> regions, List<String>  categories);
    Item getItemById(int id) throws SQLException, ClassNotFoundException;
    List<Item> getAllItems() throws ClassNotFoundException, SQLException;
    String uploadItem(Item item);


    List<Item> getPrediction(int userId);
    String updateItemInfo(Item item);

    void   removeItem(String itemName) throws SQLException, ClassNotFoundException;

    void  removeItems(String itemNames);
    String removeItemsFromCart(List<String> itemNames);

    /*    String get(String id);*/

}
