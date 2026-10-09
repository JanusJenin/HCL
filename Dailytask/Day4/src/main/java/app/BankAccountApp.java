
package app;

import model.BankAccount;
import service.BankAccountService;

public class BankAccountApp {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount("Janus", "ACC101", 5000.0);

        BankAccountService service = new BankAccountService();

        service.showAccountDetails(account);

        System.out.println("\n--- Deposit Test ---");
        service.depositMoney(account, 1000.0);

        System.out.println("\n--- Withdrawal Test ---");
        service.withdrawMoney(account, 500.0);

        System.out.println("\n--- Invalid Withdrawal Test ---");
        service.withdrawMoney(account, 10000.0);

        System.out.println("\n--- Invalid Deposit Test ---");
        service.depositMoney(account, 0.0);

        System.out.println("\n--- Final Account Details ---");
        service.showAccountDetails(account);

        System.out.println("\nTotal accounts created: "
                + BankAccount.getAccountCount());
    }
}

