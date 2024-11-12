package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String size;
    private String breadType;
    private List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(String size, String breadType) {
        this.size = size;
        this.breadType = breadType;
        this.toppings = new ArrayList<>();
        this.isToasted = false;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }

    public double calculatePrice() {
        double basePrice = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0.0;
        };

        // Add cost for premium toppings
        for (Topping topping : toppings) {
            basePrice += topping.getCost();
        }
        return basePrice;
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder("Size: " + size + ", Bread: " + breadType + ", Toppings: ");
        for (Topping topping : toppings) {
            details.append(topping.getName()).append(", ");
        }
        details.append(isToasted ? "Toasted" : "Not Toasted");
        return details.toString();
    }
}