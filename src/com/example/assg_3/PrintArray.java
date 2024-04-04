package com.example.assg_3;

import java.util.Arrays;

public class PrintArray {
    static void printArray(int[][] array_2d) {
        System.out.println(Arrays.deepToString(array_2d).replace("], ", "],\n"));
    }

    public static void printArray(Object[][] array_2d) {
        System.out.println(Arrays.deepToString(array_2d).replace("], ", "],\n"));
    }

    public static void printArray(double[][] array_2d) {
        System.out.println(Arrays.deepToString(array_2d).replace("], ", "],\n"));
    }
}
