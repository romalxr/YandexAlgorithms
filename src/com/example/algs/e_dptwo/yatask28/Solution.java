package com.example.algs.e_dptwo.yatask28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        String line = in.readLine();
        String[] tokens = line.split(" ");
        int n = Integer.parseInt(tokens[0]) + 2;
        int m = Integer.parseInt(tokens[1]) + 2;

        int[][] dp = new int[n][m];

        dp[2][2] = 1;
        for (int i = 3; i < n; i++) {
            for (int j = 3; j < m; j++) {
                dp[i][j] = dp[i - 2][j - 1] + dp[i - 1][j - 2];
            }
        }

        //  for (int[] ints : dp) {
        //    System.out.println(Arrays.toString(ints));
        //  }

        System.out.println(dp[n - 1][m - 1]);
    }
}
