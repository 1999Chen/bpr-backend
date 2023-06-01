package com.shaoyu.backend.model;

public class ItemQuantity {

    private int cartId;
    private String itemName;
    private int itemId;
    private int quantity;



    public ItemQuantity(int cartId, String itemName, int itemId, int quantity ) {
        this.cartId = cartId;
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;

    }

    public ItemQuantity() {
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String toString() {
        return "ItemQuantity{" +
                "cartId=" + cartId +
                ", itemName='" + itemName + '\'' +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }
}
