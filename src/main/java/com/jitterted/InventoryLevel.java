package com.jitterted;

public class InventoryLevel {
    private int stock;

    public InventoryLevel(int initialStock) {
        this.stock = initialStock;
    }

    //Goal: To Remove this
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
