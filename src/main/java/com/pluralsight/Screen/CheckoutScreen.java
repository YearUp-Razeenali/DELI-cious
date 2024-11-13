package com.pluralsight.Screen;

import com.pluralsight.Order;
import com.pluralsight.Receipt;

public class CheckoutScreen extends Screen {

    public CheckoutScreen(Order order) {
        super(order);
    }

    @Override
    public void display() {
        System.out.println("Checking out...");
        System.out.println(order.getOrderDetails());
        System.out.println("Order Total: $" + String.format("%.2f", order.calculateTotal()));

        Receipt receipt = new Receipt(order);
        receipt.saveReceipt();
    }
}
