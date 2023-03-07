package com.example.algs.e_dptwo.yatask29;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        String line = in.readLine();
        int n = Integer.parseInt(line) + 1;

        int[] prices = new int[n];
        int coupons = 0;
        for (int i = 1; i < n; i++) {
            line = in.readLine();
            int price = Integer.parseInt(line);
            if (price > 100) {
                coupons++;
            }
            prices[i] = price;
        }
        //System.out.println(Arrays.toString(prices));

        final int MAX = 33333;
        final int BIG = 100;
        coupons += 3;

        int[][] dp = new int[n][coupons];
        for (int i = 1; i < n; i++) {
            dp[i][0] = MAX;
            dp[i][coupons - 1] = MAX;
        }
        for (int j = 2; j < coupons; j++) {
            dp[0][j] = MAX;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < coupons - 1; j++) {
                if (prices[i] > BIG) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + prices[i], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + prices[i], dp[i - 1][j + 1]);
                }
            }
        }

//        System.out.println("dp:");
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
//        System.out.println("---");

        int min = MAX;
        int couponsCount = 0;
        for (int j = 0; j < coupons; j++) {
            if (dp[n - 1][j] <= min) {
                min = dp[n - 1][j];
                couponsCount = j;
            }
        }

        int wasted = 0;
        int j = couponsCount;
        int day = n - 1;
        StringBuilder ans = new StringBuilder();
        while (day > 0) {

            if (dp[day][j] == dp[day - 1][j + 1]) {
                //System.out.println("day " + day + ": " + dp[day][j]);
                //System.out.println("added");
                ans.insert(0, " ").insert(0, day);
                j++;
                wasted++;
            } else if (prices[day] > BIG) {
                j--;
            }
            day--;
        }

        System.out.println(min);
        System.out.println((couponsCount - 1) + " " + wasted);
        System.out.println(ans);
    }
}

