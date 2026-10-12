package service;

import model.Product;
import exception.InsufficientStockException;
import exception.InvalidQuantityException;

public class OrderProcessor {

    // Accept quantity as text and convert it to an integer
    public void processOrder(Product product, String quantityText)
            throws InsufficientStockException {

        int quantity;

        try {
            quantity = Integer.parseInt(quantityText);

        } catch (NumberFormatException e) {
            throw new InvalidQuantityException(
                    "Quantity must be a whole number.", e);
        }

        // Reuse the existing integer-based validation
        processOrder(product, quantity);
    }

    // Process an order when quantity is already an integer
    public void processOrder(Product product, int quantity)
            throws InsufficientStockException {

        if (quantity <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than zero.");
        }

        if (quantity > product.getStock()) {
            throw new InsufficientStockException(
                    "Insufficient stock available.");
        }

        product.reduceStock(quantity);

        double total = product.getPrice() * quantity;

        System.out.println("Order processed successfully!");
        System.out.println("Product: " + product.getProductName());
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total amount: Rs. %.2f%n", total);
        System.out.println("Remaining stock: " + product.getStock());
    }
}


