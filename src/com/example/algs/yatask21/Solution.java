package com.example.algs.yatask21;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[Math.max(3, n + 1)];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        int pos = 2;
        while (pos++ < n) {
            dp[pos] = dp[pos - 3] + dp[pos - 2] + dp[pos - 1];
        }
        System.out.println(dp[n]);
    }
}
