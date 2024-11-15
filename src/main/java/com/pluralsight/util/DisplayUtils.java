package com.pluralsight.util;

public class DisplayUtils {

    // Existing main menu and sandwich menu headers
    public static final String MAIN_MENU_HEADER = """
            ===================================
                   WELCOME TO DELI-cious!
            ===================================
            1) New Order
            0) Exit
            ===================================
            """;

    public static final String SANDWICH_MENU_HEADER = """
            ===================================
                   SANDWICH CUSTOMIZER
            ===================================
            1) Add Sandwich
            2) Add Drink
            3) Add Chips
            4) Add Signature Sandwich
            5) List Order
            6) Checkout
            0) Cancel Order
            ===================================
            """;

    // Specific screens for adding items
    public static final String ADD_SANDWICH_HEADER = """
            ===================================
                   ADD A SANDWICH
            ===================================
            Choose your sandwich size, bread, and toppings:
            """;

    public static final String ADD_DRINK_HEADER = """
            ===================================
                     ADD A DRINK
            ===================================
            Choose your drink size and quantity:
            """;

    public static final String ADD_CHIPS_HEADER = """
            ===================================
                     ADD CHIPS
            ===================================
            Choose your chip flavor and quantity:
            """;

    public static final String ADD_SIGNATURE_SANDWICH_HEADER = """
            ===================================
               ADD A SIGNATURE SANDWICH
            ===================================
            Select from our signature sandwich options:
            """;

    // New screens for viewing the current order and checkout process
    public static final String CURRENT_ORDER_HEADER = """
            ===================================
                     CURRENT ORDER
            ===================================
            Here are the items in your order so far:
            """;

    public static final String CHECKOUT_SUMMARY_HEADER = """
            ===================================
                    CHECKOUT SUMMARY
            ===================================
            Finalizing your order. Please review:
            """;

    public static final String THANK_YOU_MESSAGE = """
            ===================================
                THANK YOU FOR ORDERING!
            ===================================
            We appreciate your business! Enjoy your meal.
            """;

    public static final String THANK_YOU_FOR_VISIT = """
            ===================================
                THANK YOU FOR VISITING!
               We hope to see you again.
            ===================================
            """;


    // Utility method to print any text block
    public static void printTextBlock(String textBlock) {
        System.out.print(textBlock);
    }
}
