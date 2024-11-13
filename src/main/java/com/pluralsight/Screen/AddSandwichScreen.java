package com.pluralsight.Screen;

import com.pluralsight.Order;
import com.pluralsight.Sandwich;
import com.pluralsight.Topping;
import java.util.List;

public class AddSandwichScreen extends Screen {

    public AddSandwichScreen(Order order) {
        super(order);
    }

    @Override
    public void display() {
        List<String> breadTypes = List.of("White", "Wheat", "Rye", "Wrap");
        List<String> meatOptions = List.of("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon");
        List<String> cheeseOptions = List.of("American", "Provolone", "Cheddar", "Swiss");
        List<String> regularToppings = List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms");
        List<String> sauceOptions = List.of("Mayo", "Mustard", "Ketchup", "BBQ", "Hot Sauce");

        System.out.println("Select sandwich size (4\", 8\", 12\"): ");
        String size = scanner.nextLine();

        String breadType;
        do {
            System.out.println("Select your bread:");
            for (String bread : breadTypes) System.out.println("- " + bread);
            breadType = validateOption(scanner.nextLine().trim(), breadTypes);
        } while (breadType == null);

        Sandwich sandwich = new Sandwich(size, breadType);
        sandwich.setToasted(getYesNoResponse("Do you want it toasted?"));

        // Meat selection
        String meatName;
        do {
            System.out.println("Meat (choose one):");
            for (String meat : meatOptions) System.out.println("- " + meat);
            meatName = validateOption(scanner.nextLine().trim(), meatOptions);
        } while (meatName == null);

        sandwich.addTopping(new Topping(meatName, "Meat", getYesNoResponse("Do you want extra " + meatName + "?")));

        // Cheese selection
        String cheeseName;
        do {
            System.out.println("Cheese (choose one):");
            for (String cheese : cheeseOptions) System.out.println("- " + cheese);
            cheeseName = validateOption(scanner.nextLine().trim(), cheeseOptions);
        } while (cheeseName == null);

        sandwich.addTopping(new Topping(cheeseName, "Cheese", getYesNoResponse("Do you want extra " + cheeseName + "?")));

        // Regular toppings
        System.out.println("Other toppings (type 'done' to finish):");
        for (String topping : regularToppings) System.out.println("- " + topping);

        while (true) {
            String toppingName = scanner.nextLine().trim();
            if (toppingName.equalsIgnoreCase("done")) break;

            String validTopping = validateOption(toppingName, regularToppings);
            if (validTopping != null) {
                sandwich.addTopping(new Topping(validTopping, "Regular", false));
            }
        }

        // Sauce selection
        System.out.println("Choose sauces (type 'done' to finish):");
        for (String sauce : sauceOptions) System.out.println("- " + sauce);

        while (true) {
            String sauceName = scanner.nextLine().trim();
            if (sauceName.equalsIgnoreCase("done")) break;

            String validSauce = validateOption(sauceName, sauceOptions);
            if (validSauce != null) {
                sandwich.addTopping(new Topping(validSauce, "Sauce", false));
            }
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added to order.");
    }
}
