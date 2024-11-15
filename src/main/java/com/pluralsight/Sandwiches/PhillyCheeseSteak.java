package com.pluralsight.Sandwiches;

import com.pluralsight.Topping;

public class PhillyCheeseSteak extends Sandwich {

    public PhillyCheeseSteak() {
        super("8", "White");
        initializeDefaultToppings();
        setToasted(true);
    }

    private void initializeDefaultToppings() {
        addTopping(new Topping("Steak", "Premium Meat", false));
        addTopping(new Topping("American Cheese", "Premium Cheese", false));
        addTopping(new Topping("Peppers", "Regular", false));
        addTopping(new Topping("Mayo", "Sauce", false));
    }

    public void resetToDefault() {
        toppings.clear();
        initializeDefaultToppings();
    }
}