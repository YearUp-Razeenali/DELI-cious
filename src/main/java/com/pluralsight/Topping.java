package com.pluralsight;

public class Topping {
    private String name;
    private String type;
    private double baseCost;
    private boolean isExtra;

    // Default costs for each size (4", 8", 12") for meats and cheeses
    private static final double MEAT_COST_4 = 1.00;
    private static final double MEAT_COST_8 = 2.00;
    private static final double MEAT_COST_12 = 3.00;

    private static final double CHEESE_COST_4 = 0.75;
    private static final double CHEESE_COST_8 = 1.50;
    private static final double CHEESE_COST_12 = 2.25;

    // Extra costs for additional meat or cheese
    private static final double EXTRA_MEAT_COST_4 = 0.50;
    private static final double EXTRA_MEAT_COST_8 = 1.00;
    private static final double EXTRA_MEAT_COST_12 = 1.50;

    private static final double EXTRA_CHEESE_COST_4 = 0.30;
    private static final double EXTRA_CHEESE_COST_8 = 0.60;
    private static final double EXTRA_CHEESE_COST_12 = 0.90;

    public Topping(String name, String type, boolean isExtra) {
        this.name = name;
        this.type = type;
        this.isExtra = isExtra;
        this.baseCost = 0.0; // Default for regular toppings (no cost)
    }

    public double calculateCostBySize(String size) {
        if (type.equalsIgnoreCase("Premium Meat")) {
            switch (size) {
                case "4\"": return isExtra ? EXTRA_MEAT_COST_4 : MEAT_COST_4;
                case "8\"": return isExtra ? EXTRA_MEAT_COST_8 : MEAT_COST_8;
                case "12\"": return isExtra ? EXTRA_MEAT_COST_12 : MEAT_COST_12;
            }
        } else if (type.equalsIgnoreCase("Premium Cheese")) {
            switch (size) {
                case "4\"": return isExtra ? EXTRA_CHEESE_COST_4 : CHEESE_COST_4;
                case "8\"": return isExtra ? EXTRA_CHEESE_COST_8 : CHEESE_COST_8;
                case "12\"": return isExtra ? EXTRA_CHEESE_COST_12 : CHEESE_COST_12;
            }
        }
        // Regular toppings, sauces, and sides are free
        return 0.0;
    }

    public String getDetails() {
        return name + " (" + type + ")";
    }
}
