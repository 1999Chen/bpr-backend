package com.shaoyu.backend.controller;


import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.service.IItemService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    @GetMapping("/getAllItems")
    public List<Item> getAllItems() throws SQLException, ClassNotFoundException {
        List<Item> newlist = itemService.getAllItems();
        return newlist;
    }

    @GetMapping("/getItemsByFilters")
    public List<Item> getItemList(String keyword,String  region, String category) {
        System.out.println("getitems by filters "+keyword+region+category);
        List<String> regionList = Arrays.asList(region.split("@"));
        System.out.println("items regions are"+regionList);
        List<String> categoryList = Arrays.asList(category.split("@"));
        System.out.println("items categories are"+categoryList);
        List<Item> newlist = itemService.getItemsByFilters(keyword,regionList,categoryList);
        return newlist;
    }



    @GetMapping("/getItemByName")
    public Item getItemByName(String name) {

        Item newItem = itemService.getItemByName(name);
        System.out.println("getting test item by name"+newItem.toString());
        return newItem;
    }

    @GetMapping("/getPrediction")
    public List<Item> getPredition(int userId) {

//        Item newItem = itemService.getItemByName(name);
//        System.out.println("getting test item by name"+newItem.toString());
//        return newItem;
        return null;
    }



    @PostMapping("/uploadItem")
    public String uploadItem(@RequestBody Item item) {

        System.out.println("add item name starts");
        System.out.println(item);
        System.out.println(item.toString());
        System.out.println(item.getName());
        itemService.uploadItem(item);
        System.out.println("uploadItem");
        return null;

    }



    @DeleteMapping("/removeItem")
    public String removeItem(String itemName) throws SQLException, ClassNotFoundException {

        System.out.println("remove item name starts");
        System.out.println("item to be deleted is "+itemName.toString());
        itemService.removeItem(itemName);
        itemService.getAllItems();

        return null;
//        return itemService.uploadItem(item);
    }

    @PostMapping("/updateItem")
    public String updateItem(@RequestBody Item item) {

        System.out.println("update item name starts");
        System.out.println(item);
        System.out.println(item.toString());
        System.out.println(item.getName());

        itemService.updateItemInfo(item);
        System.out.println("update Item");

        return null;
//        return itemService.uploadItem(item);
    }




}


