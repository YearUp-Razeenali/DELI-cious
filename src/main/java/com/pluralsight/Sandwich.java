package com.pluralsight;

public class Sandwich {
    private String size;
    private String breadType;
    private boolean isToasted;

    public Sandwich(String size, String breadType) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = false;
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }

    public double calculatePrice() {
        return 0.0;
    }
}
