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
        System.out.println("Select size (4\", 8\", 12\"): ");
        String size = scanner.nextLine();

        System.out.println("Select bread type (White, Wheat, Rye, Wrap): ");
        String breadType = scanner.nextLine();

        Sandwich sandwich = new Sandwich(size, breadType);

        System.out.println("Do you want it toasted? (yes/no): ");
        sandwich.setToasted(scanner.nextLine().equalsIgnoreCase("yes"));

        // Add toppings (basic example)
        System.out.println("Add a topping (e.g., Cheese, Meat). Type 'done' to finish:");
        while (true) {
            String toppingName = scanner.nextLine();
            if (toppingName.equalsIgnoreCase("done")) break;

            System.out.println("Enter cost of " + toppingName + ": ");
            double cost = scanner.nextDouble();
            scanner.nextLine();

            sandwich.addTopping(new Topping(toppingName, cost));
        }

        order.addSandwich(sandwich);
    }

    private static void addDrink(Order order) {
        System.out.println("Select drink size (Small, Medium, Large): ");
        String size = scanner.nextLine();

        Drink drink = new Drink(size);
        order.addDrink(drink);
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