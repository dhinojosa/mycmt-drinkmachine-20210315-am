package com.jitterted;

public class Ingredient implements Comparable<Ingredient> {
  private final IngredientName name;
  private final double cost;
  private InventoryLevel stock = new InventoryLevel(0);

  public Ingredient(IngredientName name, double cost) {
    this.name = name;
    this.cost = cost;
    this.stock = new InventoryLevel(10);
  }

  public int getStock() {
    return stock.getStock();
  }

  public void setStock(int stock) {
    this.stock = new InventoryLevel(stock);
  }

  public int compareTo(Ingredient ingredient) {
    return name.compareTo(ingredient.name);
  }

  public double getCost() {
    return cost;
  }

  public IngredientName getName() {
    return name;
  }

}
