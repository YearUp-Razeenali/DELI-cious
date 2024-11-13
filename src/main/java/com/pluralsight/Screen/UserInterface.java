package com.pluralsight.Screen;

import com.pluralsight.Order;

import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private Order order;

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("Welcome to DELI-cious");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> startNewOrder();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void startNewOrder() {
        order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("5) List Order");
            System.out.println("0) Cancel Order");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> new AddSandwichScreen(order).display();
                case 2 -> new AddDrinkScreen(order).display();
                case 3 -> new AddChipsScreen(order).display();
                case 4 -> {
                    new CheckoutScreen(order).display();
                    ordering = false;
                }
                case 5 -> new ListOrderScreen(order).display();
                case 0 -> {
                    System.out.println("Order canceled.");
                    ordering = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
