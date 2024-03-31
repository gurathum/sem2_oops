package com.example.lab_5;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("singh 1", 101, 5000, "student");
        BankAccount acc2 = new BankAccount("singh 2", 102, 8000, "student");
        BankAccount acc3 = new BankAccount("singh 3", 103, 2000, "student");
        System.out.println("Total accounts: " + BankAccount.getAccountsCount());

        acc1.updateBalance(300, true); // with true, add balance
        acc2.updateBalance(200); // default add balance
        acc3.updateBalance(100);
        acc2.updateBalance(100, false); // withdraw with false parameter
        BankAccount.getTotalDepositWithdraw();

    }
}

class BankAccount {
    private String customerName;
    private int accountNumber;
    private double accountBalance;
    private String accountType;
    private static int accountsCount = 0; // accountsCount variable to track how many accounts are created.
    private static double depositTotal; // total deposit for bank manager
    private static double withdrawTotal; // total withdrawal for bank manager
    public BankAccount() {
        accountBalance = 0;
        accountsCount++;
    }

    public BankAccount(String customerName, int accountNumber, double  accountBalance, String accountType) {
        accountsCount++;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
    }

    // Method to increase the balance
    public void updateBalance(double amount) {
        accountBalance += amount;
        depositTotal += amount;
    }

    // Method to deposit or withdraw: if addAmount true - add amount, if false - deduct amount
    public void updateBalance(double amount, boolean addAmount) {
        // if addAmount is true, deposit amount
        if (addAmount) {
            accountBalance += amount;
            depositTotal += amount;
        } else {
            // if sufficient amount, then withdraw
            if ((accountBalance - amount) >= 0) {
                accountBalance -= amount;
                withdrawTotal += amount;
            } else {
                System.out.println("Insufficient funds. Balance cannot be reduced below 0.");
            }
        }
    }

    // method to update the account number by bank manager
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // A method prints the count of the total number of accounts created
    public static int getAccountsCount() {
        return accountsCount;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public static void getTotalDepositWithdraw() {
        System.out.println("Total deposit: " + depositTotal);
        System.out.println("Total withdraw: " + withdrawTotal);
    }

    public void displayAccount() {
        System.out.println("Customer name: " + customerName);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account balance: " + accountBalance);
        System.out.println("Account type: " + accountType);
    }
}