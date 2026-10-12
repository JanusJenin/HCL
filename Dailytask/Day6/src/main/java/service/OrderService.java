package service;

import model.Order;
import exception.InvalidOrderException;

public class OrderService {

    public void processOrder(Order order)
            throws InvalidOrderException {

        if (order.getAmount() <= 0) {
            throw new InvalidOrderException(
                    "Invalid order amount. Amount must be greater than zero.");
        }

        System.out.println("Order processed successfully!");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.printf("Order Amount: Rs. %.2f%n",
                order.getAmount());
    }
}

