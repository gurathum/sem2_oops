package com.example.lab_7;

public class CheckISBN {
    public static void main(String[] args) {
        String isbn = "1-85671-104-8";
        checkISBN(isbn);
    }

    private static void checkISBN(String isbn) {
        isbn = String.join("", isbn.split("-"));
        String last = Character.toString(isbn.charAt(isbn.length() - 1));

        System.out.println("isbn: " + isbn);
        System.out.println("last: " + last);

        int sum = 0;
        int m = 10;
        for (int i = 0; i < 9; i++) {
            int num = Character.getNumericValue(isbn.charAt(i));
            sum += num * m;
            m--;
        }


        int rem = sum % 11;

        String check_digit = rem == 10 ? "X" : Integer.toString (11 - rem);
        System.out.println("Check digit: " + check_digit);

        if (last.equals(check_digit)) {
            System.out.println("Your ISBN is correct");
        } else {
            System.out.println("Incorrect ISBN, try again!");
        }
    }
}
