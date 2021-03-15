package com.rbc.demo2.model;

import java.io.Serializable;

public class Rating implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private int customerId;
    private Item item;
    private float rating;
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
   
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public Rating() {
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public Rating(int customerId, Item item, float rating) {
        this.customerId = customerId;
        this.item = item;
        this.rating = rating;
    }
    

    
}
