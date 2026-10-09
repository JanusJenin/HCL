package payment;

public class UPIPayment extends Payment {

    public UPIPayment(int id, double amount) {
        super(id, amount);
    }

    @Override
    public void pay() {
        System.out.println("Processing UPI payment: Rs. " + amount);
    }
}
