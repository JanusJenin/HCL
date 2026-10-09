package model;

public class Customer extends User {

    public Customer(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Customer";
    }
}

