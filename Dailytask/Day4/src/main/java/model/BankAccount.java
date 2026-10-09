
package model;

import java.util.Objects;

public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private double balance;

    private static int accountCount = 0;

    // Constructor 1
    public BankAccount() {
        this("Unknown", "NOT-SET", 0.0);
    }

    // Constructor 2
    public BankAccount(String accountHolder, String accountNumber) {
        this(accountHolder, accountNumber, 0.0);
    }

    // Constructor 3
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        accountCount++;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BankAccount)) {
            return false;
        }

        BankAccount other = (BankAccount) obj;
        return Objects.equals(accountNumber, other.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}

