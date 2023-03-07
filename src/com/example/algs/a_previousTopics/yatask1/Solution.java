package com.example.algs.a_previousTopics.yatask1;


import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] counter = new int[256];
        int max = 0;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if(s.length() > 0 && s.charAt(0) == '±'){
                break;
            }
            for (int key : s.toCharArray()) {
                if(Character.isWhitespace(key)) {
                    continue;
                }
                counter[key]++;
                max = Math.max(max, counter[key]);
            }
        }
        max++;

        int[][] rs = new int[max][256];
        int len = 0;
        for (int i = 0; i < 256; i++) {
            if( counter[i] > 0) {
                rs[0][len] = i;
                for (int j = 0; j < counter[i]; j++) {
                    rs[j + 1][len] = '#';
                }
                len++;
            }
        }

        for (int i = max - 1; i >=0; i--) {
            for (int j = 0; j < len; j++) {
                int key = rs[i][j];
                if (key == 0) {
                    key = ' ';
                }
                System.out.print((char) key);
            }
            System.out.println();
        }
    }
}
