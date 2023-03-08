package com.example.algs.e_dptwo.yatask30;

import com.example.algs.util.LogUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("./input.txt"));
        int n = Integer.parseInt(scanner.nextLine().trim());
        n++;
        String line = "0 " + scanner.nextLine();
        int[] nums1 = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = Integer.parseInt(scanner.nextLine().trim());
        m++;
        line = "0 " + scanner.nextLine();
        int[] nums2 = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[n][m];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        LogUtil.printDp(dp);
        int i = n - 1;
        int j = m - 1;
        StringBuilder ans = new StringBuilder();
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                ans.insert(0," ").insert(0, nums1[i]);
                i--;
                j--;
            }
        }
        System.out.println(ans);
    }
}
