package com.pluralsight.Screen;

import com.pluralsight.Order;

import java.util.List;
import java.util.Scanner;

public abstract class Screen {
    protected static final Scanner scanner = new Scanner(System.in);
    protected Order order;

    public Screen(Order order) {
        this.order = order;
    }

    // Common method for validating yes/no input
    protected boolean getYesNoResponse(String prompt) {
        while (true) {
            System.out.print(prompt + " (yes/no): ");
            String response = scanner.nextLine().trim();
            if (response.equalsIgnoreCase("yes")) {
                return true;
            } else if (response.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
            }
        }
    }

    // Validate input by re-prompting if invalid
    protected String validateOption(String input, List<String> validOptions) {
        while (true) {
            for (String option : validOptions) {
                if (option.equalsIgnoreCase(input)) {
                    return option; // Return correctly formatted option
                }
            }
            System.out.println("Invalid choice, please enter again:");
            input = scanner.nextLine().trim(); // Reprompt user for valid input
        }
    }

    // Abstract method to display the screen's main content
    public abstract void display();
}