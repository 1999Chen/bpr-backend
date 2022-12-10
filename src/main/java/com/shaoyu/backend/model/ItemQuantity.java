package com.shaoyu.backend.model;

public class ItemQuantity {

    private int cartId;
    private String itemName;
    private int id;
    private int quantity;

    public ItemQuantity() {
    }

    public ItemQuantity(int cartId, String itemName, int id, int quantity) {
        this.cartId = cartId;
        this.itemName = itemName;
        this.id = id;
        this.quantity = quantity;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
