package com.pluralsight.Sandwiches;

import com.pluralsight.Topping;

public class BLT extends Sandwich {

    public BLT() {
        super("8", "White");
        initializeDefaultToppings();
        setToasted(true);
    }

    private void initializeDefaultToppings() {
        addTopping(new Topping("Bacon", "Premium Meat", false));
        addTopping(new Topping("Cheddar", "Premium Cheese", false));
        addTopping(new Topping("Lettuce", "Regular", false));
        addTopping(new Topping("Tomato", "Regular", false));
        addTopping(new Topping("Ranch", "Sauce", false));
    }

    // Optional: Resets toppings to the default set if customization was done
    public void resetToDefault() {
        toppings.clear();
        initializeDefaultToppings();
    }
}