package com.example.algs.a_previousTopics.yatask8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));

        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = 0;
        int yMax = 0;

        int k = Integer.parseInt(in.readLine());
        for (int i = 0; i < k; i++) {
            int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = tokens[0];
            int y = tokens[1];

            xMin = Math.min(x, xMin);
            yMin = Math.min(y, yMin);
            xMax = Math.max(x, xMax);
            yMax = Math.max(y, yMax);
        }

        System.out.printf("%d %d %d %d", xMin, yMin, xMax, yMax);
    }
}
