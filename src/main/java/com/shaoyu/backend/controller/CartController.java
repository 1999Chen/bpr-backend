package com.shaoyu.backend.controller;

import com.shaoyu.backend.model.Item;
import com.shaoyu.backend.model.ItemQuantity;
import com.shaoyu.backend.service.ICartService;
import com.shaoyu.backend.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @PostMapping("/addToCart")
    public String addItemToCart(@RequestBody ItemQuantity itemQuantity) {

        System.out.println("add item to cart starts");
        System.out.println(itemQuantity.getItemName());
        System.out.println(itemQuantity.getQuantity());
        cartService.addToCart(itemQuantity);

        return null;
//        return itemService.uploadItem(item);
    }
    @GetMapping("/getAllItemsByCart")
    public List<ItemQuantity> getAllItemByCart(int cartId) {

        System.out.println("getAllItemsByCart starts");
        System.out.println(cartId);
        List<ItemQuantity> list =cartService.getAllItemsByCart(cartId);
        System.out.println(list);
        return list;

//        return itemService.uploadItem(item);
    }

    @DeleteMapping("/removeItemsFromCart")
    public String removeItemsFromCart(int cartId, String itemNames) {

        System.out.println("removeItemsFromCart");
        System.out.println(cartId);
        System.out.println(itemNames);
        List<String> itemNameList = Arrays.asList(itemNames.split("@"));
        System.out.println(itemNameList);
        cartService.removeItemsFromCart(cartId,itemNameList);
        return null;

//        return itemService.uploadItem(item);
    }

}
