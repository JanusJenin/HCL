
package app;

import model.User;
import model.Customer;
import model.Admin;

import payment.Payment;
import payment.CardPayment;
import payment.UPIPayment;
import payment.CashPayment;
import payment.Refundable;

import strategy.PaymentStrategy;
import strategy.CardPaymentStrategy;
import strategy.UpiPaymentStrategy;

public class PaymentApp {

    public static void main(String[] args) {

        // 1. Inheritance and runtime polymorphism
        Payment payment1 = new CardPayment(1, 500);
        Payment payment2 = new UPIPayment(2, 750);
        Payment payment3 = new CashPayment(3, 300);

        payment1.pay();
        payment2.pay();
        payment3.pay();

        // 2. Refund using interface
        Refundable refundable = (Refundable) payment1;
        refundable.refund(100);

        // 3. Method overloading
        payment1.pay(600);
        payment1.pay(700, "TXN101");

        // 4. Strategy Pattern
        PaymentStrategy strategy1 = new CardPaymentStrategy();
        PaymentStrategy strategy2 = new UpiPaymentStrategy();

        strategy1.pay(1000);
        strategy2.pay(1500);

        // 5. Role hierarchy
        User customer = new Customer(101, "Arun");
        User admin = new Admin(102, "Priya");

        System.out.println(
            "User ID: " + customer.getId()
            + ", Name: " + customer.getName()
            + ", Role: " + customer.getRole()
        );

        System.out.println(
            "User ID: " + admin.getId()
            + ", Name: " + admin.getName()
            + ", Role: " + admin.getRole()
        );
    }
}





