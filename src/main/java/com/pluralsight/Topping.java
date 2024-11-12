package com.pluralsight;

public class Topping {
    private String name;
    private String type;
    private double baseCost;

    public Topping(String name, String type, double baseCost) {
        this.name = name;
        this.type = type;
        this.baseCost = baseCost;
    }

    public double getCost() {
        return baseCost;
    }

    // Get topping details for display
    public String getDetails() {
        return name + " (" + type + ")";
    }
}