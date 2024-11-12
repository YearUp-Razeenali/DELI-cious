//package com.pluralsight;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class Receipt {
//    private Order order;
//    private String timestamp;
//
//    public Receipt(Order order) {
//        this.order = order;
//        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
//    }
//
//    // Save receipt to a text file
//    public void saveReceipt() {
//        String fileName = "receipts/" + timestamp + ".txt";
//        try (FileWriter writer = new FileWriter(fileName)) {
//            writer.write("Order Receipt\n");
//            writer.write("Timestamp: " + timestamp + "\n");
//            writer.write(order.getOrderDetails());
//            writer.write("Total: $" + order.calculateTotal() + "\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
