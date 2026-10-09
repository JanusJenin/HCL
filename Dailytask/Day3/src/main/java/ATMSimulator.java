package Dailytask.Day3.src.main.java;

import java.util.Scanner;

public class ATMSimulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int CORRECT_PIN = 1234;
        int balance = 5000;
        int attempts = 0;
        boolean loggedIn = false;

        // 3 PIN attempts
        while (attempts < 3) {

            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();

            if (pin == CORRECT_PIN) {
                loggedIn = true;
                System.out.println("Login successful!");
                break;
            } else {
                attempts++;
                System.out.println("Invalid PIN.");

                if (attempts < 3) {
                    System.out.println("Please try again.");
                    continue;
                }
            }
        }

        // Account blocked
        if (!loggedIn) {
            System.out.println("Maximum attempts reached.");
            System.out.println("Account blocked.");
            scanner.close();
            return;
        }

        // ATM Menu
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    int deposit = scanner.nextInt();

                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Deposit successful.");
                        System.out.println("Updated Balance: ₹" + balance);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawal = scanner.nextInt();

                    if (withdrawal <= 0) {
                        System.out.println("Invalid amount.");
                    } else if (withdrawal > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdrawal;
                        System.out.println("Withdrawal successful.");
                        System.out.println("Remaining Balance: ₹" + balance);
                    }
                    break;

                case 4:
                    System.out.println("\n===== MINI STATEMENT =====");

                    int[] transactions = {
                        1000, -500, 2000, -1000
                    };

                    for (int transaction : transactions) {
                        System.out.println(transaction);
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    System.out.println("Please try again.");
                    continue;
            }

        } while (choice != 5);

        scanner.close();
    }
}
