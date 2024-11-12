package com.pluralsight;

public class Drink {
    private String size;
    private double price;

    public Drink(String size) {
        this.size = size;
        this.price = switch (size) {
            case "Small" -> 2.00;
            case "Medium" -> 2.50;
            case "Large" -> 3.00;
            default -> 0.0;
        };
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return "Size: " + size + ", Price: $" + price;
    }
}