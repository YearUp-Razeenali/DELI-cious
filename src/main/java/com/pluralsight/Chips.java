package com.pluralsight;

public class Chips {
    private String type;
    private static final double PRICE = 1.50; // All chips cost $1.50

    public Chips(String type) {
        this.type = type;
    }

    public double getPrice() {
        return PRICE;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return "Type: " + type + ", Price: $" + String.format("%.2f", PRICE);
    }
}