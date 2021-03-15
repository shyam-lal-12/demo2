package com.rbc.demo2.model;

import java.io.Serializable;

public class AverageRating implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Item item;
    private float averageRating;
    public AverageRating() {
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public float getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }


}
