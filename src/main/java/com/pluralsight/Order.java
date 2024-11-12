package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<String> chips;

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

    public void addChips(String chipType) {
        chips.add(chipType);
    }

    // Calculate the total price of the order
    public double calculateTotal() {
        double total = 0.0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculatePrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        total += chips.size() * 1.5;
        return total;
    }

    // Get order details for display
    public String getOrderDetails() {
        // Placeholder to return order summary
        return "Order summary...";
    }
}
