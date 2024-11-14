package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String size;
    private String breadType;
    protected List<Topping> toppings;
    private boolean isToasted;

    // Default base prices by sandwich size
    private static final double BASE_PRICE_4 = 5.50;
    private static final double BASE_PRICE_8 = 7.00;
    private static final double BASE_PRICE_12 = 8.50;

    public Sandwich(String size, String breadType) {
        this.size = size;
        this.breadType = breadType;
        this.toppings = new ArrayList<>();
        this.isToasted = false;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(String toppingName) {
        toppings.removeIf(t -> t.getName().equalsIgnoreCase(toppingName));
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }

    public double calculatePrice() {
        double basePrice = switch (size) {
            case "4" -> BASE_PRICE_4;
            case "8" -> BASE_PRICE_8;
            case "12" -> BASE_PRICE_12;
            default -> 0.0;
        };

        // Add cost for each topping based on size
        for (Topping topping : toppings) {
            basePrice += topping.calculateCostBySize(size);
        }
        return basePrice;
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder("Size: " + size + ", Bread: " + breadType + ", Toppings: ");
        for (Topping topping : toppings) {
            details.append(topping.getDetails()).append(", ");
        }
        details.append(isToasted ? "Toasted" : "Not Toasted");
        return details.toString();
    }
}