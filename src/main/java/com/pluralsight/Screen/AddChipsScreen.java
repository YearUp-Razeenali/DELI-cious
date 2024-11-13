package com.pluralsight.Screen;

import com.pluralsight.Order;
import com.pluralsight.Chips;
import java.util.List;

public class AddChipsScreen extends Screen {

    public AddChipsScreen(Order order) {
        super(order);
    }

    @Override
    public void display() {
        List<String> chipTypes = List.of("BBQ", "Sour Cream", "Salted", "Cheddar", "Jalapeno");

        String chipType;
        do {
            System.out.println("Select chip type (all chips are $1.50):");
            for (String chip : chipTypes) System.out.println("- " + chip);
            chipType = validateOption(scanner.nextLine().trim(), chipTypes);
        } while (chipType == null);

        System.out.println("How many bags of " + chipType + " chips would you like to add?");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantity; i++) {
            order.addChips(new Chips(chipType));
        }
        System.out.println(quantity + " bag(s) of " + chipType + " chips added to the order.");
    }
}
