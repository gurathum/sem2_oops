package com.example.lab_4;

public class Main {
    public static void main(String[] args) {
        System.out.println("*******Flow 1******");
        flow1();
        System.out.println("*******Flow 2******");
        flow2();
        System.out.println("*******Flow 3******");
        flow3();
    }


    public static void flow1() {
        int sum = 0;
        int limit = 10;
        for (int i = 0; i < limit; i++) {
            if (i%3 == 0 || i%5==0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void flow2() {
        int numberTable = 6;
        double sum = 0;
        for (double i = 1; i < 10; i ++) {
            System.out.println(numberTable + " * " + i + " = " + (numberTable * i));
            if (numberTable * i <= 20) {
                sum = sum + (numberTable * i) + i/2;
            }
        }
        System.out.println(sum);
        System.out.println(sum % 2 == 0 ? "Even" : "Odd");

    }
    public static void flow3() {
        StringBuilder outputStr = new StringBuilder();
        for (int a = 10; a > 0; a--) {
            for (int i = 1; i <= a; i++) {
               outputStr.append(" *");
            }
            outputStr.append("\n");
        }

        System.out.println(outputStr);
    }

}
