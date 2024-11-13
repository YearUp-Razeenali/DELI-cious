package com.pluralsight;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Welcome to DELI-cious");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1 -> startNewOrder();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void startNewOrder() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1 -> addSandwich(order);
                case 2 -> addDrink(order);
                case 3 -> addChips(order);
                case 4 -> {
                    checkout(order);
                    ordering = false;
                }
                case 0 -> ordering = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addSandwich(Order order) {

        String[] breadTypes = {"White", "Wheat", "Rye", "Wrap"};
        String[] meatOptions = {"Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"};
        String[] cheeseOptions = {"American", "Provolone", "Cheddar", "Swiss"};
        String[] regularToppings = {"Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};
        String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};


        System.out.println("Select sandwich size (4\", 8\", 12\"): ");
        String size = scanner.nextLine();


        System.out.println("Select your bread:");
        for (String bread : breadTypes) {
            System.out.println("- " + bread);
        }
        String breadType = scanner.nextLine();


        Sandwich sandwich = new Sandwich(size, breadType);


        System.out.println("Do you want it toasted? (yes/no): ");
        sandwich.setToasted(scanner.nextLine().equalsIgnoreCase("yes"));

        // Step 4: Add toppings
        System.out.println("Toppings: - you can add extras of each topping");


        System.out.println("Meat (choose one):");
        for (String meat : meatOptions) {
            System.out.println("- " + meat);
        }
        System.out.println("Type the meat you want to add:");
        while (true) {
            String meatName = scanner.nextLine();
            if (isValidOption(meatName, meatOptions)) {
                System.out.println("Do you want extra " + meatName + "? (yes/no): ");
                boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");
                Topping meat = new Topping(meatName, "Meat", isExtra);
                sandwich.addTopping(meat);
                break;
            } else {
                System.out.println("Invalid choice. Please select a meat from the list.");
            }
        }


        System.out.println("Cheese (choose one):");
        for (String cheese : cheeseOptions) {
            System.out.println("- " + cheese);
        }
        System.out.println("Type the cheese you want to add:");
        while (true) {
            String cheeseName = scanner.nextLine();
            if (isValidOption(cheeseName, cheeseOptions)) {
                System.out.println("Do you want extra " + cheeseName + "? (yes/no): ");
                boolean isExtra = scanner.nextLine().equalsIgnoreCase("yes");
                Topping cheese = new Topping(cheeseName, "Cheese", isExtra);
                sandwich.addTopping(cheese);
                break;
            } else {
                System.out.println("Invalid choice. Please select a cheese from the list.");
            }
        }


        System.out.println("Other toppings:");
        for (String topping : regularToppings) {
            System.out.println("- " + topping);
        }
        System.out.println("Type the topping you want to add, or type 'done' if finished with other toppings:");
        while (true) {
            String toppingName = scanner.nextLine();
            if (toppingName.equalsIgnoreCase("done")) break;
            if (isValidOption(toppingName, regularToppings)) {
                Topping topping = new Topping(toppingName, "Regular", false);
                sandwich.addTopping(topping);
            } else {
                System.out.println("Invalid choice. Please select a topping from the list.");
            }
        }


        System.out.println("Select sauces:");
        for (String sauce : sauces) {
            System.out.println("- " + sauce);
        }
        System.out.println("Type the sauce you want to add, or type 'done' if finished with sauces:");
        while (true) {
            String sauceName = scanner.nextLine();
            if (sauceName.equalsIgnoreCase("done")) break;
            if (isValidOption(sauceName, sauces)) {
                Topping sauce = new Topping(sauceName, "Sauce", false);
                sandwich.addTopping(sauce);
            } else {
                System.out.println("Invalid choice. Please select a sauce from the list.");
            }
        }


        order.addSandwich(sandwich);
    }

    private static boolean isValidOption(String input, String[] options) {
        for (String option : options) {
            if (option.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }


    private static void addDrink(Order order) {
        // Display drink options with prices
        System.out.println("Select drink size:");
        System.out.println("- Small - $2.00");
        System.out.println("- Medium - $2.50");
        System.out.println("- Large - $3.00");

        // Step 1: Ask for the drink size
        System.out.println("Enter your choice (Small, Medium, Large): ");
        String size = scanner.nextLine();

        // Validate size choice
        while (!size.equalsIgnoreCase("Small") && !size.equalsIgnoreCase("Medium") && !size.equalsIgnoreCase("Large")) {
            System.out.println("Invalid choice. Please select Small, Medium, or Large.");
            size = scanner.nextLine();
        }

        // Step 2: Ask for the quantity
        System.out.println("How many " + size + " drinks would you like to add?");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        // Validate quantity input
        while (quantity <= 0) {
            System.out.println("Please enter a positive quantity:");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
        }

        // Step 3: Add the specified quantity of drinks to the order
        for (int i = 0; i < quantity; i++) {
            Drink drink = new Drink(size);
            order.addDrink(drink);
        }

        System.out.println("Added " + quantity + " " + size + " drink(s) to the order.");
    }

    private static void addChips(Order order) {
        System.out.println("Enter chip type (e.g., BBQ, Sour Cream): ");
        String chipType = scanner.nextLine();

        order.addChips(chipType);
    }

    private static void checkout(Order order) {
        System.out.println("Checking out...");
        System.out.println(order.getOrderDetails());
        System.out.println("Order Total: $" + order.calculateTotal());

        Receipt receipt = new Receipt(order);
        receipt.saveReceipt();
    }
}