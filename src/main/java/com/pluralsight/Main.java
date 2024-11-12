package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to DELI-cious");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                    startNewOrder();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using DELI-cious!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void startNewOrder() {
        Order order = new Order();
        System.out.println("New order started.");

        // Simple placeholder - Add Sandwich and Drink
        Sandwich sandwich = new Sandwich("8\"", "White");
        Drink drink = new Drink("Small", 2.00);

        order.addSandwich(sandwich);
        order.addDrink(drink);

        System.out.println("Order total: $" + order.calculateTotal());
        System.out.println("Order complete.");
    }
}