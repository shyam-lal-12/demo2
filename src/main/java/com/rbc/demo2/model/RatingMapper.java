package com.rbc.demo2.model;

import java.util.Objects;

public class RatingMapper {

    Rating rating;

    public RatingMapper(Rating rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RatingMapper))
            return false;
        RatingMapper other = (RatingMapper) obj;
        return Objects.equals(rating.getCustomerId(), other.rating.getCustomerId())
                || rating.getItem().getItemId() == other.rating.getItem().getItemId();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    // public class ItemWrapper {

    // Item item;

    // ItemWrapper(Item item) {
    // this.item = item;
    // }

    // @Override
    // public boolean equals(Object obj) {
    // if (!(obj instanceof ItemWrapper)) return false;
    // ItemWrapper other = (ItemWrapper) obj;
    // return Objects.equals(item.name, other.item.name) ||
    // item.price == other.item.price;
    // }

    // @Override
    // public int hashCode() {
    // return 1;
    // }
    // }
}
