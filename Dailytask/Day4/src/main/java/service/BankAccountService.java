
package service;

import model.BankAccount;

public class BankAccountService {

    public void showAccountDetails(BankAccount account) {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.printf("Balance: Rs. %.2f%n", account.getBalance());
    }

    public void depositMoney(BankAccount account, double amount) {
        if (account.deposit(amount)) {
            System.out.printf("Deposit successful: Rs. %.2f%n", amount);
        } else {
            System.out.println("Deposit failed: Amount must be greater than zero.");
        }
    }

    public void withdrawMoney(BankAccount account, double amount) {
        if (account.withdraw(amount)) {
            System.out.printf("Withdrawal successful: Rs. %.2f%n", amount);
        } else {
            System.out.println("Withdrawal failed: Invalid amount or insufficient balance.");
        }
    }
}

