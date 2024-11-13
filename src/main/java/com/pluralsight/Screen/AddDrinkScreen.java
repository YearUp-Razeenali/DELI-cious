package com.pluralsight.Screen;

import com.pluralsight.Order;
import com.pluralsight.Drink;
import java.util.List;

public class AddDrinkScreen extends Screen {

    public AddDrinkScreen(Order order) {
        super(order);
    }

    @Override
    public void display() {
        List<String> drinkSizes = List.of("Small", "Medium", "Large");

        String size;
        do {
            System.out.println("Select drink size:");
            for (String s : drinkSizes) System.out.println("- " + s);
            size = validateOption(scanner.nextLine().trim(), drinkSizes);
        } while (size == null);

        System.out.println("How many " + size + " drinks would you like to add?");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantity; i++) {
            order.addDrink(new Drink(size));
        }
        System.out.println(quantity + " " + size + " drink(s) added to the order.");
    }
}
