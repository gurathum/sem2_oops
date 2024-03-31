package com.example.assg_2;

import java.util.Scanner;

public class NumberTransformer {
    public static void main(String[] args) {

        // asking input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        // loop until n != 1
        while (n != 1) {
            if (n % 2 == 0) {
                System.out.println(n + " - even, next value is " + n/2);
                n = n/2;
            } else {
                System.out.println(n + " - odd, next value is " + (3*n + 1));
                n = 3*n + 1;
            }
        }

        System.out.println("New value of n  = " + n);

    }
}
