package com.pluralsight.Screen;

import com.pluralsight.Order;

public class ListOrderScreen extends Screen {

    public ListOrderScreen(Order order) {
        super(order);
    }

    @Override
    public void display() {
        System.out.println("Current Order:");
        System.out.println(order.getOrderDetails());
        System.out.println("Order Total (so far): $" + String.format("%.2f", order.calculateTotal()));
    }
}
