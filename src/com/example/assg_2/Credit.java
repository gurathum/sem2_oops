package com.example.assg_2;

import java.util.Scanner;

public class Credit {
    public static void main(String[] args) {
        // Asking input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter beginning balance: ");
        double balance = scanner.nextDouble();

        System.out.print("Enter monthly interest rate: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter payment amount: ");
        double payment = scanner.nextDouble();

        // initializing variables
        double totalPayments = 0;
        int month = 1;

        // A loop to check until balance is 0 or less
        while (balance > 0) {
            double interest = balance * rate/100; // interest earned by bank on payment
            balance += interest;

            if (balance < payment) {
                System.out.printf("Month: %d, Balance: %.2f, Total Payments: %.2f\n", month, 0.0, totalPayments + balance);
                break;
            }

            balance -= payment; //
            totalPayments += payment; // total payment increased each month payment is made

            System.out.printf("Month: %d, Balance: %.2f, Total Payments: %.2f\n", month, balance, totalPayments);

            month++; // month increased
        }
    }

}
