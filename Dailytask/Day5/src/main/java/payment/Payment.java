
package payment;

import model.BaseEntity;

public abstract class Payment extends BaseEntity {

    protected double amount;

    public Payment(int id, double amount) {
        super(id);
        this.amount = amount;
    }

    // Abstract method: implemented by child classes
    public abstract void pay();

    // Method overloading: one parameter
    public void pay(double amount) {
        System.out.println("Payment amount: Rs. " + amount);
    }

    // Method overloading: two parameters
    public void pay(double amount, String reference) {
        System.out.println(
            "Payment amount: Rs. " + amount
            + ", Reference: " + reference
        );
    }

    public double getAmount() {
        return amount;
    }
}




