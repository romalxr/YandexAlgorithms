package com.example.algs.a_previousTopics.yatask9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution {

    static int squareSum(int[][] sumMatrix, int xMin, int yMin, int xMax, int yMax) {
        return sumMatrix[xMax][yMax] + sumMatrix[xMin - 1][yMin - 1]
                - sumMatrix[xMax][yMin - 1] - sumMatrix[xMin - 1][yMax];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));

        int[] params = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = params[0];
        int m = params[1];
        int k = params[2];

        n++;
        m++;

        int[][] sumMatrix = new int[n][m];

        for (int i = 1; i < n; i++) {
            int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j < m; j++) {
                sumMatrix[i][j] = -squareSum(sumMatrix, i, j, i, j) + tokens[j - 1];
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(sumMatrix[i]));
//        }

        for (int i = 0; i < k; i++) {
            int[] tokens = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int xMin = tokens[0];
            int yMin = tokens[1];
            int xMax = tokens[2];
            int yMax = tokens[3];
            System.out.println(squareSum(sumMatrix, xMin, yMin, xMax, yMax));
        }
    }
}
