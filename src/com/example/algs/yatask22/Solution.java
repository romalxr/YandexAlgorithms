package com.example.algs.yatask22;

//import java.util.Arrays;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + k + 1];
        for (int i = 0; i < k; i++) {
            dp[i] = 0;
        }
        dp[k] = 1;
        dp[k + 1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i + k] = dp[i + k - 1] * 2 - dp[i - 1];
            //System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[n + k - 1]);
    }
}
