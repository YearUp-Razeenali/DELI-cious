package com.pluralsight;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

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
            scanner.nextLine();

            switch (choice) {
                case 1 -> addSandwich(order);
                case 2 -> addDrink(order);
                case 3 -> addChips(order);
                case 4 -> checkout(order);
                case 0 -> ordering = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addSandwich(Order order) {
        // Placeholder to add sandwich logic
        System.out.println("Adding sandwich...");
    }

    private static void addDrink(Order order) {
        // Placeholder to add drink logic
        System.out.println("Adding drink...");
    }

    private static void addChips(Order order) {
        // Placeholder to add chips logic
        System.out.println("Adding chips...");
    }

    private static void checkout(Order order) {
        System.out.println("Checking out...");
        System.out.println("Order Total: $" + order.calculateTotal());
//        Receipt receipt = new Receipt(order);
//        receipt.saveReceipt();
        System.out.println("Receipt saved.");
    }
}