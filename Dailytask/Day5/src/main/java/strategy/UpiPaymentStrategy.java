package strategy;

public class UpiPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println(
            "Strategy: Paying Rs. " + amount + " using UPI."
        );
    }
}

