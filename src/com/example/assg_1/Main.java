package com.example.assg_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Take salary input from user
        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();

        // Calculate tax for person1 with CalcTax class
        CalcTax person1 = new CalcTax(salary);
        person1.displayTax();
    }
}

class CalcTax {
    private final double salary;

    // Constructor function to set salary variable
    public CalcTax(double salary) {
        this.salary = salary;
    }

    // Method for calculating CPP Tax
    public double calcCPP() {
        final double MAX = 66000; // Max. deduction limit
        final double MIN = 3500; // Min. deduction limit
        final double RATE = 5.95; // deduction rate

        double result;
        if (salary > MAX) {
            result = (MAX - MIN) * (RATE / 100);
        } else {
            result = (salary - MIN) * (RATE / 100);
        }

        return result; // return CPP tax value
    }

    // Method for calculating EI Tax
    public double calcEI() {
        final double RATE = 1.63; // Rate for EI deduction

        return (salary/100) * RATE; // return EI tax value

    }

    // calcTaxBracket() is a general method for calculating tax in a Tax Bracket based on 2 (double) arrays - limits and rates which contain respective tax brackets and rate values.
    public double calcTaxBracket(double[] limits, double[] rates) {
        double rate; // rate value
        double lower; // lower value
        double higher; // higher value
        double result = 0; // resulting tax

        // "for loop" going through every value and assigns first value as lower starting from 0 and next as higher
        // for the last element comes, higher is assigned 999999 or any arbitrary large value
        // ⚠ be aware that limits and rates array must have same number of elements
        for (int i = 0; i < limits.length; i++) {
            int n = limits.length; // limits array length
            lower = limits[i];

            higher = (i == n-1) ? 999999 : limits[i + 1];
            rate = rates[i];

            // if salary is within a tax bracket, break and return the result
            if (salary > lower && salary < higher) {
                result = (salary) * (rate/100);
                break;
            }
        }

        return result;
    }

    // method to calculate Federal Tax
    public double calcFederalTax() {
        double[] limits = {0, 53359, 106717, 165430, 235675};
        double[] rates = {15, 20.5, 26, 29, 33};

        return calcTaxBracket(limits, rates); // uses calcTaxBracket() function
    }

    // method to calculate Ontario Tax
    public double calcOntarioTax() {
        double[] limits = {0, 49231, 98463, 150000, 220000};
        double[] rates = {5.05, 9.15, 11.16, 12.16, 13.16};

        return calcTaxBracket(limits, rates); // uses calcTaxBracket() function
    }

    // method to display tax output
    public void displayTax() {
        double netSalary = salary - (calcFederalTax() + calcOntarioTax() + calcEI() + calcCPP());
        System.out.println("Total Federal tax Deduction: " + calcFederalTax());
        System.out.println("Total Ontario Tax Deduction: " + calcOntarioTax());
        System.out.println("Total EI Deduction: " + calcEI());
        System.out.println("Total CPP Deduction: " + calcCPP());
        System.out.println("Total Net Salary after the deductions: " + netSalary);
    }
}