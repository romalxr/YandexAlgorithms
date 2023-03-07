package com.example.algs.e_dptwo.yatask26;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        String line = in.readLine();
        String[] tokens = line.split(" ");
        int n = Integer.parseInt(tokens[0]) + 1;
        int m = Integer.parseInt(tokens[1]) + 1;

        int[][] dp = new int[n][m];
        for (int i = 2; i < n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int j = 2; j < m; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n; i++) {
            line = in.readLine();
            int[] values = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + values[j - 1];
            }
        }

        System.out.println(dp[n - 1][m - 1]);
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
    }
}
