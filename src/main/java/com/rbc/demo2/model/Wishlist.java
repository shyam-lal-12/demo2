package com.rbc.demo2.model;

import java.io.Serializable;

public class Wishlist implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int customerId;
    private Item item;
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    
    public Wishlist() {
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    

}
