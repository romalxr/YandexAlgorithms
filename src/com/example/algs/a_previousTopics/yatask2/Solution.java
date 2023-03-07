package com.example.algs.a_previousTopics.yatask1.yatask2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxReplace = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();

        int max = 0;
        int enLettersSize = 26;
        int firstLetterCode = 97;
        for (int i = 0; i < enLettersSize; i++) {
            char letter = (char) (firstLetterCode + i);
            int replacesHave = maxReplace;
            int ans = 0;
            int right = 0;
            for (int left = 0; left < str.length(); left++) {
                while (replacesHave >= 0 && right < str.length()) {
                    if (str.charAt(right) != letter) {
                        replacesHave--;
                    }
                    if (replacesHave != -1) {
                        ans = right - left + 1;
                    }
                    if (ans > max) {
                        max = ans;
                    }
                    right++;
                }
                if (str.charAt(left) != letter) {
                    replacesHave++;
                }
            }
        }

        System.out.println(max);
    }
}
