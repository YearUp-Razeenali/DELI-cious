package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double calculateTotal() {
        double total = 0.0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculatePrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chips chip : chips) {
            total += chip.getPrice();
        }

        return total;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder("Order Details:\n");

        for (Sandwich sandwich : sandwiches) {
            details.append("Sandwich: \n").append(sandwich.getDetails()).append("\n");
        }
        for (Drink drink : drinks) {
            details.append("Drink: \n").append(drink.getDetails()).append("\n");
        }
        for (Chips chip : chips) {
            details.append("Chips: \n").append(chip.getDetails()).append("\n");
        }

        return details.toString();
    }
}
