package com.pluralsight;

public class Topping {
    private String name;        // Name of the topping
    private String type;        // Type (e.g., "Regular", "Premium")
    private double baseCost;    // Cost of the topping


    public Topping(String name, String type, double baseCost) {
        this.name = name;
        this.type = type;
        this.baseCost = baseCost;
    }


    public Topping(String name, double baseCost) {
        this(name, "Regular", baseCost); // Calls the primary constructor with "Regular" as the default type
    }


    public double getCost() {
        return baseCost;
    }


    public String getDetails() {
        return name + " (" + type + ")";
    }

        public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }
}
