package com.example.algs.d_dpone.yatask23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];
        int[] dpt = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;
        dpt[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1];
            dpt[i] = i - 1;
            if (i % 2 == 0 && dp[i / 2] < dp[i]) {
                dp[i] = dp[i / 2];
                dpt[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i / 3] < dp[i]) {
                dp[i] = dp[i / 3];
                dpt[i] = i / 3;
            }
            dp[i]++;
        }

        List<Integer> path = new ArrayList<>();
        path.add(n);

        int pos = dpt[n];
        while (pos > 0) {
            path.add(pos);
            pos = dpt[pos];
        }

        System.out.println(dp[n]);
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
}
