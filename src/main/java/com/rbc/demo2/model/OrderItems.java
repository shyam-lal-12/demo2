package com.rbc.demo2.model;

import java.io.Serializable;

public class OrderItems implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int orderId;
    private User user;
    private Item item;
    private float rating;

    public OrderItems(int orderId, User user, Item item) {
        this.orderId = orderId;
        this.user = user;
        this.item = item;
    }

    public OrderItems() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "OrderItems [item=" + item + ", orderId=" + orderId + ", rating=" + rating + ", user=" + user + "]";
    }

}
