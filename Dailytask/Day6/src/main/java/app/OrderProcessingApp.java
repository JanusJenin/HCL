package app;

import model.Product;
import service.OrderProcessor;
import exception.InsufficientStockException;
import exception.InvalidQuantityException;

public class OrderProcessingApp {

    public static void main(String[] args) {

        Product product =
                new Product(101, "Keyboard", 750.0, 5);

        OrderProcessor processor = new OrderProcessor();

        // Test 1: Valid order
        try {
            System.out.println("--- Valid Order ---");
            processor.processOrder(product, 2);

        } catch (InsufficientStockException
                 | InvalidQuantityException e) {

            System.out.println("Order failed: " + e.getMessage());

        } finally {
            System.out.println("[AUDIT] Valid order attempt completed.");
        }

        System.out.println();

        // Test 2: Invalid quantity
        try {
            System.out.println("--- Invalid Quantity Test ---");
            processor.processOrder(product, 0);

        } catch (InsufficientStockException
                 | InvalidQuantityException e) {

            System.out.println("Order failed: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Original cause: "
                        + e.getCause().getClass().getSimpleName());
                System.out.println("Cause message: "
                        + e.getCause().getMessage());
            }

        } finally {
            System.out.println("[AUDIT] Invalid quantity attempt completed.");
        }

        System.out.println();

        // Test 3: Insufficient stock
        try {
            System.out.println("--- Insufficient Stock Test ---");
            processor.processOrder(product, 10);

        } catch (InsufficientStockException
                 | InvalidQuantityException e) {

            System.out.println("Order failed: " + e.getMessage());

            // Print stack trace for debugging
            e.printStackTrace(System.out);

        } finally {
            System.out.println("[AUDIT] Stock validation attempt completed.");
        }

        System.out.println();

        // Test 4: Invalid text input and exception chaining
        try {
            System.out.println("--- Invalid Text Input Test ---");
            processor.processOrder(product, "abc");

        } catch (InsufficientStockException
                 | InvalidQuantityException e) {

            System.out.println("Order failed: " + e.getMessage());

            // Display the original exception
            if (e.getCause() != null) {
                System.out.println("Original cause: "
                        + e.getCause().getClass().getSimpleName());

                System.out.println("Cause message: "
                        + e.getCause().getMessage());
            }

            // Print the complete stack trace
            e.printStackTrace(System.out);

        } finally {
            System.out.println("[AUDIT] Text input attempt completed.");
        }

        System.out.println();

        // Test 5: Decimal text input
        try {
            System.out.println("--- Decimal Text Input Test ---");
            processor.processOrder(product, "2.5");

        } catch (InsufficientStockException
                 | InvalidQuantityException e) {

            System.out.println("Order failed: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Original cause: "
                        + e.getCause().getClass().getSimpleName());
            }

            e.printStackTrace(System.out);

        } finally {
            System.out.println("[AUDIT] Decimal input attempt completed.");
        }

        System.out.println("\nApplication continues running.");
        System.out.println("Final stock: " + product.getStock());
    }
}




