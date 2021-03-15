package com.rbc.demo2.model;

import java.io.Serializable;
import java.util.List;

public class RecommendedItems implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<RatedItems> myOrdersList;
    private List<Item> myWishlist;
    private List<RatedItems> rating;
    // private HotDeals hotdeals;

    public RecommendedItems() {
    }


    public List<Item> getMyWishlist() {
        return myWishlist;
    }

    public void setMyWishlist(List<Item> myWishlist) {
        this.myWishlist = myWishlist;
    }

    public List<RatedItems> getRating() {
        return rating;
    }

    public void setRating(List<RatedItems> rating) {
        this.rating = rating;
    }



    public List<RatedItems> getMyOrdersList() {
        return myOrdersList;
    }



    public void setMyOrdersList(List<RatedItems> myOrdersList) {
        this.myOrdersList = myOrdersList;
    }


}
