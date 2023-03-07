package com.example.algs.d_dpone.yatask25;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        int[] distances = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(distances);
        //System.out.println(Arrays.toString(distances));

        int[] dp = new int[n];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = distances[1] - distances[0];

        int last = distances[1];
        for (int i = 2; i < distances.length; i++) {
            int dist = distances[i];

            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + dist - last;
            //System.out.printf("%d %d %d %d\n", dp[i - 1], dp[i - 2], dist - last, dp[i]);

            last = dist;
        }
        System.out.println(dp[n - 1]);
    }
}
