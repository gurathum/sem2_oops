package com.example.lab_6;

public class NearlyZero {
    public static void main(String[] args) {
        int[] data = {3, 7, -2, 4, 12, 31, 8, 2, -1};
        int nearestToZero = findNearestElement(data);

        System.out.println("The element nearest to zero is: " + nearestToZero);

    }

    private static int findNearestElement(int[] data) {
        int nearestValue = data[0]; // first element

        // loop through each element of data array
        for (int num: data) {
            // Compare the absolute value of the current element with the current nearestValue
            // Using absolute value, we consider both positive and negative distances from zero
            if (Math.abs(num) < nearestValue) {
                nearestValue = num;
            }
        }

        return nearestValue;
    }
}