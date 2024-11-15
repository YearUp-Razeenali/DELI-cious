package com.pluralsight.Screen;

import com.pluralsight.Order;
import com.pluralsight.util.DisplayUtils;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private Order order;

    public void start() {
        boolean running = true;

        while (running) {
            // Print the main menu using DisplayUtils
            DisplayUtils.printTextBlock(DisplayUtils.MAIN_MENU_HEADER);
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1 -> startNewOrder();
                case 0 -> {
                    DisplayUtils.printTextBlock(DisplayUtils.THANK_YOU_FOR_VISIT);
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void startNewOrder() {
        order = new Order();
        boolean ordering = true;

        while (ordering) {
            // Print the sandwich menu using DisplayUtils
            DisplayUtils.printTextBlock(DisplayUtils.SANDWICH_MENU_HEADER);
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (choice) {
                case 1 -> {
                    DisplayUtils.printTextBlock(DisplayUtils.ADD_SANDWICH_HEADER);
                    new AddSandwichScreen(order).display();
                }
                case 2 -> {
                    DisplayUtils.printTextBlock(DisplayUtils.ADD_DRINK_HEADER);
                    new AddDrinkScreen(order).display();
                }
                case 3 -> {
                    DisplayUtils.printTextBlock(DisplayUtils.ADD_CHIPS_HEADER);
                    new AddChipsScreen(order).display();
                }
                case 4 -> {
                    DisplayUtils.printTextBlock(DisplayUtils.ADD_SIGNATURE_SANDWICH_HEADER);
                    new SignatureSandwichScreen(order).display();
                }
                case 5 -> {
                    DisplayUtils.printTextBlock(DisplayUtils.CURRENT_ORDER_HEADER);
                    new ListOrderScreen(order).display();
                }
                case 6 -> {
                    DisplayUtils.printTextBlock(DisplayUtils.CHECKOUT_SUMMARY_HEADER);  // Show checkout summary header
                    new CheckoutScreen(order).display();  // Display order details as part of checkout
                    DisplayUtils.printTextBlock(DisplayUtils.THANK_YOU_MESSAGE);  // Show thank you message after checkout
                    ordering = false;
                }
                case 0 -> {
                    System.out.println("Order canceled.");
                    ordering = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
