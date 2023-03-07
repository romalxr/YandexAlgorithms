package com.example.algs.a_previousTopics.yatask1.yatask10;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        final int len = word.length();

        final int enLettersSize = 26;
        int firstLetterCode = 97;
        long[] array = new long[enLettersSize];

        long count = len;
        long multiplier = 1;
        for (var i = 0; i < (len + 1) / 2; i++) {
            char letter = word.charAt(i);
            array[letter - firstLetterCode] += count * multiplier;
            count--;
            multiplier++;
        }

        count = len;
        multiplier = 1;
        for (int i = len - 1; i >= (len + 1) / 2; i--) {
            char letter = word.charAt(i);
            array[letter - firstLetterCode] += count * multiplier;
            count--;
            multiplier++;
        }

        for (int i = 0; i < enLettersSize; i++) {
            if (array[i] == 0) {
                continue;
            }
            char letter = (char) (firstLetterCode + i);
            System.out.println("" + letter + ": " + array[i]);
        }
    }
}
