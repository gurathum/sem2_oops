package com.example.lab_1;

import java.util.Scanner;
/**
 *
 * @author Gurkirat
 */

public class Arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner object is an instance of Scanner class, used to take input from user

        //*************************//
        // Part 1 - Integer Operations
        System.out.print("Enter number 1: ");
        int num1 = scanner.nextInt(); // num1 variable stores user's first int input

        System.out.print("Enter number 2: ");
        int num2 = scanner.nextInt(); // num2 variable stores user's second int input

        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);

        int result; // result variable is declared to perform int arithmetic operations

        // Addition
        result = num1 + num2;
        System.out.println("Addition: num1 + num2 = " + result);

        // Subtraction
        result = num1 - num2;
        System.out.println("Subtraction: num1 - num2 = " + result);

        // Multiplication
        result = num1 * num2;
        System.out.println("Multiplication: num1 * num2 = " + result);

        // Integer Division
        result = num1 / num2;
        System.out.println("Integer Division: num1 / num2 = " + result);

        // Modulo Operator
        result = num1 % num2;
        System.out.println("Modulo Operator: num1 % num2 = " + result);

        // Increment Operator
        result = ++num1;
        System.out.println("Increment Operator: num1++ = " + result);

        System.out.println("-------------------");

        //*************************//
        // Part 2 - Double Operations
        System.out.print("Enter value for a: ");
        double a = scanner.nextDouble(); // a variable stores first double input from user

        System.out.print("Enter value for b: ");
        double b = scanner.nextDouble(); // b variable stores second double input from user

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        double doubleResult; // doubleResult variable is declared to perform 'double' arithmetic operations

        doubleResult = a/b;
        System.out.println("a/b = " + doubleResult);

        doubleResult = Math.round(a/b);
        System.out.println("Math.round(a/b) = " + doubleResult);

        doubleResult = Math.pow(a, 3);
        System.out.println("Math.pow(a, 3) = " + doubleResult);

        doubleResult = Math.sqrt(b);
        System.out.println("Math.sqrt(b) = " + doubleResult);

    }
}
