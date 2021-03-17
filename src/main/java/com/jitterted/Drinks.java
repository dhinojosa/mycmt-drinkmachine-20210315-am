package com.jitterted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drinks {
    private final List<Drink> drinkList = new ArrayList<Drink>();

    public Drinks() {
    }

    void createDrinks(List<Ingredient> ingredientList) {
        RecipeFactory recipeFactory = new RecipeFactory(ingredientList);
        drinkList.add(new Drink("Coffee", recipeFactory.create("Coffee",
            "Coffee", "Coffee", "Sugar", "Cream")));
        drinkList.add(new Drink("Decaf Coffee", recipeFactory.create(
            "Decaf " +
            "Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream")));
        drinkList.add(new Drink("Caffe Latte", recipeFactory.create(
            "Espresso"
            , "Espresso", "Steamed Milk")));
        drinkList.add(new Drink("Caffe Americano", recipeFactory.create(
            "Espresso", "Espresso", "Espresso")));
        drinkList.add(new Drink("Caffe Mocha", recipeFactory.create(
            "Espresso"
            , "Cocoa", "Steamed Milk", "Whipped Cream")));
        drinkList.add(new Drink("Cappuccino", recipeFactory.create(
            "Espresso"
            , "Espresso", "Steamed Milk", "Foamed Milk")));

        Collections.sort(drinkList);
    }

    void updateDrinkList(List<Ingredient> ingredientList) {
        for (Drink drink : drinkList) {
            double cost = 0;
            Recipe recipe = drink.getRecipe();
            for (Ingredient ingredient : ingredientList) {
                if (recipe.hasIngredient(ingredient)) {
                    cost += ingredient.getCost() * recipe.quantityNeededFor(ingredient);
                }
            }
            drink.setCost(cost);
        }
    }

    boolean isValidDrinkChoice(String input) {
        return Integer.parseInt(input) > 0 && Integer.parseInt(input) <= drinkList.size();
    }

    Drink drinkChoice(String input) {
        return drinkList.get(Integer.parseInt(input) - 1);
    }

    void updateMakeable() {
        for (Drink drink : drinkList) {
            drink.updateDrinkState();
        }
    }

    void displayDrinkMenu() {
        System.out.println("\nDrink Menu:\n");
        int count = 1;
        for (Drink d : drinkList) {
            System.out.printf("%d,%s,$%.2f," + d.getMakeable() + "\n\n",
                count, d.getName(), d.getCost());
            count++;
        }
    }
}
