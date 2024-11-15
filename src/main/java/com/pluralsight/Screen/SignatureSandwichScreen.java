package com.pluralsight.Screen;

import com.pluralsight.Order;
import com.pluralsight.Sandwiches.BLT;
import com.pluralsight.Sandwiches.PhillyCheeseSteak;
import com.pluralsight.Sandwiches.Sandwich;
import com.pluralsight.Topping;

import java.util.Arrays;
import java.util.List;

public class SignatureSandwichScreen extends Screen {

    private final List<String> validToppings = Arrays.asList(
            "Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos",
            "Cucumbers", "Pickles", "Guacamole", "Mushrooms"
    );

    public SignatureSandwichScreen(Order order) {
        super(order);
    }

    @Override
    public void display() {
        System.out.println("Choose a Signature Sandwich:");
        System.out.println("1) BLT");
        System.out.println("2) Philly Cheese Steak");
        System.out.println("0) Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Sandwich sandwich = null;
        if (choice == 1) {
            sandwich = new BLT();
        } else if (choice == 2) {
            sandwich = new PhillyCheeseSteak();
        } else {
            return;
        }

        System.out.println("You selected: " + sandwich.getDetails());

        if (getYesNoResponse("Would you like to customize your sandwich?")) {
            customizeSandwich(sandwich);
        }

        order.addSandwich(sandwich); // Add to the order
        System.out.println("Signature Sandwich added to order.");
    }

    private void customizeSandwich(Sandwich sandwich) {
        boolean customizing = true;
        while (customizing) {
            System.out.println("1) Add Topping");
            System.out.println("2) Remove Topping");
            System.out.println("0) Done");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTopping(sandwich);
                case 2 -> removeTopping(sandwich);
                case 0 -> customizing = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addTopping(Sandwich sandwich) {
        System.out.println("Available toppings:");
        for (String topping : validToppings) {
            System.out.println("- " + topping);
        }

        // Display current toppings already on the sandwich
        if (!sandwich.getToppings().isEmpty()) {
            System.out.println("Current toppings on your sandwich:");
            for (Topping topping : sandwich.getToppings()) {
                System.out.println("- " + topping.getName());
            }
        } else {
            System.out.println("No toppings on your sandwich yet.");
        }

        System.out.println("Enter the name of the topping to add (type 'done' to finish):");
        while (true) {
            String toppingName = scanner.nextLine().trim();
            if (toppingName.equalsIgnoreCase("done")) {
                break;
            }

            // Convert user input to lowercase for case-insensitive comparison
            String normalizedTopping = toppingName.toLowerCase();

            // Check if the topping name is in the valid toppings list (case-insensitive)
            boolean isValidTopping = validToppings.stream()
                    .anyMatch(validTopping -> validTopping.equalsIgnoreCase(normalizedTopping));

            if (!isValidTopping) {
                System.out.println("Invalid topping. Please choose from the list:");
                for (String validTopping : validToppings) {
                    System.out.println("- " + validTopping);
                }
                continue;
            }

            // Check if the topping is already on the sandwich to prevent duplicates
            boolean alreadyAdded = sandwich.getToppings().stream()
                    .anyMatch(t -> t.getName().equalsIgnoreCase(toppingName));

            if (alreadyAdded) {
                System.out.println("This topping is already on your sandwich. Please choose another topping.");
            } else {
                // Add the topping with the original user input's casing
                sandwich.addTopping(new Topping(toppingName, "Regular", false));
                System.out.println("Added " + toppingName + " to your sandwich.");
            }
        }
    }


    private void removeTopping(Sandwich sandwich) {
        System.out.println("Current toppings on your sandwich:");
        List<Topping> currentToppings = sandwich.getToppings();

        if (currentToppings.isEmpty()) {
            System.out.println("No toppings to remove.");
            return;
        }

        for (Topping topping : currentToppings) {
            System.out.println("- " + topping.getName());
        }

        System.out.println("Enter the name of the topping to remove (type 'done' to finish):");
        while (true) {
            String toppingName = scanner.nextLine().trim();
            if (toppingName.equalsIgnoreCase("done")) {
                break;
            }

            // Validate and remove the topping if it exists on the sandwich
            boolean toppingExists = currentToppings.stream()
                    .anyMatch(t -> t.getName().equalsIgnoreCase(toppingName));

            if (toppingExists) {
                sandwich.removeTopping(toppingName);
                System.out.println("Removed " + toppingName + " from your sandwich.");
            } else {
                System.out.println("Topping not found on your sandwich. Please choose from the current toppings.");
            }
        }
    }
}
