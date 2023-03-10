package com.example.algs.a_previousTopics.yatask5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("./input.txt"));
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        long sum = 0;
        for (int i = 1; i < n; i++) {
            int r = scanner.nextInt();
            sum += Math.min(l, r);
            l = r;
        }
        System.out.println(sum);
    }
}
