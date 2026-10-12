package app;

import model.Order;
import service.OrderService;
import exception.InvalidOrderException;

public class OrderApp {

    public static void main(String[] args) {

        OrderService service = new OrderService();

        try {
            Order order1 = new Order(101, 1500.0);
            service.processOrder(order1);

            System.out.println();

            Order order2 = new Order(102, -500.0);
            service.processOrder(order2);

        } catch (InvalidOrderException e) {
            System.out.println("Order failed: " + e.getMessage());

        } finally {
            System.out.println("Order processing attempt completed.");
        }

        System.out.println("Application continues running.");
    }
}

