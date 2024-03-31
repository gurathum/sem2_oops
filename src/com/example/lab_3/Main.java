package com.example.lab_3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner object is an instance of Scanner class, used to take input from user
        System.out.println("******* Add items to cart *******");

        // ****** Taking inputs from user ******
        System.out.print("Number of bolts: ");
        int numBolts = scanner.nextInt(); // numBolts variable stores number of bolts in cart

        System.out.print("Number of nuts: ");
        int numNuts = scanner.nextInt(); // numNuts variable stores number of nuts in cart

        System.out.print("Number of washers: ");
        int numWashers = scanner.nextInt(); // numWashers variable stores number of washers in cart

        // ******* Using Order class to store variables and display output *********
        Order order1 = new Order(numBolts,numNuts,numWashers);
    }
}

class Order {
    final int boltPrice = 6; // constant bolt price
    final int nutPrice = 4; // constant nut price
    final int washerPrice = 2; // constant washer price
    private int boltsCount; // number of bolts
    private int nutsCount; // number of nuts
    private int washersCount; // number of washers

    public Order(int boltsCount, int nutsCount, int washersCount) {
        this.boltsCount = boltsCount;
        this.nutsCount = nutsCount;
        this.washersCount = washersCount;
        this.displayOrder(); // calling displayOrder() method to display output
    }

    // returns the message to be displayed
    public String checkCount() {
        String message = "Order is OK"; // message to be printed out
        if (nutsCount < boltsCount) { // loop to check if nuts are at least the number of bolts
            message = "Check the Order: too few nuts!";
            if (washersCount < boltsCount * 2) { // Nested loop to combine message and check if washers are at least the double the bolts
                message += " Check the order: too few washers!";
            }
        } else if (washersCount < boltsCount*2) { // loop to check if washers are at least the double the bolts
            message = "Check the order: too few washers!";
        }
        return message;
    }

    // Prints the output to console
    public void displayOrder() {
        System.out.println("******* Your Order *******");
        System.out.println("Number of bolts: " + boltsCount);
        System.out.println("Number of nuts: " + nutsCount);
        System.out.println("Number of washers: " + washersCount);
        System.out.println(checkCount());
        int totalCost = boltPrice*boltsCount + nutPrice*nutsCount + washerPrice*washersCount;
        System.out.println("Total cost: " + totalCost);
    }

}
