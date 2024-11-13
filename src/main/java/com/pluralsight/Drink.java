package com.pluralsight;

public class Drink {
    private String size;
    private double price;

    public Drink(String size) {
        this.size = capitalize(size);
        this.price = switch (this.size) {
            case "Small" -> 2.00;
            case "Medium" -> 2.50;
            case "Large" -> 3.00;
            default -> 0.0;
        };
    }

    private String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return "Size: " + size + ", Price: $" + String.format("%.2f", price);
    }
}
