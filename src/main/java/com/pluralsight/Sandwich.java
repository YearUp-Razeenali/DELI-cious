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
        // Placeholder for price calculation logic
        return 0.0;
    }

    // Get sandwich details for display
    public String getDetails() {
        // Placeholder to return sandwich details
        return "Size: " + size + ", Bread: " + breadType;
    }
}