package payment;

public class CashPayment extends Payment {

    public CashPayment(int id, double amount) {
        super(id, amount);
    }

    @Override
    public void pay() {
        System.out.println("Processing cash payment: Rs. " + amount);
    }
}
