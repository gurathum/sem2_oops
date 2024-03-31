package com.example.lab_7;

import java.util.*;


public class Reverse {
    public static void main(String[] args) {
//        String str = "Hi!, how are you? Go to the main menu.";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String str = scanner.nextLine();

        // words array from original string
        String[] words = str.split(" ");

        // reversed words array
        String[] wordsReversed = new String[words.length];


        int n = words.length;
        for (int i = 0; i < n; i++) {
            String word = words[i];

            // reversedWord using reverseWord() method
            String reversedWord = reverseWord(word);
            wordsReversed[i] = reversedWord; //
        }

        System.out.println(str);
        System.out.println(String.join(" ", wordsReversed));
    }

    private static String reverseWord(String word) {
        Stack<Character> stack = new Stack<>();
        HashMap<Integer, Character> punctuationMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);

            // Check if it's a letter or number, push to stack
            if (Character.isLetter(c) || Character.isDigit(c) ) {
                stack.push(c);
            }
            // if it's not a letter, add index and punctuation to punctuationMap
            else {
                punctuationMap.put(i, c);
            }
        }

        // new reversed variable as StringBuilder
        StringBuilder reversed = new StringBuilder(word.length());
        for (int i = 0; i < word.length(); i++) {
            // if index i is in punctuationMap
            if (punctuationMap.containsKey(i)) {
                // append the punctuation at that index to reversed
                reversed.append(punctuationMap.get(i));
            } else {
                // else append the last element of stack to reversed
                reversed.append(stack.pop());
            }
        }

        // return reversed string
        return reversed.toString();
    }
}

/**
public class Reverse {
    public static void main(String[] args) {
        String str = "Go to the main menu.";

        String[] strArray = str.split(" ");
//        System.out.println(Arrays.toString(strArray));

        String[] reverseWordArray = new String[strArray.length];
//        System.out.println(Arrays.toString(reverseWordArray));


        int n = strArray.length;
        for (int i = 0; i < n; i++) {
            String word = strArray[i];
            String reversedWord = "";

            for (char j : word.toCharArray()) {
                reversedWord = j + reversedWord;
            }

            reverseWordArray[i] = reversedWord;
        }

        System.out.println(Arrays.toString(reverseWordArray));
        System.out.println(String.join(" ", reverseWordArray));
    }
}
*/