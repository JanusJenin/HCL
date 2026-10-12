package strategy;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println(
            "Strategy: Paying Rs. " + amount + " using Card."
        );
    }
}

