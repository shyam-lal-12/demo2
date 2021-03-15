package com.rbc.demo2.model;

import java.io.Serializable;

public class RatedItems implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Item item;
    private float rating;
    public RatedItems() {
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public RatedItems(Item item, float rating) {
        this.item = item;
        this.rating = rating;
    }

}
