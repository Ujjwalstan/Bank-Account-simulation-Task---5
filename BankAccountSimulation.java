
// BankAccountSimulation.java
// Written by a student for internship task

import java.util.*;

class Account {
    private String accountHolderName;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String name, double initialBalance) {
        this.accountHolderName = name;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created for " + name + " with balance: Rs." + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: Rs." + amount + " | Balance: Rs." + balance);
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: Rs." + amount + " | Balance: Rs." + balance);
            System.out.println("Amount withdrawn successfully!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println("Enter initial deposit amount:");
        double initial = sc.nextDouble();

        Account acc = new Account(name, initial);

        while (true) {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;
                case 3:
                    acc.checkBalance();
                    break;
                case 4:
                    acc.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Account Simulation. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
