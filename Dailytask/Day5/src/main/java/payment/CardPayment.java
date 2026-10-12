package payment;

public class CardPayment extends Payment implements Refundable {

    public CardPayment(int id, double amount) {
        super(id, amount);
    }

    @Override
    public void pay() {
        System.out.println("Processing card payment: Rs. " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding Rs. " + amount + " to card.");
    }
}

