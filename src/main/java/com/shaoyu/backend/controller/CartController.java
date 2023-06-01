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


    @PostMapping("/addNewCart")
    public int addNewCart(int userId) {

        return cartService.generateNewCart(userId);

    }

    @PostMapping("/addToCart")
    public String addItemToCart(@RequestBody ItemQuantity itemQuantity) {

        System.out.println("add item to cart starts");
        System.out.println(itemQuantity.getItemName());
        System.out.println(itemQuantity.getQuantity());
        cartService.addToCart(itemQuantity);

        return null;
//        return itemService.uploadItem(item);
    }

    @GetMapping("/getCartByUser")
    public int getCartByUser(int userId) {
        int id = cartService.getCartByUser(userId);
        System.out.println("getting cart id----" + id);
        return id;

    }

    @GetMapping("/getItemsByCart")
    public List<ItemQuantity> getItemsByCart(int cartId) {

        return cartService.getAllItemsByCart(cartId);

    }


    @DeleteMapping("/removeItemsFromCart")
    public String removeItemsFromCart(int cartId, String itemNames) {

        System.out.println("removeItemsFromCart");
        System.out.println(cartId);
        System.out.println(itemNames);
        List<String> itemNameList = Arrays.asList(itemNames.split("@"));
        System.out.println(itemNameList);
        cartService.removeItemsFromCart(cartId, itemNameList);
        return null;

    }

    @DeleteMapping("/checkOut")
    public String checkOutFromCart(int cartId) {
        System.out.println("checkoutFromCart");
        List<ItemQuantity> list = cartService.getAllItemsByCart(cartId);
        for (ItemQuantity i : list
        ) {
            cartService.checkOutFromItems(i.getQuantity(), i.getItemId());
        }
        cartService.checkOutFromCart(cartId);
        return null;

    }


}
