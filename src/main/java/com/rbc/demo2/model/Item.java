package com.rbc.demo2.model;

// import java.io.Serializable;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name="item")
public class Item {
    
    /**
     *
     */
    // private static final long serialVersionUID = 1L;
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String name;
    private float price;

    // @Autowired
    // Laptop laptop;

    public Item(){

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
    
}
