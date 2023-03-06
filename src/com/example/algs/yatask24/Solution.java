package com.example.algs.yatask24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int a;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;

        int b_minus_1;
        int c_minus_1 = Integer.MAX_VALUE;

        int c_minus_2;

        long dp = 0;
        long dp_minus_1 = 0;
        long dp_minus_2 = 0;
        long dp_minus_3;

        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            c_minus_2 = c_minus_1;
            b_minus_1 = b;
            c_minus_1 = c;

            dp_minus_3 = dp_minus_2;
            dp_minus_2 = dp_minus_1;
            dp_minus_1 = dp;

            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[1]);
            c = Integer.parseInt(tokens[2]);

            dp = Math.min(Math.min(a + dp_minus_1, b_minus_1 + dp_minus_2), c_minus_2 + dp_minus_3);
            //System.out.println(dp);
        }

        System.out.println(dp);
    }
}
